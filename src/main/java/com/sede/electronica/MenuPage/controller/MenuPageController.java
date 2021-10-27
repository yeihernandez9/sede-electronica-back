package com.sede.electronica.MenuPage.controller;

import com.sede.electronica.MenuPage.entity.MenuPage;
import com.sede.electronica.MenuPage.service.ItemMenuPageService;
import com.sede.electronica.MenuPage.service.MenuPageService;
import com.sede.electronica.Response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "${communication.context.path}/menuPrincipal")
public class MenuPageController {

    @Autowired
    MenuPageService menuPageService;

    @Autowired
    ItemMenuPageService itemMenuPageService;

    @PostMapping("/createMenu")
    public ResponseEntity<?> create(@Valid @RequestBody MenuPage menuPage, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseHandler.generateResponse("Invalid fields", HttpStatus.BAD_REQUEST,null);
        }

        MenuPage createmenu = menuPageService.save(menuPage);
        return ResponseHandler.generateResponse("Successfull menu", HttpStatus.OK,createmenu);
    }

    @GetMapping("/getMenu")
    public ResponseEntity<?> getMenu(){
        List<MenuPage> getmenu = menuPageService.getMenu();
        return ResponseHandler.generateResponse("Successfull menu", HttpStatus.OK,getmenu);
    }

    @GetMapping("/getMenuItem/{id}")
    public ResponseEntity<?> getMenuItem(@PathVariable int id){
        Optional<MenuPage> getmenuItem = menuPageService.getMenuItem(id);
        return ResponseHandler.generateResponse("Successfull menu", HttpStatus.OK,getmenuItem);
    }

    @PutMapping("/updateMenu")
    public ResponseEntity<?> update(@Valid @RequestBody MenuPage menuPage, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseHandler.generateResponse("Invalid fields", HttpStatus.BAD_REQUEST,null);
        }

        MenuPage updatemenu = menuPageService.update(menuPage);
        return ResponseHandler.generateResponse("Successfull menu", HttpStatus.OK,updatemenu);
    }

}
