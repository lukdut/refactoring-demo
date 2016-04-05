package com.scrumtrek.simplestore;

/**
 * Creates CustomerState by customer. For building report
 */
public class CustomerStateBuilder {

    public CustomerState getCustomerState(Customer customer) {

        CustomerState result = new CustomerState();
        double totalAmount = 0;

        for (Rental rental : customer.getRentals()) {
            totalAmount+=getRentalAmount(rental);
        }

        double discountAmount = (totalAmount/100.0)*customer.getDiscount();
        result.setTotalAmount(totalAmount-discountAmount);

        return result;
    }

    public double getRentalAmount(Rental rental){
        double rentalAmount = 0;
        for(Movie movie : rental.getMovieList()){
            rentalAmount += movie.getPriceCode().getAmount(rental.getDaysRented());
        }
        return rentalAmount;
    }
}
