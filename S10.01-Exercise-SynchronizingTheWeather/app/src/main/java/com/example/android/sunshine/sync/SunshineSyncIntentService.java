package com.example.android.sunshine.sync;// TOD (5 Create a new class called SunshineSyncIntentService that extends IntentService
//  TOD (6) Create a constructor that calls super and passes the name of this class
//  TOD (7) Override onHandleIntent, and within it, call SunshineSyncTask.syncWeather

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class SunshineSyncIntentService extends IntentService{

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     *   Used to name the worker thread, important only for debugging.
     */
    public SunshineSyncIntentService() {
        super("SunshineIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SunshineSyncTask.syncWeather(this);

    }
}