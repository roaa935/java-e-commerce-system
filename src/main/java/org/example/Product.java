package org.example;

public abstract class Product {
    protected String name;
    private double price ;
    private int quantity;

    public Product(String name , double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock!");
        }
        quantity -= amount;
    }

    public abstract void displayInfo();

}
