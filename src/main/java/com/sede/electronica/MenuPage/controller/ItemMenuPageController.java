package com.sede.electronica.MenuPage.controller;

import com.sede.electronica.MenuPage.dto.ItemMenuDto;
import com.sede.electronica.MenuPage.entity.ItemMenuPage;
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
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "${communication.context.path}/ItemMenuPrincipal")
public class ItemMenuPageController {

    @Autowired
    MenuPageService menuPageService;

    @Autowired
    ItemMenuPageService itemMenuPageService;

    @PostMapping("/ItemCreateMenu")
    public ResponseEntity<?> create(@Valid @RequestBody ItemMenuPage itemMenuPage, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseHandler.generateResponse("Invalid fields", HttpStatus.BAD_REQUEST,null);
        }

        ItemMenuPage itemMenuPages = itemMenuPageService.save(itemMenuPage);
        return ResponseHandler.generateResponse("Successfull Child menu", HttpStatus.OK,itemMenuPages);
    }

    @GetMapping("/getItem/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id){
        Optional<ItemMenuPage> getmenuItem = itemMenuPageService.getMenuItem(id);
        return ResponseHandler.generateResponse("Successfull menu", HttpStatus.OK,getmenuItem);
    }
}
