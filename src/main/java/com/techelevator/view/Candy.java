package com.techelevator.view;

public class Candy extends Item {


    public Candy(String name, Double price, Integer quantity) {
        super(name, price, quantity);
    }

    @Override
    public String getSound() {
        return "\"Munch Munch, Yum!\"";
    }

}
