package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.reports.AbstractReport;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void addRental(Rental arg){
		rentals.add(arg);
	}

	public String statement(AbstractReport report)
	{
		report.putDataIntoTemplate(AbstractReport.NAME, name);
        report.putRentalsIntoTemplate(rentals);
        return report.getReport();
	}
}

