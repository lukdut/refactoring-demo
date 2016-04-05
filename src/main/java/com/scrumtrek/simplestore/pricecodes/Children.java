package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * Childern movies
 */
public class Children extends PriceCode {

    public Children() {
        setName("Children");
    }

    @Override
    public double getAmount(int daysRented) {
        double amount = 1.50;

        if (daysRented > 3) {
            amount = (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
