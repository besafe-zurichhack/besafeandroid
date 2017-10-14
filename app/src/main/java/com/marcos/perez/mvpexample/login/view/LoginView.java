package com.marcos.perez.mvpexample.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.home.view.HomeView;
import com.marcos.perez.mvpexample.login.presenter.LoginPresenter;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;

public class LoginView extends AppCompatActivity implements ILoginView {
    private final static String TAG = "LoginView";
    private Button loginButton;
    ILoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login_view);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login("user","pass");
            }
        });

        initialize(this);
    }

    private void initialize(ILoginView view){
        mPresenter = new LoginPresenter(view);
    }

    @Override
    public void loadHomeActivity() {
        Intent anIntent = new Intent(getApplicationContext(), HomeView.class);
        startActivity(anIntent);
        this.finish();
    }

}
