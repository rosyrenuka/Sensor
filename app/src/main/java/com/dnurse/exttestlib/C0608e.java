package com.dnurse.exttestlib;

/* renamed from: com.dnurse.exttestlib.e */
class C0608e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DnurseDeviceTest f196a;

    C0608e(DnurseDeviceTest dnurseDeviceTest) {
        this.f196a = dnurseDeviceTest;
    }

    public void run() {
        switch (this.f196a.f112k) {
            case 1:
                if (!this.f196a.f93M.f128a) {
                    this.f196a.m52b(14);
                    return;
                } else if (this.f196a.f92L.mo10835b()) {
                    this.f196a.m52b(15);
                    return;
                } else {
                    this.f196a.m52b(16);
                    return;
                }
            case 2:
                this.f196a.m52b(16);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                this.f196a.m52b(17);
                return;
            default:
                return;
        }
    }
}
