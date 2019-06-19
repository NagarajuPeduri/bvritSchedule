package org.bvrit.bvritschedule;

import android.app.Application;

import com.firebase.client.Firebase;

public class contextClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
