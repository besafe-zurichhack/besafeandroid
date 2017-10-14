package com.marcos.perez.mvpexample.drive.model;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
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
        mPresenter.loadSummaryActivity();
    }
}
