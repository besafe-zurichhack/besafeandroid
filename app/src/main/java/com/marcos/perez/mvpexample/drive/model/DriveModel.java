package com.marcos.perez.mvpexample.drive.model;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.DataModels.JourneySummary;
import com.marcos.perez.mvpexample.drive.presenter.DrivePresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by marcos on 17/09/2016.
 */

public class DriveModel {
    DrivePresenter mPresenter;
    public DriveModel(DrivePresenter drivePresenter) {
        this.mPresenter = drivePresenter;
    }

    public void endJourney(JourneyData journeyData) {
        long time = journeyData.getEndTime().getTime() - journeyData.getStartTime().getTime();
        journeyData.setDistance(time/15000);

        String travelId = FirebaseDatabase.getInstance().getReference().child("travels").child("-KwPv_ZpSoN-6n8SH-ga").push().getKey();
        Map<String, Object> updates = new HashMap<>();
        updates.put(travelId, journeyData);
        FirebaseDatabase.getInstance().getReference().child("travels").child("-KwPv_ZpSoN-6n8SH-ga").updateChildren(updates);
        FirebaseDatabase.getInstance().getReference().child("travels").child("-KwPv_ZpSoN-6n8SH-ga").child(travelId).child("checkPoints").setValue(journeyData.getCheckPoints());

        JourneySummary js = new JourneySummary((int)time/50000, time, time/15000);
        mPresenter.loadSummaryActivity(js);
    }
}
