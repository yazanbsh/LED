package com.example.yazan.led;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingCallInterceptor extends BroadcastReceiver {                                    // 1

    @Override
    public void onReceive(Context context, Intent intent) {                                         // 2
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);                         // 3
        String msg="";// "Phone state changed to " + state;

        if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {                                   // 4
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);  // 5
            msg += "Incoming " + incomingNumber;

            // TODO This would be a good place to "Do something when the phone rings" <img src="http://androidlabs.org/wp-includes/images/smilies/icon_wink.gif" alt=";-)" class="wp-smiley">

        }

        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

    }

}
