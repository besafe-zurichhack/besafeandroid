package com.marcos.perez.mvpexample.drive.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.DataModels.JourneySummary;
import com.marcos.perez.mvpexample.PermissionUtils;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.UtilsDemo;
import com.marcos.perez.mvpexample.drive.presenter.DrivePresenter;
import com.marcos.perez.mvpexample.summary.view.SummaryView;

import static com.marcos.perez.mvpexample.Utils.LOCATION_PERMISSION_REQUEST_CODE;

public class DriveView extends AppCompatActivity {
    private final static String TAG = "DriveView";
    private Button endButton;
    private JourneyData journeyData;
    private LocationManager locationManager;
    private int i = 0;
    private UtilsDemo utilsDemo = new UtilsDemo();
    DrivePresenter mPresenter;
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drive_view);

        journeyData = new JourneyData();

        endButton = (Button) findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journeyData.endJourney();
                mPresenter.endJourney(journeyData);
            }
        });

        initialize(this);

        enableMyLocation();
    }

    private void initialize(DriveView view){
        mPresenter = new DrivePresenter(view);
    }


    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else {
            // Access to the location has been granted to the app.
            if (locationManager == null) {
                locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            }
            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this);
            handler = new Handler();
            runnable = new Runnable() {

                @Override
                public void run() {
                    onLocationChanged(utilsDemo.get(i));
                    i++;

                    handler.postDelayed(this, 5000);
                }
            };
            handler.postDelayed(runnable, 5000);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
        }
    }

    public void loadSummaryActivity(JourneySummary js) {
        Intent anIntent = new Intent(getApplicationContext(), SummaryView.class);
        anIntent.putExtra("time", js.getTimeElapsed());
        anIntent.putExtra("score", js.getScore());
        anIntent.putExtra("distance", js.getDistanceTraveled());
        startActivity(anIntent);
        this.finish();
    }

    public void onLocationChanged(Location location) {
        Log.v("location", String.valueOf(location.getLatitude()) + ',' + String.valueOf(location.getLongitude()));
        journeyData.addPoint(location);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (locationManager != null) {
            try {
                //locationManager.removeUpdates(this);
                handler.removeCallbacks(runnable);
            } catch (Exception ex) {
            }
        }
    }
}
