package com.marcos.perez.mvpexample.travellist.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.marcos.perez.mvpexample.DataModels.JourneySummary;
import com.marcos.perez.mvpexample.MyAdapter;
import com.marcos.perez.mvpexample.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Joan Manel on 15/10/2017.
 */

public class TravellistView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<JourneySummary> travels;


    private SharedPreferences preferences;
    private String storedPreference;

    private Firebase mref;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelslist_view);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        preferences = this.getSharedPreferences("mypref", Context.MODE_PRIVATE);
        storedPreference = preferences.getString("user_id", null);

        mref=new Firebase("https://zurich-707e5.firebaseio.com/travels/");

        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllTravels(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllTravels(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void getAllTravels(DataSnapshot dataSnapshot){
        JourneySummary travel = new JourneySummary();
        for(DataSnapshot singleSnapShot: dataSnapshot.child(storedPreference).getChildren()){
            /*Map<String,String> map = singleSnapShot.getValue(Map.class);
            travel.setDistanceTraveled(Double.parseDouble(map.get("distance")));
            travel.setScore(Integer.parseInt(map.get("points")));*/

            System.out.println(singleSnapShot.getChildren());

            //travels.add(travel);

            /*mAdapter = new MyAdapter(travels);
            recyclerView.setAdapter(mAdapter);*/
        }
    }
}
