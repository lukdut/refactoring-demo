package com.scrumtrek.simplestore.pricecodes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serge on 05.04.2016.
 */
public class ChildrenTest {
    @Test
    public void getAmountOnThreeDays() throws Exception {
        Children ch = new Children();
        double amount = ch.getAmount(3);
        assertEquals(1.5, amount, 0);
    }

    @Test
    public void getAmountOnFiveDays() throws Exception {
        Children ch = new Children();
        double amount = ch.getAmount(5);
        assertEquals(3.0, amount, 0);
    }
}