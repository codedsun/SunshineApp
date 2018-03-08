package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;

// TOD (9) Create a class called SunshineSyncUtils
    //  TOD (10) Create a public static void method called startImmediateSync
    //  TOD (11) Within that method, start the SunshineSyncIntentServic
public class SunshineSyncUtils{

    public static void startImmediateSynce(Context context){
        Intent intent = new Intent(context, SunshineSyncIntentService.class);
        context.startService(intent);
    }
}