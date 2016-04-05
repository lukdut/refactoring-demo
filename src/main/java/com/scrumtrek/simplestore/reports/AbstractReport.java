package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

public abstract class AbstractReport {
    protected double fullRentalAmount;
    protected Customer customer;

    public AbstractReport(Customer customer){
      this.customer = customer;
    }


    protected void countFullRentalAmountAndFreqPoints(){
        fullRentalAmount = 0;
        for(Rental rental : customer.getRentals()) {
            fullRentalAmount += rental.getAmount();
        }
    }

    public String getSimpleReport(){
        countFullRentalAmountAndFreqPoints();
        return getHeader()+getFooter();
    }

    public String getDetailReport(){
        countFullRentalAmountAndFreqPoints();
        return getHeader()+getBody()+getFooter();
    }

    protected abstract String getHeader();
    protected abstract String getBody();
    protected abstract String getFooter();
}
