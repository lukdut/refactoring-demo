package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

/**
 * Created by USER on 04.04.2016.
 */
public class BaseReport extends AbstractReport {

    public BaseReport(Customer customer) {
        super(customer);
    }

    @Override
    public String getReport() {
        countFullRentalAmountAndFreqPoints();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Rental record for ")
                .append(customer.getName()).append("\n");

        for(Rental rental : customer.getRentals()){
            double rentalAmount = rental.getAmount();
            reportBuilder.append("\t")
                    .append(rental.getMovie().getTitle())//add move title to report
                    .append("\t")
                    .append(rentalAmount)//add movie rental price to report
                    .append("\n");
        }

        reportBuilder.append("Amount owed is ")
                .append(fullRentalAmount)
                .append("\n");

        return reportBuilder.toString();
    }

}
