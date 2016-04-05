package com.scrumtrek.simplestore;

/**
 * Creates CustomerState by customer. For building report
 */
public class CustomerStateBuilder {

    public CustomerState getCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;

        for (Rental rental : customer.getRentals()) {
            double thisAmount = 0;

            thisAmount += rental.getMovie().getPriceCode().getAmount(rental.getDaysRented());

            totalAmount += thisAmount;
            result.addMovieStates(new CustomerMovieState(rental.getMovie(), thisAmount));
        }
        result.setTotalAmount(totalAmount);

        return result;
    }
}
