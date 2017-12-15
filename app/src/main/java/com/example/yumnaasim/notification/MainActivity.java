package com.example.yumnaasim.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_1 = 0*1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext());
        notifyBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifyBuilder.setTicker("Hello");
        notifyBuilder.setWhen(System.currentTimeMillis());

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        notifyBuilder.setContentIntent(PendingIntent.getActivity(MainActivity.this,0,intent,0));
        notifyBuilder.setContentTitle("New update available!");
        notifyBuilder.setContentText("Install new update");
        notifyBuilder.setAutoCancel(true);

        Notification notification = notifyBuilder.build();
        notificationManager.notify(NOTIFY_1,notification);

    }
}