package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("new customer", 10000);

        Product cheese = new Cheese("Cheese", 100.0, 10, LocalDate.of(2025, 12, 31), 0.2); // 200g
        Product biscuits = new Biscuits("Biscuits", 150.0, 5, LocalDate.of(2025, 10, 1));   // expires
        Product tv = new TV("TV", 500.0, 5, 10);  // 10kg
        Product scratchCard = new ScratchCard("ScratchCard", 50.0, 20);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        try {
            Checkout checkout = new Checkout(cart, customer);
            checkout.processPayment();
        } catch (Exception e) {
            System.out.println("❌ Checkout failed: " + e.getMessage());
        }
    }
}
