package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.Children;
import com.scrumtrek.simplestore.pricecodes.NewRelease;
import com.scrumtrek.simplestore.pricecodes.Regular;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerTest {

    Customer custMickeyMouse;

    @org.junit.Before
    public void setUp() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", new Children());
        Movie movStarWars = new Movie("Star Wars", new Regular());
        Movie movGladiator = new Movie("Gladiator", new NewRelease());

        // Create customers
        custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(5);
        rental1.addMovieToRental(movCinderella);
        Rental rental2 = new Rental(10);
        rental2.addMovieToRental(movStarWars);
        Rental rental3 = new Rental(15);
        rental3.addMovieToRental(movGladiator);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTextReportSimple() {
        ReportBuilder reportBuilder = new ReportBuilder(custMickeyMouse);
        assertEquals("Rental record for Mickey Mouse\n"+
                "Amount owed is 62.0\n", reportBuilder.statementSimple());
    }


    @Test
    public void testJsonReportSimple() {
        ReportBuilder reportBuilder = new ReportBuilder(custMickeyMouse);
        assertEquals("{customerName:'Mickey Mouse',totalAmount:'62.0'}", reportBuilder.statementJsonSimple());
    }

    @Test
    public void nameTest() {
        assertEquals("Mickey Mouse", custMickeyMouse.getName());
    }

}