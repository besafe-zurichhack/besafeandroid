package com.marcos.perez.mvpexample.drive.presenter;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.drive.model.DriveModel;
import com.marcos.perez.mvpexample.drive.view.DriveView;

/**
 * Created by marcos on 17/09/2016.
 */

public class DrivePresenter {
    DriveView mView;
    DriveModel mModel;

    public DrivePresenter(DriveView view) {
        this.mView = view;
        this.mModel = new DriveModel(this);
    }

    public void endJourney(JourneyData journeyData) {
        mModel.endJourney(journeyData);
    }

    public void loadSummaryActivity() {
        mView.loadSummaryActivity();
    }

}
