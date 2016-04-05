package com.scrumtrek.simplestore.prices;

public class NewReleasePriceCode implements IPriceCode {
    @Override
    public double getRentAmount(int daysRented) {
        return daysRented * 3.0;
    }

}
