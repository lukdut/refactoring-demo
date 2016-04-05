package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.ChildrensPriceCode;
import com.scrumtrek.simplestore.prices.NewReleasePriceCode;
import com.scrumtrek.simplestore.prices.RegularPriceCode;
import com.scrumtrek.simplestore.reports.JsonReport;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by USER on 04.04.2016.
 */

public class TestJsonFunctional {
    private static String statement;
    private static String[] lines;

    @BeforeClass
    public static void init() {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", new ChildrensPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        statement = new JsonReport(custMickeyMouse).getReport();
        lines = statement.split("\n");
    }

    @Test
    public void testWholeReport() {
        assertEquals(statement, "Customer {\n" +
                " name:Mickey Mouse,\n" +
                " Rental {\n" +
                "  title:Cinderella,\n" +
                "  rentAmount:3.0,\n" +
                " },\n" +
                " Rental {\n" +
                "  title:Star Wars,\n" +
                "  rentAmount:6.5,\n" +
                " },\n" +
                " Rental {\n" +
                "  title:Gladiator,\n" +
                "  rentAmount:15.0,\n" +
                " },\n" +
                " fullAmount:24.5\n" +
                "}");
    }

}