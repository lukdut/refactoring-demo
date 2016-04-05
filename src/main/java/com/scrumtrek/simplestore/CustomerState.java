package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contains customer state
 */
public class CustomerState {
    private double totalAmount;
    private List<CustomerMovieState> movieStates = new ArrayList<>();

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<CustomerMovieState> getMovieStates() {
        return new ArrayList<>(movieStates);
    }

    public void addMovieStates(CustomerMovieState movieState) {
        this.movieStates.add(movieState);
    }
}
