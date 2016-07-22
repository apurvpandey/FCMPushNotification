package com.ttnd.fcmtest;

import android.app.Service;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by apurv on 18/7/16.
 * E-mail : apurv.pandey@tothenew.com
 * Contact : +91-8377887369
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token  = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Refreshed token: " + token);


        sendRegistrationTokenToServer(token);
    }

    private void sendRegistrationTokenToServer(String token) {
        // TODO: Implement this method to send any registration to your app's servers.
    }
}
