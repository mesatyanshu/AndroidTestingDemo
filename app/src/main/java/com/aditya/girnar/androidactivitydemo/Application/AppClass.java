package com.aditya.girnar.androidactivitydemo.Application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Aditya on 1/20/2016.
 */
public class AppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "NBc6UptPCnBQ6iO9WoqaNdDqCOewNrNMipIF9xjJ", "XpUAdPf2WbgaZEBdaQvxR8i4sHbGnqmfEmcC0R5A");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
    }
}
