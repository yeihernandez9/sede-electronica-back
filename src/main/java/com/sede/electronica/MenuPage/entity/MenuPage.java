package com.sede.electronica.MenuPage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MenuPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    private String name;
    private String description;
    private int position;

    @OneToMany(mappedBy = "menuPage", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ItemMenuPage> itemMenuPages = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ItemMenuPage> getItemMenuPages() {
        return itemMenuPages;
    }

    public void setItemMenuPages(Set<ItemMenuPage> itemMenuPages) {
        this.itemMenuPages = itemMenuPages;

        for (ItemMenuPage i : itemMenuPages){
            i.setMenuPage(this);
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
