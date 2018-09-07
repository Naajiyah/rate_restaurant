package com.accenture.naajiyahsoobratty.moFaim.Entities;

import java.io.Serializable;

public class Menu implements Serializable{

    private Integer menuId;
    private String menuName;
    private Integer price;
    private String details;
    private String image;
    private Integer RestaurantId;


    public Menu() {}

    public Menu(Integer menuId, String menuName, Integer price, String details, String image, Integer restaurantId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.price = price;
        this.details = details;
        this.image = image;
        RestaurantId = restaurantId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        RestaurantId = restaurantId;
    }
}