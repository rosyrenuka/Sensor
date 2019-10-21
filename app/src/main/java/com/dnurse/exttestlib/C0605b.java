package com.dnurse.exttestlib;

/* renamed from: com.dnurse.exttestlib.b */
class C0605b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DnurseDeviceTest f193a;

    C0605b(DnurseDeviceTest dnurseDeviceTest) {
        this.f193a = dnurseDeviceTest;
    }

    public void run() {
        if (!this.f193a.f92L.mo10834a().booleanValue()) {
            this.f193a.f96P.postDelayed(this.f193a.f102a, (long) this.f193a.f121t);
        } else {
            this.f193a.m51b();
        }
    }
}
