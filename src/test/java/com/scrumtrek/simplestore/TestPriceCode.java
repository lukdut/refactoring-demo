package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.ChildrensPriceCode;
import com.scrumtrek.simplestore.prices.NewReleasePriceCode;
import com.scrumtrek.simplestore.prices.RegularPriceCode;
import static junit.framework.Assert.*;

import com.scrumtrek.simplestore.prices.XXXPriceCode;
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

        m = new Movie("Regular Movie three days",new RegularPriceCode());
        rent = new Rental(m, 3);
        assertEquals(3.5, rent.getAmount());
    }

    @Test
    public void testChildrensPriceCode(){
        Movie m = new Movie("Childrens movie one day",new ChildrensPriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(1.5, rent.getAmount());

        m = new Movie("Childrens movie four days",new ChildrensPriceCode());
        rent = new Rental(m, 4);
        assertEquals(1.5, rent.getAmount());
    }

    @Test
    public void testNewReleasePriceCode(){
        Movie m = new Movie("New release movie one day",new NewReleasePriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(3.0, rent.getAmount());

        m = new Movie("New release movie three days",new NewReleasePriceCode());
        rent = new Rental(m, 3);
        assertEquals(9.0, rent.getAmount());
    }

    @Test
    public void testXXXPriceCode(){
        Movie m = new Movie("XXX movie one day",new XXXPriceCode());
        Rental rent = new Rental(m, 1);
        assertEquals(2.0, rent.getAmount());

        m = new Movie("XXX Movie five days",new XXXPriceCode());
        rent = new Rental(m, 5);
        assertEquals(6.5, rent.getAmount());
    }

    @Test
    public void testXXXToRegularComporationOneDay(){
        Movie regularMovie = new Movie("Regular movie one day",new RegularPriceCode());
        Rental regularRent = new Rental(regularMovie, 1);

        Movie xxxMovie = new Movie("XXX movie one day",new XXXPriceCode());
        Rental xxxRental = new Rental(xxxMovie, 1);

        assertEquals(regularRent.getAmount(),xxxRental.getAmount());
    }

    @Test
    public void testXXXtoRegulatComporationRegularThreshold(){
        Movie regularMovie = new Movie("Regular movie three days",new RegularPriceCode());
        Rental regularRent = new Rental(regularMovie, 3);

        Movie xxxMovie = new Movie("XXX movie three days",new XXXPriceCode());
        Rental xxxRental = new Rental(xxxMovie, 3);

        assertTrue(regularRent.getAmount() > xxxRental.getAmount());
    }

    @Test
    public void testXXXtoRegulatComporationXXXThreshold(){
        Movie regularMovie = new Movie("Regular movie five days",new RegularPriceCode());
        Rental regularRent = new Rental(regularMovie, 5);

        Movie xxxMovie = new Movie("XXX movie five days",new XXXPriceCode());
        Rental xxxRental = new Rental(xxxMovie, 5);

        assertEquals(regularRent.getAmount(),xxxRental.getAmount());
    }
}
