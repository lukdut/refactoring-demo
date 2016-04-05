package com.scrumtrek.simplestore;

public class CustomerMovieState {
    private Movie movie;
    private double amount;

    public CustomerMovieState(Movie movie, double amount) {
        this.movie = movie;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Movie getMovie() {
        return movie;
    }
}
