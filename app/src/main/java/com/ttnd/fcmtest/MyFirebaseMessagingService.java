package com.ttnd.fcmtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by apurv on 18/7/16.
 * E-mail : apurv.pandey@tothenew.com
 * Contact : +91-8377887369
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {


        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived() called with: remoteMessage = [" + remoteMessage + "]");
        Log.i(TAG, "From: " + remoteMessage.getFrom());
        //Log.i(TAG, "Notification Message Body: " + remoteMessage.getNotification().getIcon());
        //Log.i(TAG, "Notification Data Body: " + remoteMessage.getData());
        showNotification(remoteMessage.getNotification().getBody());
    }

    private void showNotification(String message) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.firabse)
                .setContentTitle("FCM Message")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);



        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

    }

}

