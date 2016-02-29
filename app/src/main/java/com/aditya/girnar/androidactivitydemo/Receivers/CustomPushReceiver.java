package com.aditya.girnar.androidactivitydemo.Receivers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.aditya.girnar.androidactivitydemo.Activities.SecondActivity;
import com.aditya.girnar.androidactivitydemo.R;
import com.parse.ParsePushBroadcastReceiver;

/**
 * Created by Aditya on 1/20/2016.
 */
public class CustomPushReceiver extends ParsePushBroadcastReceiver {

    public static final String TAG = CustomPushReceiver.class.getCanonicalName();

    public CustomPushReceiver() {
        super();
    }

    @Override
    protected void onPushReceive(Context context, Intent intent) {
        super.onPushReceive(context, intent);
        Log.v(TAG, "Push Received");
        Toast.makeText(context, "Push Received!!", Toast.LENGTH_SHORT).show();
    }
}
