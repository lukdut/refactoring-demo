package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.pricecodes.Children;
import com.scrumtrek.simplestore.pricecodes.NewRelease;
import com.scrumtrek.simplestore.pricecodes.Regular;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serge on 04.04.2016.
 */
public class CustomerStateBuilderDiscountTest {


    Customer custMickeyMouse;

    @org.junit.Before
    public void setUp() throws Exception {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", new Children());
        Movie movStarWars = new Movie("Star Wars", new Regular());
        Movie movGladiator = new Movie("Gladiator", new NewRelease());

        // Create customers
        custMickeyMouse = new Customer("Mickey Mouse",10);

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

    @Test
    public void getCustomerState() throws Exception {
        CustomerStateBuilder builder = new CustomerStateBuilder();
        CustomerState state = builder.getCustomerState(custMickeyMouse);
        //62.0 without discount - 6.2 (10% discount) = 55.8
        assertEquals(55.8, state.getTotalAmount(), 0);
    }

}