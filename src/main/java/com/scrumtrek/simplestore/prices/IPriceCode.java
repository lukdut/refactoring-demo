package com.scrumtrek.simplestore.prices;

/**
 * Interface presents price calculation rules
 */
public interface IPriceCode {
    /**
     * calculates amount
     * @param daysRented
     * @return rent amount depends on realization
     */
    double getRentAmount(int daysRented);
}
