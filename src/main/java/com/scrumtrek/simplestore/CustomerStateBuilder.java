package com.scrumtrek.simplestore;

/**
 * Creates CustomerState by customer. For building report
 */
public class CustomerStateBuilder {

    public CustomerState getCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;

        for (Rental rental : customer.getRentals()) {
            for(Movie movie : rental.getMovieList()){
                double thisAmount = 0;

                thisAmount += movie.getPriceCode().getAmount(rental.getDaysRented());

                totalAmount += thisAmount;
                result.addMovieStates(new CustomerMovieState(movie, thisAmount));
            }
        }

        double discountAmount = (totalAmount/100.0)*customer.getDiscount();

        result.setTotalAmount(totalAmount-discountAmount);

        return result;
    }
}
