package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

/**
 * Generates report in pretty print format
 */
public class BaseReport extends AbstractReport {

    public BaseReport(Customer customer) {
        super(customer);
    }

    @Override
    protected String getHeader() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Rental record for ")
                .append(customer.getName()).append("\n");
        return reportBuilder.toString();
    }

    @Override
    protected String getFooter() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Amount owed is ")
                .append(fullRentalAmount)
                .append("\n");
        return reportBuilder.toString();
    }

    @Override
    protected String getBody() {
        StringBuilder reportBuilder = new StringBuilder();
        for (Rental rental : customer.getRentals()) {
            double rentalAmount = rental.getAmount();
            reportBuilder.append("\t")
                    .append(rental.getMovie().getTitle())//add move title to report
                    .append("\t")
                    .append(rentalAmount)//add movie rental price to report
                    .append("\n");
        }

        return reportBuilder.toString();
    }


}
