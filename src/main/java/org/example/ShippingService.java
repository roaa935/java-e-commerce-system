package org.example;

import java.util.Map;

public class ShippingService {
    public static void assignToDelivery(Map<Product, Integer> shippables, String deliveryMan) {
        System.out.println("\n📦 ShippingService: assigning to delivery man " + deliveryMan);

        for (Map.Entry<Product, Integer> entry : shippables.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("→ %dx %s\n", quantity, product.getName());
        }

        System.out.println("✔️ All items assigned to " + deliveryMan + ".");
    }
}
