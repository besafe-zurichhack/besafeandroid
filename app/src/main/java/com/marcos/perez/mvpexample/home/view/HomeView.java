package com.marcos.perez.mvpexample.home.view;

import android.os.Bundle;
import android.util.Log;

import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.home.presenter.HomePresenter;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;

public class HomeView extends BaseActivity implements IHomeView{
    private final static String TAG = "HomeView";
    IHomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_view);
        super.setNavigationItemClicked(Utils.HOME_ACTIVITY_NBR);
        initialize(this);
    }

    private void initialize(IHomeView view){
        mPresenter = new HomePresenter(view);
    }

    @Override
    public void showToast() {

    }


}
