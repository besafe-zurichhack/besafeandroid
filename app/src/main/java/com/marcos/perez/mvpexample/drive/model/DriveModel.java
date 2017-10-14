package com.marcos.perez.mvpexample.drive.model;

import android.util.Log;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.DataModels.JourneySummary;
import com.marcos.perez.mvpexample.drive.presenter.DrivePresenter;

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
        JourneySummary js = new JourneySummary((int)time/50000, time, time/15000);
        mPresenter.loadSummaryActivity(js);
    }
}
