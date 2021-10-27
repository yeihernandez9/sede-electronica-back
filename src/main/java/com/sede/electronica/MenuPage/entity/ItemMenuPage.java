package com.sede.electronica.MenuPage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ItemMenuPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String path;
    @NotNull
    private String name;
    private String targe;
    private String description;
    private int position;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menupage_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MenuPage menuPage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getTarge() {
        return targe;
    }

    public void setTarge(String targe) {
        this.targe = targe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuPage getMenuPage() {
        return menuPage;
    }

    public void setMenuPage(MenuPage menuPage) {
        this.menuPage = menuPage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
