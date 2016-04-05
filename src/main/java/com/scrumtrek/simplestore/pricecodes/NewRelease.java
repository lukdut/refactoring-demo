package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * New release movies
 */
public class NewRelease extends PriceCode {
    public NewRelease() {
        setName("NewRelease");
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3.0;
    }
}
