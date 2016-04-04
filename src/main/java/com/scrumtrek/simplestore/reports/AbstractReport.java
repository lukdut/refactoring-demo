package com.scrumtrek.simplestore.reports;

import com.scrumtrek.simplestore.Rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by USER on 04.04.2016.
 */
public abstract class AbstractReport {
    public static final String NAME = "NAME";

    protected Map<String,String> data;
    protected List<Rental> rentals;
    protected double fullRentalAmount;
    protected int frequentPoints;

    public AbstractReport(){
        data = new HashMap<>();
        rentals = new ArrayList<>();
    }

    public abstract String getReport();

    public void putDataIntoTemplate(String field, String data){
        this.data.put(field,data);
    }

    public void putRentalsIntoTemplate(List<Rental> rentals){
        this.rentals.addAll(rentals);
    }

}
