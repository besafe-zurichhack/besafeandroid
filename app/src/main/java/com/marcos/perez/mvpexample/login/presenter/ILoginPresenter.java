package com.marcos.perez.mvpexample.login.presenter;

/**
 * Created by marcos on 17/09/2016.
 */

public interface ILoginPresenter {
    void login(String username, String password);

    void loadHomeActivity();
}
