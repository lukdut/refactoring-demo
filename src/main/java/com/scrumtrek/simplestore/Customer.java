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

	public String Statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;

        //AbstractReport report = new AbstractReport();

		String result = "Rental record for " + name + "\n";
		
		for(Rental each: rentals) {
			double thisAmount = each.getAmount();

			// Add frequent renter points
			frequentRenterPoints+=1+each.getFrequentPoints();

			// Show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}
}

