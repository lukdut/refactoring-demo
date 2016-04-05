package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.Children;
import com.scrumtrek.simplestore.pricecodes.NewRelease;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by serge on 04.04.2016.
 */
public class MovieTest {
    @Test
    public void ConstructorShouldProperInitialize() {
        Movie m = new Movie("Movie1", new Children());

        assertEquals("Movie1", m.getTitle());
        assertEquals("Children", m.getPriceCode().getName());
    }
}