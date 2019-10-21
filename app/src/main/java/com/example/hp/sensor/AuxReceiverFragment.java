package com.example.hp.sensor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AuxReceiverFragment extends BroadcastReceiver {
    Context mContext;
    private int mHeadsetState;
    private int mMicrophoneState;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        this.mContext = context;
        if (extras != null && intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            this.mHeadsetState = intent.getIntExtra("state", 0);
            this.mMicrophoneState = intent.getIntExtra("microphone", 0);
            if (this.mHeadsetState == 1 && this.mMicrophoneState == 1) {
                try {
                    Intent inGluco = new Intent(context, GlucometerActivity.class);
                    inGluco.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    inGluco.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    context.startActivity(inGluco);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
