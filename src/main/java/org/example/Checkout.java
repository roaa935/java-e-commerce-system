package org.example;

import java.time.LocalDate;
import java.util.Map;

public class Checkout {
    private final Cart cart;
    private final Customer customer;

    private double subtotal = 0;
    private double shippingFee = 0;
    private double totalAmount = 0;

    public Checkout(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
    }

    public void processPayment() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        LocalDate today = LocalDate.now();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Expirable) {
                Expirable expirable = (Expirable) product;
                if (expirable.getExpiryDate().isBefore(today)) {
                    throw new IllegalArgumentException(product.getName() + " is expired.");
                }
            }

            subtotal += product.getPrice() * quantity;

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                shippingFee += shippable.getWeight() * 10;
            }
        }

        totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        customer.pay(totalAmount);

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.reduceQuantity(quantity);
        }

        printReceipt();
        printShipmentNotice();
    }

    public void printReceipt() {
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%dx %-12s %.0f\n", quantity, product.getName(), product.getPrice() * quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shippingFee);
        System.out.printf("Amount           %.0f\n", totalAmount);
        System.out.printf("Balance left     %.0f\n", customer.getBalance());
    }

    public void printShipmentNotice() {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                double itemWeight = shippable.getWeight() * quantity;
                totalWeight += itemWeight;
                System.out.printf("%dx %-12s %.0fg\n", quantity, product.getName(), itemWeight * 1000);
            }
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
