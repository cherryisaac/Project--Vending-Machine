package com.techelevator.view;

public class Gum extends Item {

    public Gum(String name, double price, Integer quantity ) {
        super(name, price, quantity);
    }

    @Override
    public String getSound() {
        return "\"Chew Chew, Yum!\"";
    }
}
