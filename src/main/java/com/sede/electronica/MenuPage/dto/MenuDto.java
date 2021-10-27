package com.sede.electronica.MenuPage.dto;

import javax.validation.constraints.NotNull;

public class MenuDto {
    private String url;
    private String path;
    private String name;
    private String targe;
    private String description;

    public MenuDto(String url, String path, String name, String targe, String description) {
        this.url = url;
        this.path = path;
        this.name = name;
        this.targe = targe;
        this.description = description;
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
}
