package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.ChildrensPriceCode;
import com.scrumtrek.simplestore.prices.NewReleasePriceCode;
import com.scrumtrek.simplestore.prices.RegularPriceCode;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Created by USER on 05.04.2016.
 */
public class TestPriceCode {

    @Test
    public void testRegularPriceCode(){
        Movie m = new Movie("Regular movie one day",new RegularPriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(2.0, rent.getAmount());
        assertEquals(0, rent.getFrequentPoints());

        m = new Movie("Regular Movie two days",new RegularPriceCode());
        rent = new Rental(m, 3);
        assertEquals(3.5, rent.getAmount());
        assertEquals(0, rent.getFrequentPoints());
    }

    @Test
    public void testChildrensPriceCode(){
        Movie m = new Movie("Childrens movie one day",new ChildrensPriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(1.5, rent.getAmount());
        assertEquals(0, rent.getFrequentPoints());

        m = new Movie("Childrens movie two days",new ChildrensPriceCode());
        rent = new Rental(m, 4);
        assertEquals(1.5, rent.getAmount());
        assertEquals(0, rent.getFrequentPoints());
    }

    @Test
    public void testNewReleasePriceCode(){
        Movie m = new Movie("New release movie one day",new NewReleasePriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(3.0, rent.getAmount());
        assertEquals(0, rent.getFrequentPoints());

        m = new Movie("New release movie two days",new NewReleasePriceCode());
        rent = new Rental(m, 3);
        assertEquals(9.0, rent.getAmount());
        assertEquals(1, rent.getFrequentPoints());
    }
}
