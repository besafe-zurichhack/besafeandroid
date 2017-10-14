package com.marcos.perez.mvpexample.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.marcos.perez.mvpexample.BaseActivity;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;
import com.marcos.perez.mvpexample.drive.view.DriveView;
import com.marcos.perez.mvpexample.home.presenter.HomePresenter;
import com.marcos.perez.mvpexample.home.presenter.IHomePresenter;
import com.marcos.perez.mvpexample.perfil.view.PerfilView;

import java.util.Map;

public class HomeView extends BaseActivity implements IHomeView{
    private final static String TAG = "HomeView";
    private Button startButton;
    IHomePresenter mPresenter;
    SharedPreferences preferences;

    TextView userNameProfile;

    String storedPreference;
    Firebase mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home_view);
        super.setNavigationItemClicked(Utils.HOME_ACTIVITY_NBR);

        preferences =  this.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        storedPreference = preferences.getString("user_id", null);

        userNameProfile = (TextView) findViewById(R.id.user_profile_name);
        Log.v("E_VALUE","Name: "+storedPreference);
        mref = new Firebase("https://zurich-707e5.firebaseio.com/");

        /*mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map=dataSnapshot.child("users").child(storedPreference).getValue(Map.class);

                String name = map.get("fName");
                Log.v("E_VALUE","Name: "+name);

                userNameProfile.setText(userNameProfile.getText()+" "+name);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/

        }


    private void initialize(IHomeView view){
        mPresenter = new HomePresenter(view);
    }


}
