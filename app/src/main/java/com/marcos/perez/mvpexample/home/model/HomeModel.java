package com.marcos.perez.mvpexample.home.model;

import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;

/**
 * Created by marcos on 17/09/2016.
 */

public class HomeModel implements IHomeModel{
    IHomePresenter mPresenter;
    public HomeModel(IHomePresenter homePresenter) {
        this.mPresenter = homePresenter;
    }
}
