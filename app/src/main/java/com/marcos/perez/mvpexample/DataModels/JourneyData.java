package com.marcos.perez.mvpexample.DataModels;

import java.util.Date;

public class JourneyData {
    private Date startDate, endDate;

    public JourneyData() {
        startDate = new Date();
    }

    public void endJourney() {
        endDate = new Date();
    }
}