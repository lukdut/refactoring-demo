package com.scrumtrek.simplestore.pricecodes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serge on 05.04.2016.
 */
public class RegularTest {
    @Test
    public void getAmountOnTwoDays() throws Exception {
        Regular ch = new Regular();
        double amount = ch.getAmount(2);
        assertEquals(2, amount, 0);
    }

    @Test
    public void getAmountOnThreeDays() throws Exception {
        Regular ch = new Regular();
        double amount = ch.getAmount(3);
        assertEquals(3.5, amount, 0);
    }
}