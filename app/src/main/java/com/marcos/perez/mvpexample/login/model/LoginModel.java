package com.marcos.perez.mvpexample.login.model;

import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;

/**
 * Created by marcos on 17/09/2016.
 */

public class LoginModel implements ILoginModel {
    ILoginPresenter mPresenter;
    public LoginModel(ILoginPresenter loginPresenter) {
        this.mPresenter = loginPresenter;
    }
}
