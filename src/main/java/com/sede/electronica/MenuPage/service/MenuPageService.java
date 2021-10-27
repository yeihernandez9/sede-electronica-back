package com.sede.electronica.MenuPage.service;

import com.sede.electronica.MenuPage.entity.MenuPage;
import com.sede.electronica.MenuPage.repository.ItemMenuPageRepository;
import com.sede.electronica.MenuPage.repository.MenuPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MenuPageService {
   @Autowired
    MenuPageRepository menuPageRepository;

   @Autowired
    ItemMenuPageRepository itemMenuPageRepository;

    public MenuPage save(@Valid MenuPage itemMenuDto) {
        MenuPage menuPage = menuPageRepository.save(itemMenuDto);
        return menuPage;
    }

    public List<MenuPage> getMenu(){
        List<MenuPage> optionalMenuPage = menuPageRepository.findAll();
        return optionalMenuPage;
    }

    public Optional<MenuPage> getMenuItem(int id) {
        Optional<MenuPage> optionalMenuPage = menuPageRepository.findById(id);
        return optionalMenuPage;
    }

    public MenuPage update(@Valid MenuPage itemMenuDto) {
        MenuPage menuPage = menuPageRepository.save(itemMenuDto);
        return menuPage;
    }
}
