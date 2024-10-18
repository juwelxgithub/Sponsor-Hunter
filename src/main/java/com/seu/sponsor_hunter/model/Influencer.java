package com.seu.sponsor_hunter.model;

import javafx.scene.control.CheckBox;

public class Influencer {
    private String name;
    private double price;
    private double follower;
    private String email;
    private CheckBox select;

    public Influencer(String name, double follower, double price, String email) {
        this.name = name;
        this.price = price;
        this.follower = follower;
        this.email = email;
    }

    public static boolean getCheckBox(CheckBox select){
        return select.isSelected();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFollower() {
        return follower;
    }

    public void setFollower(double follower) {
        this.follower = follower;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
