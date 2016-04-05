package com.scrumtrek.simplestore.pricecodes;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serge on 05.04.2016.
 */
public class XxxTest {
    @Test
    public void getAmountOnFourDays() throws Exception {
        Xxx ch = new Xxx();
        double amount = ch.getAmount(4);
        assertEquals(2, amount, 0);
    }

    @Test
    public void getAmountOnFiveDays() throws Exception {
        Xxx ch = new Xxx();
        double amount = ch.getAmount(5);
        assertEquals(3.5, amount, 0);
    }

    @Test
    public void suchAsRegularmountOnFiveDays() throws Exception {
        Xxx xx = new Xxx();
        double amountX = xx.getAmount(1);

        Regular reg = new Regular();
        double amountR = reg.getAmount(1);
        assertEquals(amountR, amountX, 0);
    }
}