package com.example.yumnaasim.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    private static final int NOTIFY_1 = 0*1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext());
        notifyBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifyBuilder.setTicker("Hello");
        notifyBuilder.setWhen(System.currentTimeMillis());

        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        notifyBuilder.setContentIntent(PendingIntent.getActivity(Main2Activity.this,0,intent,0));
        notifyBuilder.setContentTitle("Installation completed!");
        notifyBuilder.setContentText("You have successfully installed");
        notifyBuilder.setNumber(2);

        Notification notification = notifyBuilder.build();
        notificationManager.notify(NOTIFY_1,notification);
    }
}
