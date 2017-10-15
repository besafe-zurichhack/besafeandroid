package com.marcos.perez.mvpexample.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.drive.view.DriveView;
import com.marcos.perez.mvpexample.home.presenter.HomePresenter;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;

import java.util.Map;

public class HomeView extends BaseActivity implements IHomeView {
    private final static String TAG = "Home";
    IHomePresenter mPresenter;
    SharedPreferences preferences;

    TextView userNameProfile;
    TextView userTrayectos;

    String storedPreference;
    Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_view);
        super.setNavigationItemClicked(Utils.HOME_ACTIVITY_NBR);
        super.setTitle(TAG);

        preferences = this.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        storedPreference = preferences.getString("user_id", null);

        userNameProfile = (TextView) findViewById(R.id.user_profile_name);
        userTrayectos   = (TextView) findViewById(R.id.userTrayectos) ;
        Log.v("E_VALUE", "Name: " + storedPreference);
        mref = new Firebase("https://zurich-707e5.firebaseio.com/");

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> mapName = dataSnapshot.child("users").child(storedPreference).getValue(Map.class);
                int count = 0;
                for(DataSnapshot snapTrayectos : dataSnapshot.child("travels").child(storedPreference).getChildren()){
                    count++;
                }

                String name = mapName.get("fName");
                int trayectos = count;
                String puntos = mapName.get("fName");
                Log.v("E_VALUE", "Name: " + name);

                userNameProfile.setText("Hola "+name);
                userTrayectos.setText(String.valueOf(trayectos));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent anIntent = new Intent(getApplicationContext(), DriveView.class);
                startActivity(anIntent);
            }
        });

    }


    private void initialize(IHomeView view) {
        mPresenter = new HomePresenter(view);
    }


}
