package com.marcos.perez.mvpexample.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.drive.view.DriveView;
import com.marcos.perez.mvpexample.home.presenter.HomePresenter;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;
import com.marcos.perez.mvpexample.perfil.view.PerfilView;

public class HomeView extends BaseActivity implements IHomeView{
    private final static String TAG = "HomeView";
    private Button startButton;
    IHomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_view);
        super.setNavigationItemClicked(Utils.HOME_ACTIVITY_NBR);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anIntent = new Intent(getApplicationContext(), DriveView.class);
                startActivity(anIntent);
            }
        });

        initialize(this);
    }

    private void initialize(IHomeView view){
        mPresenter = new HomePresenter(view);
    }


}
