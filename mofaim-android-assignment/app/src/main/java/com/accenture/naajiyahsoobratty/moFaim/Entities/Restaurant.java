package com.accenture.naajiyahsoobratty.moFaim.Entities;

import java.io.Serializable;

public class Restaurant implements Serializable{
    private Integer restaurant_id;
    private String restaurant_name;
    private String restarant_location;
    private String restarant_phoneNo;
    private Integer restaurant_rating;
    private String restaurant_image;


    public Restaurant() {}

    public Restaurant(Integer restaurant_id, String restaurant_name, String restarant_location, String restarant_phoneNo, Integer restaurant_rating, String restaurant_image) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.restarant_location = restarant_location;
        this.restarant_phoneNo = restarant_phoneNo;
        this.restaurant_rating = restaurant_rating;
        this.restaurant_image=restaurant_image;
    }

    public String getRestaurant_image() {
        return restaurant_image;
    }

    public void setRestaurant_image(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestarant_location() {
        return restarant_location;
    }

    public void setRestarant_location(String restarant_location) {
        this.restarant_location = restarant_location;
    }

    public String getRestarant_phoneNo() {
        return restarant_phoneNo;
    }

    public void setRestarant_phoneNo(String restarant_phoneNo) {
        this.restarant_phoneNo = restarant_phoneNo;
    }

    public Integer getRestaurant_rating() {
        return restaurant_rating;
    }

    public void setRestaurant_rating(Integer restaurant_rating) {
        this.restaurant_rating = restaurant_rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurant_id=" + restaurant_id +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", restarant_location='" + restarant_location + '\'' +
                ", restarant_phoneNo='" + restarant_phoneNo + '\'' +
                ", restaurant_rating=" + restaurant_rating +
                ", restaurant_image='" + restaurant_image + '\'' +
                '}';
    }
}
