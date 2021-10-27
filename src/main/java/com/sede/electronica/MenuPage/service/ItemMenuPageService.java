package com.sede.electronica.MenuPage.service;

import com.sede.electronica.MenuPage.entity.ItemMenuPage;
import com.sede.electronica.MenuPage.entity.MenuPage;
import com.sede.electronica.MenuPage.repository.ItemMenuPageRepository;
import com.sede.electronica.MenuPage.repository.MenuPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemMenuPageService {
    @Autowired
    MenuPageRepository menuPageRepository;

    @Autowired
    ItemMenuPageRepository itemMenuPageRepository;

    public ItemMenuPage save(ItemMenuPage itemMenuPage) {

        Optional<MenuPage> optionalMenuPage = menuPageRepository.findById(itemMenuPage.getId());
        if (!optionalMenuPage.isPresent()) {
            return null;
        }

        itemMenuPage.setMenuPage(optionalMenuPage.get());
        itemMenuPage.setId(0);
        ItemMenuPage saveItemMenu = itemMenuPageRepository.save(itemMenuPage);


        return saveItemMenu;
    }

    public Optional<ItemMenuPage> getMenuItem(int id) {
        Optional<ItemMenuPage> optionalMenuPage = itemMenuPageRepository.findById(id);
        return optionalMenuPage;
    }
}
