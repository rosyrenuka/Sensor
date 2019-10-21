package com.dnurse.exttestlib;

import java.util.TimerTask;

/* renamed from: com.dnurse.exttestlib.f */
class C0609f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ DnurseDeviceTest f197a;

    C0609f(DnurseDeviceTest dnurseDeviceTest) {
        this.f197a = dnurseDeviceTest;
    }

    public void run() {
        if (this.f197a.f112k == 7) {
            this.f197a.f89I = (byte) (this.f197a.f89I - 1);
            if (this.f197a.f89I > 0) {
                this.f197a.f95O.onMeasuring(this.f197a.f112k, this.f197a.f89I);
                return;
            }
            this.f197a.f97Q.cancel();
            this.f197a.m41a(3000);
        }
    }
}
