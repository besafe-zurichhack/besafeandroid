package com.marcos.perez.mvpexample.home.presenter;

import com.marcos.perez.mvpexample.home.model.HomeModel;
import com.marcos.perez.mvpexample.home.model.IHomeModel;
import com.marcos.perez.mvpexample.home.view.IHomeView;

/**
 * Created by marcos on 17/09/2016.
 */

public class HomePresenter implements IHomePresenter{
    IHomeView mView;
    IHomeModel mModel;

    public HomePresenter(IHomeView view) {
        this.mView = view;
        this.mModel = (IHomeModel) new HomeModel(this);
    }

}
