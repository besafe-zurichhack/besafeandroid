package com.marcos.perez.mvpexample.DataModels;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Date;

public class JourneyData {
    private Date startTime, endTime;
    private ArrayList<LatLng> checkPoints;

    public JourneyData() {
        startTime = new Date();
    }

    public void addPoint(LatLng point) {
        checkPoints.add(point);
    }

    public void endJourney() {
        endTime = new Date();
    }
}