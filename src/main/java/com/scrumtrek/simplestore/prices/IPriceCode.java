package com.scrumtrek.simplestore.prices;

public interface IPriceCode {
    /**
     * calculates amount
     * @param daysRented
     * @return rent amount depends on realization
     */
    double getRentAmount(int daysRented);
}
