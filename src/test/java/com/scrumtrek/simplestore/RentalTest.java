package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.Children;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serge on 04.04.2016.
 */
public class RentalTest {
    @Test
    public void ConstructorShouldProperInitialize() {
        Rental r = new Rental(new Movie("Movie1", new Children()), 5);

        assertEquals(5, r.getDaysRented());
        assertEquals("Children", r.getMovie().getPriceCode().getName());
        assertEquals("Movie1", r.getMovie().getTitle());
    }
}
