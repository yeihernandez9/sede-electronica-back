package com.sede.electronica.security.controller;

import com.sede.electronica.Response.ResponseHandler;
import com.sede.electronica.security.Response.ResponseJwt;
import com.sede.electronica.security.dto.JwtDto;
import com.sede.electronica.security.dto.LoginUser;
import com.sede.electronica.security.dto.MessageJwt;
import com.sede.electronica.security.dto.NewUser;
import com.sede.electronica.security.entity.Rol;
import com.sede.electronica.security.entity.User;
import com.sede.electronica.security.enums.RolName;
import com.sede.electronica.security.jwt.JwtProvider;
import com.sede.electronica.security.service.RolService;
import com.sede.electronica.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> userNew(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return ResponseHandler.generateResponse("Invalid fields",HttpStatus.BAD_REQUEST,null);
        if(userService.existsByUserName(newUser.getUserName()))
            return ResponseHandler.generateResponse("User already exists",HttpStatus.BAD_REQUEST,null);
        if(userService.existsByEmail(newUser.getEmail()))
            return ResponseHandler.generateResponse("Email already exists",HttpStatus.BAD_REQUEST,null);
        User user =
                new User(newUser.getName(), newUser.getUserName(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return ResponseHandler.generateResponse("successfull",HttpStatus.CREATED,user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return ResponseHandler.generateResponse("Invalid fields",HttpStatus.BAD_REQUEST,null);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt);
        return ResponseJwt.generateResponseJwt("Successfull login",HttpStatus.OK,userDetails, jwt);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return ResponseJwt.generateResponseJwt("Successfull refresh token",HttpStatus.OK,null, token);
    }
}
