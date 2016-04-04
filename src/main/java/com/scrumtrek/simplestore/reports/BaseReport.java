package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Rental;

/**
 * Created by USER on 04.04.2016.
 */
public class BaseReport extends AbstractReport {

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        fullRentalAmount = 0;
        frequentPoints = 0;

        reportBuilder.append("Rental record for ")
                .append(data.get(AbstractReport.NAME)).append("\n");

        for(Rental rental : rentals){
            double rentalAmount = rental.getAmount();
            fullRentalAmount+= rentalAmount;
            frequentPoints+=1+rental.getFrequentPoints();

            reportBuilder.append("\t")
                    .append(rental.getMovie().getTitle())//add move title to report
                    .append("\t")
                    .append(rentalAmount)//add movie rental price to report
                    .append("\n");
        }

        reportBuilder.append("Amount owed is ")
                .append(fullRentalAmount)
                .append("\n")
                .append("You earned ")
                .append(frequentPoints)
                .append(" frequent renter points.");

        return reportBuilder.toString();
    }

}
