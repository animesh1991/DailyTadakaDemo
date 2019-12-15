package com.animesh.dailytadkarecipes.app;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.animesh.dailytadkarecipes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class DailyTadka extends Application {

    private static DailyTadka mDailyTadkaInstance;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private String TAG = getClass().getName();

    @Override
    public void onCreate() {
        super.onCreate();
        mDailyTadkaInstance = this;
        initRemoteConfig();
    }

    public static DailyTadka getInstance() {
        return mDailyTadkaInstance;
    }

    public FirebaseRemoteConfig getFirebaseRemoteConfig() {
        return mFirebaseRemoteConfig;
    }

    private void initRemoteConfig() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings remoteConfigSettings = new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(true).build();
        mFirebaseRemoteConfig.setConfigSettings(remoteConfigSettings);
        mFirebaseRemoteConfig.setDefaults(R.xml.firebase_remote_defaults);
        // cache expiration in seconds
        long cacheExpiration = 3600;

        //expire the cache immediately for development mode.
        if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 2;
        }

        mFirebaseRemoteConfig.fetch(cacheExpiration).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    mFirebaseRemoteConfig.activateFetched();
                    Log.d(TAG,"Config Successful");
                }
                else {
                    Log.d(TAG,"Config failed");
                }
            }
        });
    }

}
