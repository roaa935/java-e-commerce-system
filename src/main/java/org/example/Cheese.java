package org.example;
import java.time.LocalDate;
import org.example.Expirable;
import org.example.Product;
import org.example.Shippable;

public class Cheese extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;
    private double weight;

    public Cheese(String name , double price,int quantity, LocalDate expiryDate, double weight) {
        super(name,price,quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (Cheese) expires on " + expiryDate + ", weight: " + weight + "kg");
    }
}
