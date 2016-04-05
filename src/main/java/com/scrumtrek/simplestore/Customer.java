package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Class customer. Contains it`s rentals
 * and call reportBuilder to create reports.
 */
public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private double discount = 0.0;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public String getName() {
        return name;
    }


    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

