package com.scrumtrek.simplestore.pricecodes;

/**
 * Created by serge on 05.04.2016.
 * Base class for all pricecodes
 */
public abstract class PriceCode {
    private String name;

    /**
     * @return pricecode name
     */
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Calculate amount by days.
     * Should be overrided by children.
     *
     * @param daysRented
     * @return
     */
    public abstract double getAmount(int daysRented);
}
