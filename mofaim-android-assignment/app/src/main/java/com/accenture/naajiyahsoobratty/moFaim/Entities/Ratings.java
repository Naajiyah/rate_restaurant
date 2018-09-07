package com.accenture.naajiyahsoobratty.moFaim.Entities;

import java.io.Serializable;

public class Ratings implements Serializable{
    private Integer restaurant_id;
    private Integer user_id;
    private Integer ratings;

    public Ratings() {
    }

    public Ratings(Integer restaurant_id, Integer user_id, Integer ratings) {
        this.restaurant_id = restaurant_id;
        this.user_id = user_id;
        this.ratings = ratings;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }
}
