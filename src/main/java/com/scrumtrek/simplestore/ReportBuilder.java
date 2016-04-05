package com.scrumtrek.simplestore;

/**
 * Created by USER on 05.04.2016.
 */
public class ReportBuilder{
    private CustomerStateBuilder stateBuilder = new CustomerStateBuilder();
    private Customer customer;

    public ReportBuilder(Customer customer){
        this.customer = customer;
    }

    /**
     * Creates text report by customer state
     *
     * @return
     */
    public String statementSimple() {
        CustomerState state = stateBuilder.getCustomerState(customer);
        String result = "Rental record for " + customer.getName() + "\n";
        // Add footer lines
        result += "Amount owed is " + state.getTotalAmount() + "\n";
        return result;
    }

    /**
     * Creates json simple report by customer state
     *
     * @return
     */
    public String statementJsonSimple() {
        CustomerState state = stateBuilder.getCustomerState(customer);
        return "{" +
                "customerName:'" + customer.getName() + "'," +
                "totalAmount:'" + state.getTotalAmount() + "'"+
                "}";
    }



}
