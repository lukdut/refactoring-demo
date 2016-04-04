import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 04.04.2016.
 */

public class TestFunctional {
    private static String statement;
    private static String[] lines;

    @BeforeClass
    public static void init() {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Customer custDonaldDuck = new Customer("Donald Duck");
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        statement = custMickeyMouse.Statement();
        lines = statement.split("\n");
//        System.out.printf(statement);
    }

    @Test
    public void testWholeReport() {
        assertEquals(statement, "Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t6.5\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 24.5\n" +
                "You earned 4 frequent renter points.");
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

    @Test
    public void testFrequencePoints() {
        assertTrue(lines[5].contains("You earned 4 frequent renter points."));
    }
}
