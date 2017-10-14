package com.marcos.perez.mvpexample.summary.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.home.view.HomeView;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;
import com.marcos.perez.mvpexample.login.presenter.LoginPresenter;
import com.marcos.perez.mvpexample.login.view.ILoginView;

public class SummaryView extends AppCompatActivity {
    private final static String TAG = "SummaryView";
    private Button okButton;
    private Activity self = this;
    ILoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_summary_view);

        okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login("user","pass");Intent anIntent = new Intent(getApplicationContext(), HomeView.class);
                startActivity(anIntent);
                self.finish();
            }
        });

        initialize(this);
    }

    private void initialize(SummaryView view){
        //mPresenter = new SummaryPresenter(view);
    }

}
