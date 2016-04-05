package com.scrumtrek.simplestore.prices;


public class ChildrensPriceCode implements IPriceCode{
    /**
     * Calculate amount with modifier which depends
     * on 3 days threshold
     * @param daysRented
     * @return rentAmount
     */
    @Override
    public double getRentAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
        {
            amount = (daysRented - 3) * 1.5;
        }
        return amount;
    }

}
