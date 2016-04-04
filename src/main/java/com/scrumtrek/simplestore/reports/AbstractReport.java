package com.scrumtrek.simplestore.reports;

import java.util.List;

/**
 * Created by USER on 04.04.2016.
 */
public class AbstractReport {
    private String headerData;
    private List<String> bodyData;
    private String footerDate;

    private String makeHeader(){
        return "Rental record for " + headerData + "\n";
    };

    public void makeBodyPart(){

    }

    public void makeFooter(){

    };
}
