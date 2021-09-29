package com.techelevator.view;

public abstract class Item {


    private String name;
    private Double price;

    private Integer quantity;

    public Item(String name, Double price, int quantity ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void substractQuantity() { this.quantity--; }

    public Integer getQuantity() { return quantity; }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public String getPriceAsString() { return Double.toString(price); }

    public Double getPriceInPennies() {
        return price * 100.00;
    }
}
