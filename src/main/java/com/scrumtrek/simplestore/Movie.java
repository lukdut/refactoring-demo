package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.prices.IPriceCode;

public class Movie {
	private String title;
	private IPriceCode priceCode;

	public Movie(String title, IPriceCode priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public IPriceCode getPriceCode()	{
		return priceCode;
	}
	
	public void setPriceCode(IPriceCode value) {
		priceCode = value;
	}

	public String getTitle() {
		return title;
	}
}

