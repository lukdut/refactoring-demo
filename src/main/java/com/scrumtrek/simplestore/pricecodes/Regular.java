package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * Regular movies
 */
public class Regular extends PriceCode {
    public Regular() {
        setName("Regular");
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 2;

        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
