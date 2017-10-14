package com.marcos.perez.mvpexample.perfil.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.Utils;

import java.util.Map;

/**
 * Created by Joan Manel on 14/10/2017.
 */

public class PerfilView extends AppCompatActivity{
    private final static String TAG = "PerfilView";
    private TextView nameText;
    private TextView surnameText;
    private TextView eMailText;
    private TextView pointsText;

    private Firebase mRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_perfil_view);
        /*nameText = (TextView) findViewById(R.id.nameText);
        surnameText = (TextView) findViewById(R.id.surnameText);
        eMailText = (TextView) findViewById(R.id.eMailText);
        pointsText = (TextView) findViewById(R.id.pointsText);*/


        /*mRef = new Firebase("https://zurich-22317.firebaseio.com/users");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /*Map<String, String> map = dataSnapshot.getValue(Map.class);

                String name = map.get("Name");
                String surname = map.get("Surname");
                String email = map.get("email");
                String points = map.get("points");

                nameText.setText(name);
                surnameText.setText(surname);
                eMailText.setText(email);
                pointsText.setText(points);

                Log.v("E_DATA", "Data : "+ dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/
    }
}
