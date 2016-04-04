package com.scrumtrek.simplestore.prices;

/**
 * Created by USER on 04.04.2016.
 */
public interface IPriceCode {
    public double getRentAmount(int daysRented);
    public int getFrequentPoints(int daysRented);
}
