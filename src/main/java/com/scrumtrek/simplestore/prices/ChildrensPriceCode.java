package com.scrumtrek.simplestore.prices;

/**
 * Created by USER on 04.04.2016.
 */
public class ChildrensPriceCode implements IPriceCode{
    @Override
    public double getRentAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
        {
            amount = (daysRented - 3) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return 0;
    }
}
