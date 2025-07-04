package org.example;
import java.util.*;
import org.example.Product;
public class Cart {
    private Map<Product,Integer> items = new LinkedHashMap<>();

    public void add(Product product, int amount){
        if(amount>product.getQuantity()){
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        items.put(product,amount);
    }

    public void updateQuantity(Product product, int chang) {
        Integer current = items.get(product);
        if (current == null) {
            throw new IllegalArgumentException("Product not in cart.");
        }

        int newAmount = current + chang;

        if (newAmount > product.getQuantity()) {
            throw new IllegalArgumentException("Exceeds available stock.");
        }

        if (newAmount <= 0) {
            items.remove(product);
        } else {
            items.put(product, newAmount);
        }
    }

    public Map<Product, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }




}
