package com.techelevator.view;

public class Drink extends Item {

    public Drink(String name, Double price, Integer quantity ) {
        super(name, price, quantity);
    }

    @Override
    public String getSound() {
        return "\"Glug Glug, Yum!\"";
    }

}
