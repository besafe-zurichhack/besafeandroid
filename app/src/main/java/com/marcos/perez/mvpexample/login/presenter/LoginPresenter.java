package com.marcos.perez.mvpexample.login.presenter;

import com.marcos.perez.mvpexample.login.model.LoginModel;
import com.marcos.perez.mvpexample.login.model.ILoginModel;
import com.marcos.perez.mvpexample.login.view.ILoginView;

/**
 * Created by marcos on 17/09/2016.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginView mView;
    ILoginModel mModel;

    public LoginPresenter(ILoginView view) {
        //TODO check weak reference
        this.mView = view;
        this.mModel = (ILoginModel) new LoginModel(this);
    }

    @Override
    public void login(String username, String password) {
        mModel.login(username, password);
    }

    @Override
    public void loadHomeActivity() {
        mView.loadHomeActivity();
    }

}
