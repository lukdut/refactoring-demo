package com.scrumtrek.simplestore.prices;

/**
 * Created by USER on 04.04.2016.
 */
public class NewReleasePriceCode implements IPriceCode {
    @Override
    public double getRentAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return daysRented>1?1:0;
    }
}
