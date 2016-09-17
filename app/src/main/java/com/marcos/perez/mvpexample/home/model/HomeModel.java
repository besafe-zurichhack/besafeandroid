package com.marcos.perez.mvpexample.home.model;

import com.marcos.perez.mvpexample.home.presenter.HomePresenter;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;
import com.marcos.perez.mvpexample.home.view.IHomeView;
import com.marcos.perez.mvpexample.login.model.ILoginModel;

/**
 * Created by marcos on 17/09/2016.
 */

public class HomeModel implements IHomeModel{
    IHomePresenter mPresenter;
    public HomeModel(IHomePresenter homePresenter) {
        this.mPresenter = homePresenter;
    }
}
