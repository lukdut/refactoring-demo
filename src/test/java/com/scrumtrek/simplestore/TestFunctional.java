package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.ChildrensPriceCode;
import com.scrumtrek.simplestore.prices.NewReleasePriceCode;
import com.scrumtrek.simplestore.prices.RegularPriceCode;
import com.scrumtrek.simplestore.reports.BaseReport;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 04.04.2016.
 */

public class TestFunctional {
    private static String detailReport;
    private static String simpleReport;
    private static String[] lines;

    @BeforeClass
    public static void init() {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", new ChildrensPriceCode());
        Movie movStarWars = new Movie("Star Wars", new RegularPriceCode());
        Movie movGladiator = new Movie("Gladiator", new NewReleasePriceCode());

        // Create customer
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        detailReport = new BaseReport(custMickeyMouse).getDetailReport();
        simpleReport = new BaseReport(custMickeyMouse).getSimpleReport();

        lines = detailReport.split("\n");
        System.out.println(detailReport);
        System.out.println(simpleReport);

    }

    @Test
    public void testDetailReport() {
        assertEquals(detailReport, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t6.5\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 24.5\n");
    }

    @Test
    public void testSimpleReport() {
        assertEquals(simpleReport, "Rental record for Mickey Mouse\n" +
                "Amount owed is 24.5\n");
    }


    @Test
    public void testCinderella() {
        assertTrue(lines[1].contains("Cinderella\t3.0"));
    }

    @Test
    public void testStarWars() {
        assertTrue(lines[2].contains("Star Wars\t6.5"));
    }

    @Test
    public void testGladiator() {
        assertTrue(lines[3].contains("Gladiator\t15.0"));
    }

    @Test
    public void testOwedAmount() {
        assertTrue(lines[4].contains("Amount owed is 24.5"));
    }

}
