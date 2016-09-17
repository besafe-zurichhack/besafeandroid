package com.marcos.perez.mvpexample.login.view;

import android.os.Bundle;
import android.util.Log;

import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.login.presenter.LoginPresenter;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;

public class LoginView extends BaseActivity implements ILoginView {
    private final static String TAG = "LoginView";
    ILoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login_view);
        super.setNavigationItemClicked(Utils.LOGIN_ACTIVITY_NBR);
        initialize(this);
    }

    private void initialize(ILoginView view){
        mPresenter = new LoginPresenter(view);
    }

    @Override
    public void showToast() {

    }
}
