package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Class customer. Contains it`s rentals
 * and call reportBuilder to create reports.
 */
public class Customer {
    private CustomerStateBuilder stateBuilder = new CustomerStateBuilder();
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public String getName() {
        return name;
    }


    public void addRental(Rental arg) {
        rentals.add(arg);
    }


    /**
     * Creates text report by customer state
     *
     * @return
     */
    public String statement() {


        CustomerState state = stateBuilder.getCustomerState(this);

        String result = "Rental record for " + name + "\n";

        for (CustomerMovieState movieState : state.getMovieStates()) {
            result += "\t" + movieState.getMovie().getTitle() + "\t" + movieState.getAmount() + "\n";
        }

        // Add footer lines
        result += "Amount owed is " + state.getTotalAmount() + "\n";
        return result;
    }

    /**
     * Creates json report by customer state
     *
     * @return
     */
    public String statementJson() {
        CustomerState state = stateBuilder.getCustomerState(this);
        return "{" +
                "customerName:'" + this.getName() + "'," +
                "totalAmount:'" + state.getTotalAmount() + "'," +
                getJsonMovieStates(state.getMovieStates()) +
                "}";
    }

    private String getJsonMovieStates(List<CustomerMovieState> states) {
        String result = "";
        for (CustomerMovieState state : states) {
            result += "{movieName:'" + state.getMovie().getTitle() + "', amount:'" + state.getAmount() + "'},";
        }
        result = result.substring(0, result.length() - 1);
        return "[" + result + "]";
    }
}

