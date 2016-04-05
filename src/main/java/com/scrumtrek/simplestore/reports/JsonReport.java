package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

/**
 * Generates report in JSON format
 */
public class JsonReport extends AbstractReport {
    public JsonReport(Customer customer) {
        super(customer);
    }

    @Override
    public String getReport() {
        countFullRentalAmountAndFreqPoints();

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Customer {\n");
        reportBuilder.append(" name:").append(customer.getName()).append(",\n");

        for(Rental rental : customer.getRentals()){
            reportBuilder.append(" Rental {\n");
            reportBuilder.append("  title:").append(rental.getMovie().getTitle()).append(",\n");
            reportBuilder.append("  rentAmount:").append(rental.getAmount()).append(",\n");
            reportBuilder.append(" },\n");
        }

        reportBuilder.append(" fullAmount:").append(fullRentalAmount).append("\n");
        reportBuilder.append("}");

        return reportBuilder.toString();
    }
}
