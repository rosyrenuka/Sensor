package com.dnurse.exttestlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;

/* renamed from: com.dnurse.exttestlib.a */
class C0604a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DnurseDeviceTest f192a;

    C0604a(DnurseDeviceTest dnurseDeviceTest) {
        this.f192a = dnurseDeviceTest;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("S3HealthDnurseTest", "Get event");
        if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            return;
        }
        if (intent.getIntExtra("state", 0) == 0 || intent.getIntExtra("microphone", 0) != 1) {
            if (this.f192a.f87G) {
                if (this.f192a.f112k != 0) {
                    this.f192a.m58c();
                    this.f192a.f96P.postDelayed(this.f192a.f103b, (long) this.f192a.f123v);
                }
                this.f192a.f87G = false;
                Log.i("S3HealthDnurseTest", "Headset removed");
            }
        } else if (!this.f192a.f87G) {
            Log.i("S3HealthDnurseTest", "Model: " + Build.MODEL);
            Log.i("S3HealthDnurseTest", "Ver: " + VERSION.RELEASE);
            this.f192a.f87G = true;
            this.f192a.wakeupDevice();
        }
    }
}
