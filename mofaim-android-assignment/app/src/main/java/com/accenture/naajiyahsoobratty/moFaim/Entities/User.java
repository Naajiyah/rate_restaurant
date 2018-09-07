package com.accenture.naajiyahsoobratty.moFaim.Entities;

import java.io.Serializable;

public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String password;
    private String email;

    public User() {}

    public User(Integer userId,String userName, String email, String password) {

        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userId=userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}