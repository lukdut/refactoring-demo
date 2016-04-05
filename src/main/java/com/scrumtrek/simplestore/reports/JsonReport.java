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
    protected String getHeader() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Customer {\n");
        reportBuilder.append(" name:").append(customer.getName()).append(",\n");
        return reportBuilder.toString();
    }

    @Override
    protected String getBody() {
        StringBuilder reportBuilder = new StringBuilder();
        for(Rental rental : customer.getRentals()){
            reportBuilder.append(" Rental {\n");
            reportBuilder.append("  title:").append(rental.getMovie().getTitle()).append(",\n");
            reportBuilder.append("  rentAmount:").append(rental.getAmount()).append(",\n");
            reportBuilder.append(" },\n");
        }
        return reportBuilder.toString();
    }

    @Override
    protected String getFooter() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(" fullAmount:").append(fullRentalAmount).append("\n");
        reportBuilder.append("}");

        return reportBuilder.toString();
    }
}
