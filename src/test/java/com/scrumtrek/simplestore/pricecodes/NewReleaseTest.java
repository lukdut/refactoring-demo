package com.scrumtrek.simplestore.pricecodes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serge on 05.04.2016.
 */
public class NewReleaseTest {
    @Test
    public void getAmountOnThreeDays() throws Exception {
        NewRelease ch = new NewRelease();
        double amount = ch.getAmount(3);
        assertEquals(9, amount, 0);
    }
}