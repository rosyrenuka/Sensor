package com.dnurse.exttestlib;

/* renamed from: com.dnurse.exttestlib.c */
class C0606c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DnurseDeviceTest f194a;

    C0606c(DnurseDeviceTest dnurseDeviceTest) {
        this.f194a = dnurseDeviceTest;
    }

    public void run() {
        if (this.f194a.f112k == 0) {
            return;
        }
        if (!this.f194a.f92L.mo10834a().booleanValue()) {
            this.f194a.f96P.postDelayed(this.f194a.f103b, (long) this.f194a.f123v);
            return;
        }
        this.f194a.m52b(0);
        if (this.f194a.f87G) {
            this.f194a.wakeupDevice();
        }
    }
}
