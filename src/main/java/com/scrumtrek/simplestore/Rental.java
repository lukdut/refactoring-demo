package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Rental {
    private List<Movie> movieList;
    private int daysRented;

    public Rental(int daysRented) {
        this.daysRented = daysRented;
        this.movieList = new ArrayList<>();
    }

    public int getDaysRented() {
        return daysRented;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public boolean addMovieToRental(Movie movie){
        return movieList.add(movie);
    }
}

