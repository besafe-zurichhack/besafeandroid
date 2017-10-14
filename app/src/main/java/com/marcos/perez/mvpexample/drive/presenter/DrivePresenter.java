package com.marcos.perez.mvpexample.drive.presenter;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.drive.model.DriveModel;
import com.marcos.perez.mvpexample.drive.view.DriveView;
import com.marcos.perez.mvpexample.home.model.HomeModel;
import com.marcos.perez.mvpexample.home.model.IHomeModel;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;
import com.marcos.perez.mvpexample.home.view.IHomeView;

/**
 * Created by marcos on 17/09/2016.
 */

public class DrivePresenter {
    DriveView mView;
    DriveModel mModel;

    public DrivePresenter(DriveView view) {
        this.mView = view;
        this.mModel = (DriveModel) new DriveModel(this);
    }

    public void endJourney(JourneyData journeyData) {
        mModel.endJourney(journeyData);
    }

    public void loadResumeActivity() {
        mView.loadResumeActivity();
    }
}
