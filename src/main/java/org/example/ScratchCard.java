package org.example;

public class ScratchCard extends Product {
    public ScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (Scratch Card)");
    }
}
