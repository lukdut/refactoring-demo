package com.scrumtrek.simplestore.prices;

/**
 * Created by USER on 04.04.2016.
 */
public class RegularPriceCode implements IPriceCode {
    @Override
    public double getRentAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
        {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return 0;
    }
}
