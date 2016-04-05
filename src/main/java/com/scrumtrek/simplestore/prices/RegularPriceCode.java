package com.scrumtrek.simplestore.prices;

public class RegularPriceCode implements IPriceCode {
    protected double BASE_AMOUNT = 2.0;
    protected double DAYS_THRESHOLD = 2;

    /**
     * Common for regular movies price value
     * with days threshold
     * @param daysRented
     * @return rentAmount
     */
    @Override
    public double getRentAmount(int daysRented) {
        double amount = BASE_AMOUNT;
        if (daysRented > DAYS_THRESHOLD)
        {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }
}
