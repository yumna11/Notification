package com.example.yumnaasim.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_1 = 0*1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert();

    }

    private void alert() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext());
        notifyBuilder.setSmallIcon(R.drawable.ic_add_alert_black_24dp);
        notifyBuilder.setTicker("Hello");
        notifyBuilder.setWhen(System.currentTimeMillis());

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        notifyBuilder.setContentIntent(PendingIntent.getActivity(MainActivity.this,0,intent,0));
        notifyBuilder.setAutoCancel(true);
        notifyBuilder.setVibrate(new long[]{0, 2000, 2000, 6000, 6000});
        notifyBuilder.setLights(Color.RED,1000,1000);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notifyBuilder.setSound(alarmSound, AudioManager.STREAM_NOTIFICATION);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.remote);
        notifyBuilder.setContent(remoteViews);

        Notification notification = notifyBuilder.build();
        notificationManager.notify(NOTIFY_1,notification);
    }


}