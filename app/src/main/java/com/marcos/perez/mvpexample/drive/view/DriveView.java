package com.marcos.perez.mvpexample.drive.view;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.marcos.perez.mvpexample.DataModels.JourneyData;
import com.marcos.perez.mvpexample.PermissionUtils;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.drive.presenter.DrivePresenter;

import static com.marcos.perez.mvpexample.Utils.LOCATION_PERMISSION_REQUEST_CODE;

public class DriveView extends AppCompatActivity implements android.location.LocationListener  {
    private final static String TAG = "DriveView";
    private Button endButton;
    private JourneyData journeyData;
    private LocationManager locationManager;
    DrivePresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drive_view);

        journeyData = new JourneyData();

        endButton = (Button) findViewById(R.id.endButton);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.endJourney(journeyData);
            }
        });

        initialize(this);

        enableMyLocation();
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this);
        } catch (java.lang.SecurityException ex) {

        } catch (IllegalArgumentException ex) {

        }
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


    public void loadResumeActivity() {
        //Intent anIntent = new Intent(getApplicationContext(), ResumeView.class);
        //startActivity(anIntent);
        //this.finish();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this);
            } catch (Exception ex) {
            }
        }
    }
}
