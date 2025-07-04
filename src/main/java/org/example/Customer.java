package org.example;

public class Customer {
    private String name;
    private double balance;
    public Customer(String name , double balance){
        this.name=name;
        this.balance=balance;

    }


    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void pay (double amountToPay){
        if (balance < amountToPay){
            throw new IllegalArgumentException("Insufficient balance.");
        }else
            balance -= amountToPay;
    }


}
