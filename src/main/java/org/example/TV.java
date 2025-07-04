package org.example;

public class TV extends Product implements Shippable {
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (TV), weight: " + weight + "kg");
    }
}
