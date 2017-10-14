package com.marcos.perez.mvpexample.DataModels;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

public class JourneyData {
    private Date startTime, endTime;
    private ArrayList<Location> checkPoints;

    public JourneyData() {
        startTime = new Date();
        checkPoints = new ArrayList<>();
    }

    public void addPoint(Location point) {
        checkPoints.add(point);
    }

    public void endJourney() {
        endTime = new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ArrayList<Location> getCheckPoints() {
        return checkPoints;
    }
}