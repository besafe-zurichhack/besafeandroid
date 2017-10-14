package com.marcos.perez.mvpexample.drive.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.drive.presenter.DrivePresenter;
import com.marcos.perez.mvpexample.home.view.HomeView;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;
import com.marcos.perez.mvpexample.login.presenter.LoginPresenter;
import com.marcos.perez.mvpexample.login.view.ILoginView;

public class DriveView extends AppCompatActivity {
    private final static String TAG = "DriveView";
    private Button endButton;
    private JourneyData journeyData;
    DrivePresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drive_view);

        journeyData = new JourneyData();

        endButton = (Button) findViewById(R.id.loginButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.endJourney(journeyData);
            }
        });

        initialize(this);
    }

    private void initialize(DriveView view){
        mPresenter = new DrivePresenter(view);
    }


    public void loadResumeActivity() {
        Intent anIntent = new Intent(getApplicationContext(), ResumeView.class);
        startActivity(anIntent);
        this.finish();
    }
}
