package com.marcos.perez.mvpexample.summary.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.home.view.HomeView;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;

import java.util.concurrent.TimeUnit;

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
                Intent anIntent = new Intent(getApplicationContext(), HomeView.class);
                anIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(anIntent);
            }
        });

        Intent in = getIntent();
        if (in != null) {
            ((TextView) findViewById(R.id.txtDistance)).setText(String.valueOf(in.getDoubleExtra("distance",0.0)));
            ((TextView) findViewById(R.id.txtTime)).setText(formatTime(in.getLongExtra("time",0)));
            ((TextView) findViewById(R.id.txtScore)).setText(String.valueOf(in.getIntExtra("score",0)));
        }

        initialize(this);
    }

    private void initialize(SummaryView view){
        //mPresenter = new SummaryPresenter(view);
    }

    private String formatTime(long time) {
        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(time) % TimeUnit.MINUTES.toSeconds(1));
    }

}
