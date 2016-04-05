package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * Xxx price code ( adult movies :))
 */
public class Xxx extends PriceCode {
    public Xxx() {
        setName("Xxx");
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 4) {
            amount += (daysRented - 4) * 1.5;
        }
        return amount;
    }
}
