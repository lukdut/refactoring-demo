package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Rental;

/**
 * Created by USER on 04.04.2016.
 */
public class JsonReport extends AbstractReport {
    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Customer{\n");
        reportBuilder.append("name:").append(data.get(AbstractReport.NAME)).append(",\n");
        fullRentalAmount = 0;
        frequentPoints = 0;

        for(Rental rental : rentals){
            fullRentalAmount+= rental.getAmount();
            frequentPoints+=1+rental.getFrequentPoints();
            reportBuilder.append(" Rental{\n");
            reportBuilder.append("  title:").append(rental.getMovie().getTitle()).append(",\n");
            reportBuilder.append("  rentAmount:").append(rental.getAmount()).append(",\n");
            reportBuilder.append(" },\n");
        }

        reportBuilder.append("fullAmount:").append(fullRentalAmount).append(",\n");
        reportBuilder.append("frequentPoint:").append(frequentPoints).append("\n");
        reportBuilder.append("}");

        return reportBuilder.toString();
    }
}
