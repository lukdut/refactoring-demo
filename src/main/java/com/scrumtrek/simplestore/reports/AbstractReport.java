package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Rental;

/**
 * Created by USER on 04.04.2016.
 */
public abstract class AbstractReport {
    protected double fullRentalAmount;
    protected int frequentPoints;
    protected Customer customer;

    public AbstractReport(Customer customer){
      this.customer = customer;
    }

    //TODO ������������� �������, ����� �������� ���� ����
    protected void countFullRentalAmountAndFreqPoints(){
        fullRentalAmount = 0;
        frequentPoints = 0;
        for(Rental rental : customer.getRentals()) {
            fullRentalAmount += rental.getAmount();
            frequentPoints += 1 + rental.getFrequentPoints();
        }
    }

    public abstract String getReport();
}
