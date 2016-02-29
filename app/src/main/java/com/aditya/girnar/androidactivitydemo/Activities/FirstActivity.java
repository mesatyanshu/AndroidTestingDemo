package com.aditya.girnar.androidactivitydemo.Activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.girnar.androidactivitydemo.R;
import com.aditya.girnar.androidactivitydemo.Receivers.NotificationBroadcastReceiver;

public class FirstActivity extends AppCompatActivity {

    private EditText username, password;
    private TextView tvLoaded;
    public static int count = 1;
    NotificationCompat.InboxStyle inboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        inboxStyle = new NotificationCompat.InboxStyle();
        setSupportActionBar(toolbar);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        tvLoaded = (TextView) findViewById(R.id.done);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onSubmit(View view) {
        Log.v("FirstActivity", "username = " + username.getText() + " password : " + password.getText());
        if (username.getText().toString().equals("aditya") && password.getText().toString().equals("breakingbad")) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent launchIntent = new Intent(this, SecondActivity.class);
            startActivity(launchIntent);
        } else
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
    }

    private void loadTestingView() {
        tvLoaded.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvLoaded.setVisibility(View.VISIBLE);
            }
        }, 1000 * 5);
    }


    public void notify(View view) {
        loadTestingView();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.whatsapp)
                        .setContentTitle("Himanshu")
                        .setContentText(count + " new messages");
        Intent resultIntent = new Intent(this, SecondActivity.class);
        Intent deleteIntent = new Intent(this, NotificationBroadcastReceiver.class);
        PendingIntent deletePendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, deleteIntent, 0);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(FirstActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setDeleteIntent(deletePendingIntent);
        mBuilder.setAutoCancel(true);
        inboxStyle.addLine("message content " + (count++));
        mBuilder.setStyle(inboxStyle);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(11, mBuilder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
