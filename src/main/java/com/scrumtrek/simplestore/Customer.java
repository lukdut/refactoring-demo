package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer holds his name and all rentals which he made
 */
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

	public List<Rental> getRentals() {
		return rentals;
	}
}

