package com.scrumtrek.simplestore;

/**
 * Class contains information about one movie
 * and days its rented
 */
public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getAmount(){
		return getMovie().getPriceCode().getRentAmount(getDaysRented());
	}

}

