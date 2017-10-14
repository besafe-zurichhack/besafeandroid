package com.marcos.perez.mvpexample;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Joan Manel on 14/10/2017.
 */

public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
