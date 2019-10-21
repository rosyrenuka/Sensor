package com.dnurse.exttestlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;

public class DnurseDeviceTest {

    /* renamed from: S */
    private static SimpleDateFormat f80S = null;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public byte f81A = 0;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public boolean f82B = true;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public byte f83C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public byte f84D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f85E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public String f86F = "";
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f87G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f88H = false;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public byte f89I;

    /* renamed from: J */
    private byte f90J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public byte f91K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C0602d f92L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public C0599a f93M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public Context f94N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public IMeasureDataResultCallback f95O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public Handler f96P = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public Timer f97Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C0601c f98R;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public float f99T = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public float f100U = 0.0f;

    /* renamed from: V */
    private BroadcastReceiver f101V = new C0604a(this);

    /* renamed from: a */
    Runnable f102a = new C0605b(this);

    /* renamed from: b */
    Runnable f103b = new C0606c(this);

    /* renamed from: c */
    Runnable f104c = new C0607d(this);

    /* renamed from: d */
    Runnable f105d = new C0608e(this);

    /* renamed from: e */
    private final byte f106e = 0;

    /* renamed from: f */
    private final byte f107f = 1;

    /* renamed from: g */
    private final byte f108g = 2;

    /* renamed from: h */
    private final byte f109h = 3;

    /* renamed from: i */
    private final byte f110i = 0;

    /* renamed from: j */
    private final byte f111j = 1;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f112k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public float f113l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int[][] f114m = {new int[]{4, 7, 11, 16, 11, 20, 1}, new int[]{7, 12, 17, 22, 19, 20, 2}, new int[]{10, 16, 23, 30, 19, 20, 3}};
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f115n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public byte f116o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f117p = 20;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f118q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f119r = 10;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f120s = 1800;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public int f121t = 20;

    /* renamed from: u */
    private int f122u = 10;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f123v = 10;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f124w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f125x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f126y = true;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f127z = true;

    /* renamed from: com.dnurse.exttestlib.DnurseDeviceTest$a */
    public class C0599a {

        /* renamed from: a */
        public boolean f128a;

        /* renamed from: c */
        private final int f130c = 4000;

        /* renamed from: d */
        private int f131d = -1;

        /* renamed from: e */
        private int f132e = 0;

        /* renamed from: f */
        private AudioManager f133f;

        /* renamed from: g */
        private AudioTrack f134g;

        public static final short MAX_POWER_OF_TWO = 1 << (Short.SIZE - 2);

        /* renamed from: h */
        private final short[] f135h = {0, 0, MAX_POWER_OF_TWO, -16384, 26624, -26624, 31744, -31744, Short.MAX_VALUE, Short.MIN_VALUE, 31744, -31744, 26624, -26624, MAX_POWER_OF_TWO, -16384, 0, 0, -16384, MAX_POWER_OF_TWO, -26624, 26624, -31744, 31744, Short.MIN_VALUE, Short.MAX_VALUE, -31744, 31744, -26624, 26624, -16384, MAX_POWER_OF_TWO};

        /* renamed from: i */
        private final short[] f136i = {0, 0, 31744, -31744, Short.MAX_VALUE, Short.MIN_VALUE, 31744, -31744, 0, 0, -31744, 31744, Short.MIN_VALUE, Short.MAX_VALUE, -31744, 31744, 0, 0, 31744, -31744, Short.MAX_VALUE, Short.MIN_VALUE, 31744, -31744, 0, 0, -31744, 31744, Short.MIN_VALUE, Short.MAX_VALUE, -31744, 31744};

        /* renamed from: j */
        private final short[] f137j = {0, 0, 0, 0, 0, 0, 0, 0};

        C0599a() {
            this.f133f = (AudioManager) DnurseDeviceTest.this.f94N.getSystemService(Context.AUDIO_SERVICE);
            this.f132e = AudioTrack.getMinBufferSize(4000, 12, 2);
            Log.i("S3HealthDnurseTest", "AudPly: min buffer=" + this.f132e);
            this.f134g = new AudioTrack(3, 4000, 12, 2, this.f132e, 1);
            if (this.f134g.getState() == 1) {
                this.f134g.setStereoVolume(AudioTrack.getMaxVolume(), AudioTrack.getMaxVolume());
                return;
            }
            this.f134g.release();
            this.f134g = null;
        }

        /* renamed from: a */
        private boolean m86a(short[] sArr, int i, int i2) {
            if (this.f134g == null) {
                return false;
            }
            int length = ((this.f132e / this.f137j.length) / 2) + 2;
            if (this.f134g != null) {
                short[] sArr2 = new short[((sArr.length * i2) + (this.f137j.length * i) + (this.f137j.length * length))];
                int i3 = 0;
                int i4 = 0;
                while (i3 < i) {
                    int i5 = i4;
                    int i6 = 0;
                    while (i6 < this.f137j.length) {
                        int i7 = i5 + 1;
                        sArr2[i5] = this.f137j[i6];
                        i6++;
                        i5 = i7;
                    }
                    i3++;
                    i4 = i5;
                }
                int i8 = 0;
                while (i8 < i2) {
                    int i9 = i4;
                    int i10 = 0;
                    while (i10 < sArr.length) {
                        int i11 = i9 + 1;
                        sArr2[i9] = sArr[i10];
                        i10++;
                        i9 = i11;
                    }
                    i8++;
                    i4 = i9;
                }
                int i12 = 0;
                while (i12 < length) {
                    int i13 = i4;
                    int i14 = 0;
                    while (i14 < this.f137j.length) {
                        int i15 = i13 + 1;
                        sArr2[i13] = this.f137j[i14];
                        i14++;
                        i13 = i15;
                    }
                    i12++;
                    i4 = i13;
                }
                this.f134g.flush();
                this.f134g.play();
                this.f134g.write(sArr2, 0, sArr2.length);
                if (!DnurseDeviceTest.this.f127z) {
                    this.f134g.stop();
                }
                Log.i("S3HealthDnurseTest", "AudPly: Play F:" + i + " B:" + length + " T:" + i2 + " finished!");
            }
            return true;
        }

        /* renamed from: a */
        public void mo10819a(boolean z) {
            int t = DnurseDeviceTest.this.f119r + DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][5];
            if (z) {
                m86a(this.f136i, DnurseDeviceTest.this.f118q, t);
            } else {
                m86a(this.f135h, DnurseDeviceTest.this.f118q, t);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo10820a() {

            int n;
            int n2 = this.f133f.getStreamVolume(3);
            Log.i((String)"S3HealthDnurseTest", (String)("AudPly: setMaxVolume Old=" + n2));
            if (this.f131d == -1) {
                this.f131d = n2;
            }
            int n3 = this.f133f.getStreamMaxVolume(3);
            this.f133f.setStreamVolume(3, n3, 0);
            if (DnurseDeviceTest.this.f126y) {
                block9 : {
                    if (n3 != this.f133f.getStreamVolume(3)) {
                        try {
                            Thread.sleep((long)1000L);
                            n = n3;
                            break block9;
                        }
                        catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                    n = n3;
                }
                while (n > n3 * 2 / 3 && n != this.f133f.getStreamVolume(3)) {
                    this.f133f.setStreamVolume(3, --n, 0);
                }
                if (Build.VERSION.RELEASE.compareTo("4.3") >= 0 && n < n3) {
                    this.f133f.setStreamVolume(3, n3, 9);
                }
                if (n != this.f133f.getStreamVolume(3)) {
                    return false;
                }
            } else {
                n = n3;
            }
            Log.i((String)"S3HealthDnurseTest", (String)("AudPly: Vol change from " + n2 + " to " + n));
            boolean bl = n == n3;
            this.f128a = bl;
            return this.m86a(this.f135h, DnurseDeviceTest.this.f117p, 0);
            /*
                r7 = this;
                r2 = 0
                r6 = 3
                android.media.AudioManager r0 = r7.f133f
                int r3 = r0.getStreamVolume(r6)
                java.lang.String r0 = "S3HealthDnurseTest"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "AudPly: setMaxVolume Old="
                java.lang.StringBuilder r1 = r1.append(r4)
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.String r1 = r1.toString()
                android.util.Log.i(r0, r1)
                int r0 = r7.f131d
                r1 = -1
                if (r0 != r1) goto L_0x0027
                r7.f131d = r3
            L_0x0027:
                android.media.AudioManager r0 = r7.f133f
                int r1 = r0.getStreamMaxVolume(r6)
                android.media.AudioManager r0 = r7.f133f
                r0.setStreamVolume(r6, r1, r2)
                com.dnurse.exttestlib.DnurseDeviceTest r0 = com.dnurse.exttestlib.DnurseDeviceTest.this
                boolean r0 = r0.f126y
                if (r0 == 0) goto L_0x0080
                android.media.AudioManager r0 = r7.f133f
                int r0 = r0.getStreamVolume(r6)
                if (r1 == r0) goto L_0x0062
                r4 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x005e }
                r0 = r1
            L_0x0048:
                int r4 = r1 * 2
                int r4 = r4 / 3
                if (r0 <= r4) goto L_0x0064
                android.media.AudioManager r4 = r7.f133f
                int r4 = r4.getStreamVolume(r6)
                if (r0 == r4) goto L_0x0064
                int r0 = r0 + -1
                android.media.AudioManager r4 = r7.f133f
                r4.setStreamVolume(r6, r0, r2)
                goto L_0x0048
            L_0x005e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0062:
                r0 = r1
                goto L_0x0048
            L_0x0064:
                java.lang.String r4 = android.os.Build.VERSION.RELEASE
                java.lang.String r5 = "4.3"
                int r4 = r4.compareTo(r5)
                if (r4 < 0) goto L_0x0077
                if (r0 >= r1) goto L_0x0077
                android.media.AudioManager r4 = r7.f133f
                r5 = 9
                r4.setStreamVolume(r6, r1, r5)
            L_0x0077:
                android.media.AudioManager r4 = r7.f133f
                int r4 = r4.getStreamVolume(r6)
                if (r0 == r4) goto L_0x0081
            L_0x007f:
                return r2
            L_0x0080:
                r0 = r1
            L_0x0081:
                java.lang.String r4 = "S3HealthDnurseTest"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "AudPly: Vol change from "
                java.lang.StringBuilder r5 = r5.append(r6)
                java.lang.StringBuilder r3 = r5.append(r3)
                java.lang.String r5 = " to "
                java.lang.StringBuilder r3 = r3.append(r5)
                java.lang.StringBuilder r3 = r3.append(r0)
                java.lang.String r3 = r3.toString()
                android.util.Log.i(r4, r3)
                if (r0 != r1) goto L_0x00b5
                r0 = 1
            L_0x00a6:
                r7.f128a = r0
                short[] r0 = r7.f135h
                com.dnurse.exttestlib.DnurseDeviceTest r1 = com.dnurse.exttestlib.DnurseDeviceTest.this
                int r1 = r1.f117p
                boolean r2 = r7.m86a(r0, r1, r2)
                goto L_0x007f
            L_0x00b5:
                r0 = r2
                goto L_0x00a6
            */

            //throw new UnsupportedOperationException("Method not decompiled: com.dnurse.exttestlib.DnurseDeviceTest.C0599a.mo10820a():boolean");
        }

        /* renamed from: b */
        public void mo10821b() {
            if (this.f131d != -1) {
                this.f133f.setStreamVolume(3, this.f131d, 0);
                Log.i("S3HealthDnurseTest", "AudPly: Vol change to " + this.f131d);
                this.f131d = -1;
            }
        }

        /* renamed from: c */
        public void mo10822c() {
            int t = DnurseDeviceTest.this.f119r + 4;
            if (DnurseDeviceTest.this.f116o == 1) {
                m86a(this.f136i, DnurseDeviceTest.this.f118q, t);
            } else {
                m86a(this.f135h, DnurseDeviceTest.this.f118q, t);
            }
        }

        /* renamed from: d */
        public void mo10823d() {
            m86a(this.f135h, DnurseDeviceTest.this.f118q, DnurseDeviceTest.this.f119r);
        }

        /* renamed from: e */
        public void mo10824e() {
            if (this.f134g != null) {
                this.f134g.flush();
                this.f134g.stop();
                Log.i("S3HealthDnurseTest", "AudPly: Stop playing!");
            }
        }
    }

    /* renamed from: com.dnurse.exttestlib.DnurseDeviceTest$b */
    private class C0600b extends AsyncTask {
        private C0600b() {
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        /* synthetic */ C0600b(DnurseDeviceTest dnurseDeviceTest, C0604a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8 A[SYNTHETIC, Splitter:B:34:0x00c8] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Void doInBackground(String... r6) {
            /*
                r5 = this;
                r2 = 0
                int r0 = r6.length
                r1 = 8
                if (r0 >= r1) goto L_0x0007
            L_0x0006:
                return r2
            L_0x0007:
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r1 = "s"
                r3 = 0
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "v"
                r3 = 1
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "t"
                r3 = 2
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "i"
                r3 = 3
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "vo"
                r3 = 4
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "te"
                r3 = 5
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                com.dnurse.exttestlib.DnurseDeviceTest r1 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ JSONException -> 0x00ac }
                android.content.Context r1 = r1.f94N     // Catch:{ JSONException -> 0x00ac }
                com.dnurse.exttestlib.DnurseDeviceTest r3 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r3 = r3.f86F     // Catch:{ JSONException -> 0x00ac }
                java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ JSONException -> 0x00ac }
                boolean r1 = r1.exists()     // Catch:{ JSONException -> 0x00ac }
                if (r1 != 0) goto L_0x006f
                java.lang.String r1 = "hv"
                r3 = 6
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "sv"
                r3 = 7
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r0.put(r1, r3)     // Catch:{ JSONException -> 0x00ac }
                com.dnurse.exttestlib.DnurseDeviceTest r1 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ JSONException -> 0x00ac }
                r3 = 0
                r3 = r6[r3]     // Catch:{ JSONException -> 0x00ac }
                r1.m44a(r3)     // Catch:{ JSONException -> 0x00ac }
            L_0x006f:
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00ac }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00ac }
                r1.<init>()     // Catch:{ JSONException -> 0x00ac }
                java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r1 = "\n"
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ JSONException -> 0x00ac }
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00ac }
                com.dnurse.exttestlib.DnurseDeviceTest r1 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ IOException -> 0x00b2, all -> 0x00c4 }
                android.content.Context r1 = r1.f94N     // Catch:{ IOException -> 0x00b2, all -> 0x00c4 }
                java.lang.String r3 = "backup.d"
                r4 = 32768(0x8000, float:4.5918E-41)
                java.io.FileOutputStream r1 = r1.openFileOutput(r3, r4)     // Catch:{ IOException -> 0x00b2, all -> 0x00c4 }
                byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00d3 }
                r1.write(r0)     // Catch:{ IOException -> 0x00d3 }
                r1.flush()     // Catch:{ IOException -> 0x00d3 }
                if (r1 == 0) goto L_0x0006
                r1.close()     // Catch:{ IOException -> 0x00a6 }
                goto L_0x0006
            L_0x00a6:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ JSONException -> 0x00ac }
                goto L_0x0006
            L_0x00ac:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0006
            L_0x00b2:
                r0 = move-exception
                r1 = r2
            L_0x00b4:
                r0.printStackTrace()     // Catch:{ all -> 0x00d1 }
                if (r1 == 0) goto L_0x0006
                r1.close()     // Catch:{ IOException -> 0x00be }
                goto L_0x0006
            L_0x00be:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ JSONException -> 0x00ac }
                goto L_0x0006
            L_0x00c4:
                r0 = move-exception
                r1 = r2
            L_0x00c6:
                if (r1 == 0) goto L_0x00cb
                r1.close()     // Catch:{ IOException -> 0x00cc }
            L_0x00cb:
                throw r0     // Catch:{ JSONException -> 0x00ac }
            L_0x00cc:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ JSONException -> 0x00ac }
                goto L_0x00cb
            L_0x00d1:
                r0 = move-exception
                goto L_0x00c6
            L_0x00d3:
                r0 = move-exception
                goto L_0x00b4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dnurse.exttestlib.DnurseDeviceTest.C0600b.doInBackground(java.lang.String[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            if (DnurseDeviceTest.this.f98R == null) {
                DnurseDeviceTest.this.f98R = new C0601c(DnurseDeviceTest.this, null);
                DnurseDeviceTest.this.f98R.execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.dnurse.exttestlib.DnurseDeviceTest$c */
    private class C0601c extends AsyncTask {
        private C0601c() {
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        /* synthetic */ C0601c(DnurseDeviceTest dnurseDeviceTest, C0604a aVar) {
            this();
        }

        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r1v1 */
        /* JADX WARNING: type inference failed for: r2v1, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r2v3 */
        /* JADX WARNING: type inference failed for: r1v4 */
        /* JADX WARNING: type inference failed for: r2v4 */
        /* JADX WARNING: type inference failed for: r8v0 */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v7 */
        /* JADX WARNING: type inference failed for: r2v8 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: type inference failed for: r2v11 */
        /* JADX WARNING: type inference failed for: r2v12 */
        /* JADX WARNING: type inference failed for: r1v16 */
        /* JADX WARNING: type inference failed for: r2v14 */
        /* JADX WARNING: type inference failed for: r2v15 */
        /* JADX WARNING: type inference failed for: r2v16 */
        /* JADX WARNING: type inference failed for: r2v17 */
        /* JADX WARNING: type inference failed for: r2v18 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9 A[SYNTHETIC, Splitter:B:30:0x00d9] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00de A[Catch:{ IOException -> 0x013e }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A[SYNTHETIC, Splitter:B:60:0x012e] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0133 A[Catch:{ IOException -> 0x0139 }] */
        /* JADX WARNING: Unknown variable types count: 7 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private String m95a(String r11, java.util.Map r12) {
            return "NONE";
        }

        /* renamed from: a */
        private boolean m96a() {
            File fileStreamPath = DnurseDeviceTest.this.f94N.getFileStreamPath("s.d");
            if (!fileStreamPath.exists()) {
                File fileStreamPath2 = DnurseDeviceTest.this.f94N.getFileStreamPath("backup.d");
                if (!fileStreamPath2.exists() || !fileStreamPath2.renameTo(fileStreamPath)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        private boolean m97a(ArrayList arrayList) {
            String str = "http://api.dnurse.com/api/other/data";
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(new JSONObject((String) it.next()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            String substring = DnurseDeviceTest.MD5(DnurseDeviceTest.MD5(jSONArray.toString()) + "S3HealthDnurseTest".substring(2)).substring(0, 8);
            HashMap hashMap = new HashMap();
            hashMap.put("v", jSONArray.toString());
            hashMap.put("p", "S3HealthDnurseTest");
            hashMap.put("si", substring);
            String a = m95a(str, hashMap);
            Log.d("S3HealthDnurseTest", "upload: " + a);
            return !"".equals(a);
        }

        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r3v0, types: [java.io.FileInputStream] */
        /* JADX WARNING: type inference failed for: r2v1, types: [java.io.BufferedReader] */
        /* JADX WARNING: type inference failed for: r3v1 */
        /* JADX WARNING: type inference failed for: r2v2, types: [java.io.FileInputStream] */
        /* JADX WARNING: type inference failed for: r1v3, types: [java.io.BufferedReader] */
        /* JADX WARNING: type inference failed for: r3v2 */
        /* JADX WARNING: type inference failed for: r2v3 */
        /* JADX WARNING: type inference failed for: r1v5 */
        /* JADX WARNING: type inference failed for: r2v4 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: type inference failed for: r2v6 */
        /* JADX WARNING: type inference failed for: r2v7 */
        /* JADX WARNING: type inference failed for: r2v8 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r3v4 */
        /* JADX WARNING: type inference failed for: r3v5 */
        /* JADX WARNING: type inference failed for: r1v7 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0065 A[SYNTHETIC, Splitter:B:42:0x0065] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x006a A[SYNTHETIC, Splitter:B:45:0x006a] */
        /* JADX WARNING: Unknown variable types count: 5 */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ArrayList m98b() {
            /*
                r5 = this;
                r2 = 0
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                com.dnurse.exttestlib.DnurseDeviceTest r0 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ FileNotFoundException -> 0x0081, all -> 0x0061 }
                android.content.Context r0 = r0.f94N     // Catch:{ FileNotFoundException -> 0x0081, all -> 0x0061 }
                java.lang.String r1 = "s.d"
                java.io.FileInputStream r3 = r0.openFileInput(r1)     // Catch:{ FileNotFoundException -> 0x0081, all -> 0x0061 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0084, all -> 0x0078 }
                java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0084, all -> 0x0078 }
                r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0084, all -> 0x0078 }
                r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0084, all -> 0x0078 }
            L_0x001c:
                java.lang.String r0 = r1.readLine()     // Catch:{ IOException -> 0x0038 }
                if (r0 == 0) goto L_0x002d
                r4.add(r0)     // Catch:{ IOException -> 0x0038 }
                int r0 = r4.size()     // Catch:{ IOException -> 0x0038 }
                r2 = 100
                if (r0 < r2) goto L_0x001c
            L_0x002d:
                if (r1 == 0) goto L_0x0032
                r1.close()     // Catch:{ IOException -> 0x0052 }
            L_0x0032:
                if (r3 == 0) goto L_0x0037
                r3.close()     // Catch:{ IOException -> 0x0057 }
            L_0x0037:
                return r4
            L_0x0038:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ FileNotFoundException -> 0x003d, all -> 0x007a }
                goto L_0x002d
            L_0x003d:
                r0 = move-exception
                r2 = r3
            L_0x003f:
                r0.printStackTrace()     // Catch:{ all -> 0x007d }
                if (r1 == 0) goto L_0x0047
                r1.close()     // Catch:{ IOException -> 0x005c }
            L_0x0047:
                if (r2 == 0) goto L_0x0037
                r2.close()     // Catch:{ IOException -> 0x004d }
                goto L_0x0037
            L_0x004d:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0037
            L_0x0052:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0032
            L_0x0057:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0037
            L_0x005c:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0047
            L_0x0061:
                r0 = move-exception
                r3 = r2
            L_0x0063:
                if (r2 == 0) goto L_0x0068
                r2.close()     // Catch:{ IOException -> 0x006e }
            L_0x0068:
                if (r3 == 0) goto L_0x006d
                r3.close()     // Catch:{ IOException -> 0x0073 }
            L_0x006d:
                throw r0
            L_0x006e:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x0068
            L_0x0073:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x006d
            L_0x0078:
                r0 = move-exception
                goto L_0x0063
            L_0x007a:
                r0 = move-exception
                r2 = r1
                goto L_0x0063
            L_0x007d:
                r0 = move-exception
                r3 = r2
                r2 = r1
                goto L_0x0063
            L_0x0081:
                r0 = move-exception
                r1 = r2
                goto L_0x003f
            L_0x0084:
                r0 = move-exception
                r1 = r2
                r2 = r3
                goto L_0x003f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dnurse.exttestlib.DnurseDeviceTest.C0601c.m98b():java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            android.util.Log.d("S3HealthDnurseTest", "doInBackground: upload failed");
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Void doInBackground(Void... r7) {
            /*
                r6 = this;
                r5 = 3
            L_0x0001:
                java.util.ArrayList r0 = r6.m98b()     // Catch:{ ConnectException -> 0x0072 }
                if (r0 == 0) goto L_0x002c
                int r1 = r0.size()     // Catch:{ ConnectException -> 0x0072 }
                if (r1 <= 0) goto L_0x002c
                boolean r0 = r6.m97a(r0)     // Catch:{ ConnectException -> 0x0072 }
                if (r0 == 0) goto L_0x0077
                com.dnurse.exttestlib.DnurseDeviceTest r0 = com.dnurse.exttestlib.DnurseDeviceTest.this     // Catch:{ ConnectException -> 0x0072 }
                android.content.Context r0 = r0.f94N     // Catch:{ ConnectException -> 0x0072 }
                java.lang.String r1 = "s.d"
                java.io.File r1 = r0.getFileStreamPath(r1)     // Catch:{ ConnectException -> 0x0072 }
                boolean r0 = r1.delete()     // Catch:{ ConnectException -> 0x0072 }
                if (r0 == 0) goto L_0x0034
                java.lang.String r0 = "S3HealthDnurseTest"
                java.lang.String r1 = "doInBackground: delete success"
                android.util.Log.d(r0, r1)     // Catch:{ ConnectException -> 0x0072 }
            L_0x002c:
                boolean r0 = r6.m96a()     // Catch:{ ConnectException -> 0x0072 }
                if (r0 != 0) goto L_0x0001
            L_0x0032:
                r0 = 0
                return r0
            L_0x0034:
                java.lang.String r0 = "S3HealthDnurseTest"
                java.lang.String r2 = "doInBackground: delete failed"
                android.util.Log.d(r0, r2)     // Catch:{ ConnectException -> 0x0072 }
                r0 = 0
            L_0x003c:
                if (r0 >= r5) goto L_0x006a
                int r0 = r0 + 1
                java.lang.String r2 = "S3HealthDnurseTest"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x0072 }
                r3.<init>()     // Catch:{ ConnectException -> 0x0072 }
                java.lang.String r4 = "doInBackground: retry delete :"
                java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ ConnectException -> 0x0072 }
                java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ ConnectException -> 0x0072 }
                java.lang.String r3 = r3.toString()     // Catch:{ ConnectException -> 0x0072 }
                android.util.Log.d(r2, r3)     // Catch:{ ConnectException -> 0x0072 }
                r2 = 100
                java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x006d }
            L_0x005d:
                boolean r2 = r1.delete()     // Catch:{ ConnectException -> 0x0072 }
                if (r2 == 0) goto L_0x003c
                java.lang.String r1 = "S3HealthDnurseTest"
                java.lang.String r2 = "doInBackground: retry success"
                android.util.Log.d(r1, r2)     // Catch:{ ConnectException -> 0x0072 }
            L_0x006a:
                if (r0 < r5) goto L_0x002c
                goto L_0x0032
            L_0x006d:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ ConnectException -> 0x0072 }
                goto L_0x005d
            L_0x0072:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0032
            L_0x0077:
                java.lang.String r0 = "S3HealthDnurseTest"
                java.lang.String r1 = "doInBackground: upload failed"
                android.util.Log.d(r0, r1)     // Catch:{ ConnectException -> 0x0072 }
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dnurse.exttestlib.DnurseDeviceTest.C0601c.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            DnurseDeviceTest.this.f98R = null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            m96a();
        }
    }

    /* renamed from: com.dnurse.exttestlib.DnurseDeviceTest$d */
    public class C0602d {

        /* renamed from: b */
        private final int f141b = 44100;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public AudioRecord f142c;

        /* renamed from: d */
        private int f143d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public short f144e = 0;

        /* renamed from: com.dnurse.exttestlib.DnurseDeviceTest$d$a */
        class C0603a implements Runnable {

            /* renamed from: A */
            private final byte f145A = 5;

            /* renamed from: B */
            private final byte f146B = 6;

            /* renamed from: C */
            private final byte f147C = 5;

            /* renamed from: D */
            private final byte f148D = 6;

            /* renamed from: E */
            private final byte f149E = 8;

            /* renamed from: F */
            private byte f150F = 8;

            /* renamed from: G */
            private byte[] f151G = new byte[255];

            /* renamed from: H */
            private byte f152H = 0;

            /* renamed from: I */
            private byte f153I = 0;

            /* renamed from: J */
            private byte f154J = 0;

            /* renamed from: K */
            private byte f155K = 0;

            /* renamed from: L */
            private byte f156L = 0;

            /* renamed from: M */
            private byte f157M = 0;

            /* renamed from: N */
            private short f158N = 0;

            /* renamed from: O */
            private boolean f159O = false;

            /* renamed from: P */
            private boolean f160P = false;

            /* renamed from: Q */
            private int[] f161Q = new int[9];

            /* renamed from: R */
            private int f162R = 0;

            /* renamed from: S */
            private int f163S = 0;

            /* renamed from: T */
            private int f164T = 0;

            /* renamed from: U */
            private int f165U = 0;

            /* renamed from: b */
            private short[] f167b;

            /* renamed from: c */
            private byte[] f168c;

            /* renamed from: d */
            private int f169d;

            /* renamed from: e */
            private byte f170e = 0;

            /* renamed from: f */
            private final byte[] f171f = {Byte.MIN_VALUE, 8, -120, 0};

            /* renamed from: g */
            private final byte[] f172g = {Byte.MIN_VALUE, 8, -86, 85};

            /* renamed from: h */
            private final byte[] f173h = {-61, 60, -52, 51};

            /* renamed from: i */
            private final byte[] f174i = {-61, 60, -91, 90};

            /* renamed from: j */
            private final byte f175j = 4;

            /* renamed from: k */
            private final byte f176k = -1;

            /* renamed from: l */
            private final byte f177l = -1;

            /* renamed from: m */
            private final byte f178m = 0;

            /* renamed from: n */
            private final byte f179n = 16;

            /* renamed from: o */
            private final byte f180o = 2;

            /* renamed from: p */
            private final byte f181p = 1;

            /* renamed from: q */
            private final byte f182q = 3;

            /* renamed from: r */
            private final byte f183r = 4;

            /* renamed from: s */
            private final short f184s = 6;

            /* renamed from: t */
            private final short f185t = 7;

            /* renamed from: u */
            private final short f186u = 8;

            /* renamed from: v */
            private final byte f187v = 2;

            /* renamed from: w */
            private final byte f188w = 4;

            /* renamed from: x */
            private final byte f189x = 5;

            /* renamed from: y */
            private final byte f190y = 6;

            /* renamed from: z */
            private final byte f191z = 4;

            public C0603a(int i) {
                if (DnurseDeviceTest.this.f116o == 1) {
                    DnurseDeviceTest.this.f115n = 0;
                } else if (DnurseDeviceTest.this.f116o == 2) {
                    DnurseDeviceTest.this.f115n = 1;
                } else if (DnurseDeviceTest.this.f116o == 3) {
                    DnurseDeviceTest.this.f115n = 2;
                } else {
                    DnurseDeviceTest.this.f115n = 1;
                }
                this.f170e = (byte) DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][4];
                if (DnurseDeviceTest.this.f81A == 0 || DnurseDeviceTest.this.f81A == 1) {
                    DnurseDeviceTest.this.f82B = true;
                } else {
                    DnurseDeviceTest.this.f82B = false;
                }
                this.f169d = i / 2;
                this.f167b = new short[this.f169d];
                this.f168c = new byte[(this.f169d * 2)];
                if (C0602d.this.f142c != null && C0602d.this.f142c.getRecordingState() == 3) {
                    C0602d.this.f142c.read(this.f167b, 0, this.f169d);
                }
            }

            /* renamed from: a */
            private int m110a(short s) {
                int i = 0;
                if ((s <= 0 || this.f162R <= 0) && (!(s == 0 && this.f162R == 0) && (s >= 0 || this.f162R >= 0))) {
                    if (this.f162R == 0 || this.f163S <= DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][6]) {
                        this.f165U += this.f163S;
                    } else if ((this.f162R <= 0 || this.f164T <= 0) && this.f162R >= 0) {
                        i = this.f165U;
                        this.f165U = this.f163S;
                        this.f164T = this.f162R;
                    } else {
                        this.f165U += this.f163S;
                        this.f164T = this.f162R;
                    }
                    this.f162R = s;
                    this.f163S = 1;
                } else {
                    this.f163S++;
                }
                return i;
            }

            /* renamed from: a */
            private void m111a() {
                for (int i = 0; i < this.f156L - 1; i++) {
                    this.f151G[i] = this.f151G[i + 1];
                }
                this.f156L = (byte) (this.f156L - 1);
            }

            /* renamed from: a */
            private void m112a(int i) {
                if (this.f160P) {
                    this.f161Q[this.f152H] = i;
                    this.f158N = (short) (this.f158N >> 1);
                    if (i > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][1] && i <= DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][2]) {
                        this.f158N = (short) (this.f158N | 256);
                        this.f157M = (byte) (this.f157M ^ 1);
                    } else if (i < DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][0] || i > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][2]) {
                        Log.i("S3HealthDnurseTest", "R: EN:" + i);
                        m116d();
                        this.f154J = 0;
                        this.f153I = 0;
                        this.f155K = 0;
                        this.f159O = false;
                        return;
                    }
                    Log.i("S3HealthDnurseTest", "RN:" + i);
                    if (this.f152H >= 8) {
                        m116d();
                        if (this.f157M != 0) {
                            Log.i("S3HealthDnurseTest", "R: Bit Check error!");
                            m115c();
                            return;
                        }
                        this.f158N = (short) (this.f158N & 255);
                        Log.i("S3HealthDnurseTest", "R: D=" + String.format("%02X", new Object[]{Short.valueOf(this.f158N)}));
                        if (DnurseDeviceTest.this.f112k == 1) {
                            m117e();
                        } else {
                            m118f();
                        }
                    } else {
                        this.f152H = (byte) (this.f152H + 1);
                    }
                } else if (DnurseDeviceTest.this.f112k == 1 && DnurseDeviceTest.this.f116o == 0 && !this.f159O) {
                    if (i > DnurseDeviceTest.this.f114m[1][1] && i <= DnurseDeviceTest.this.f114m[1][2]) {
                        Log.i("S3HealthDnurseTest", "RB:" + i);
                        this.f154J = (byte) (this.f154J + 1);
                        this.f153I = 0;
                        this.f155K = 0;
                        if (this.f154J >= 10) {
                            Log.i("S3HealthDnurseTest", "RB X");
                            this.f159O = true;
                            DnurseDeviceTest.this.f115n = 1;
                        }
                    } else if (i > DnurseDeviceTest.this.f114m[1][2] && i <= DnurseDeviceTest.this.f114m[1][3]) {
                        Log.i("S3HealthDnurseTest", "RB:" + i);
                        this.f153I = (byte) (this.f153I + 1);
                        this.f154J = 0;
                        this.f155K = 0;
                        if (this.f153I >= 4) {
                            Log.i("S3HealthDnurseTest", "RB M");
                            this.f159O = true;
                            DnurseDeviceTest.this.f115n = 1;
                        }
                    } else if (i <= DnurseDeviceTest.this.f114m[2][2] || i > DnurseDeviceTest.this.f114m[2][3]) {
                        this.f154J = 0;
                        this.f153I = 0;
                        this.f155K = 0;
                    } else {
                        Log.i("S3HealthDnurseTest", "RB:" + i);
                        this.f155K = (byte) (this.f155K + 1);
                        this.f154J = 0;
                        this.f153I = 0;
                        if (this.f155K >= 4) {
                            Log.i("S3HealthDnurseTest", "RB S");
                            this.f159O = true;
                            DnurseDeviceTest.this.f115n = 2;
                        }
                    }
                    if (this.f159O) {
                        this.f152H = 0;
                    }
                } else if (i >= DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][0] && i <= DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][1]) {
                    this.f152H = (byte) (this.f152H + 1);
                } else if (i <= DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][1] || i > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][2] || this.f152H < 1 || this.f152H > 5) {
                    this.f152H = 0;
                    if (i < DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][0] || i > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][3]) {
                        this.f154J = 0;
                        this.f153I = 0;
                        this.f155K = 0;
                        this.f159O = false;
                    }
                } else {
                    Log.i("S3HealthDnurseTest", "RS:" + i);
                    this.f160P = true;
                    this.f152H = 0;
                    this.f158N = 0;
                    this.f157M = 0;
                }
            }

            /* renamed from: b */
            private void m113b() {
                int i = 1;
                while (i < this.f156L && this.f151G[i] != -1) {
                    i++;
                }
                int i2 = 0;
                while (true) {
                    int i3 = i;
                    int i4 = i2;
                    if (i3 < this.f156L) {
                        i2 = i4 + 1;
                        this.f151G[i4] = this.f151G[i3];
                        i = i3 + 1;
                    } else {
                        this.f156L = (byte) i4;
                        return;
                    }
                }
            }

            /* renamed from: b */
            private void m114b(int i) {
                for (int i2 = 0; i2 < i; i2 += 2) {
                    short s = (short) ((this.f167b[i2] + this.f167b[i2 + 1]) / 2);
                    C0602d.this.f144e = (short) (C0602d.this.f144e | s);
                    this.f168c[i2] = (byte) (s & 255);
                    this.f168c[i2 + 1] = (byte) (s >> 8);
                    if (DnurseDeviceTest.this.f124w && s >= -2000) {
                        s = (short) (s - 2000);
                    } else if (DnurseDeviceTest.this.f125x && s <= 2000) {
                        s = (short) (s + 2000);
                    }
                    int a = m110a(!DnurseDeviceTest.this.f82B ? (short) (s / -4) : (short) (s / 4));
                    if (a != 0) {
                        m112a(a);
                    }
                }
            }

            /* renamed from: c */
            private void m115c() {
                this.f156L = 0;
            }

            /* renamed from: d */
            private void m116d() {
                this.f160P = false;
                this.f152H = 0;
            }

            /* renamed from: e */
            /*
            private void m117e() {
                boolean z;
                int i;
                boolean z2;
                int i2 = 0;
                int i3 = 0;
                int i4;
                if (DnurseDeviceTest.this.f81A == 0) {
                    int i5 = DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][0];
                    int i6 = DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][2];
                    for (int i7 = 0; i7 < 9; i7++) {
                        if (this.f161Q[i7] > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][1]) {
                            if (this.f161Q[i7] < i6) {
                                i6 = this.f161Q[i7];
                            }
                        } else if (this.f161Q[i7] > i5) {
                            i5 = this.f161Q[i7];
                        }
                    }
                    if (i6 - i5 < this.f170e / 4) {
                        this.f170e = (byte) (this.f170e - 1);
                        Log.i("S3HealthDnurseTest", "RECV Diff: changed to " + this.f170e);
                        return;
                    }
                }
                byte[] bArr = this.f151G;
                byte b = this.f156L;
                this.f156L = (byte) (b + 1);
                bArr[b] = (byte) (this.f158N & 255);
                if (this.f156L == 4) {
                    int i8 = 0;
                    while (i8 < 4 && this.f151G[i8] == this.f171f[i8]) {
                        i8++;
                    }
                    if (i8 == 4) {
                        Log.i("S3HealthDnurseTest", "R: Wave HIGH first");
                        if (DnurseDeviceTest.this.f81A == 0) {
                            DnurseDeviceTest.this.f82B = true;
                            i = 0;
                            z2 = true;
                        } else {
                            i = 0;
                            z2 = true;
                        }
                    } else {
                        i = 0;
                        while (i < 4 && this.f151G[i] == this.f172g[i]) {
                            i++;
                        }
                        z2 = false;
                    }
                    if (i2 == 4) {
                        Log.i("S3HealthDnurseTest", "R: Wave HIGH(2) first");
                        if (DnurseDeviceTest.this.f81A == 0) {
                            DnurseDeviceTest.this.f82B = true;
                            i2 = 0;
                            z2 = true;
                        } else {
                            i2 = 0;
                            z2 = true;
                        }
                    } else if (DnurseDeviceTest.this.f81A == 0) {
                        i2 = 0;
                        while (i2 < 4 && this.f151G[i2] == this.f173h[i2]) {
                            i2++;
                        }
                    }
                    if (i3 == 4) {
                        Log.i("S3HealthDnurseTest", "R: Wave LOW first");
                        DnurseDeviceTest.this.f82B = false;
                        i4 = 0;
                        z = true;
                    } else {
                        if (DnurseDeviceTest.this.f81A == 0) {
                            i3 = 0;
                            while (i3 < 4 && this.f151G[i3] == this.f174i[i3]) {
                                i3++;
                            }
                        }
                        int i9 = i3;
                        z = z2;
                        i4 = i9;
                    }
                    if (i4 == 4) {
                        Log.i("S3HealthDnurseTest", "R: Wave LOW(2) first");
                        DnurseDeviceTest.this.f82B = false;
                        z = true;
                    }
                    if (!z) {
                        m111a();
                    }
                } else {
                    z = false;
                }
                if (z) {
                    DnurseDeviceTest.this.m52b(2);
                    m115c();
                }
            }

            */
            private void m117e() {
                block24 : {
                    boolean bl;
                    boolean bl2;
                    int n;
                    int n2;
                    int n3;
                    block23 : {
                        if (DnurseDeviceTest.this.f81A != 0) break block23;
                        int n4 = DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][0];
                        int n5 = DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][2];
                        for (int i = 0; i < 9; ++i) {
                            if (this.f161Q[i] > DnurseDeviceTest.this.f114m[DnurseDeviceTest.this.f115n][1]) {
                                if (this.f161Q[i] >= n5) continue;
                                n5 = this.f161Q[i];
                                continue;
                            }
                            if (this.f161Q[i] <= n4) continue;
                            n4 = this.f161Q[i];
                        }
                        if (n5 - n4 < this.f170e / 4) break block24;
                    }
                    byte[] arrby = this.f151G;
                    byte by = this.f156L;
                    this.f156L = (byte)(by + 1);
                    arrby[by] = (byte)(255 & this.f158N);
                    if (this.f156L != 4) return;
                    for (n = 0; n < 4 && this.f151G[n] == this.f171f[n]; ++n) {
                    }
                    if (n == 4) {
                        Log.i((String)"S3HealthDnurseTest", (String)"R: Wave HIGH first");
                        if (DnurseDeviceTest.this.f81A == 0) {
                            DnurseDeviceTest.this.f82B = true;
                            n2 = 0;
                            bl = true;
                        } else {
                            bl = true;
                            n2 = 0;
                        }
                    } else {
                        for (n2 = 0; n2 < 4 && this.f151G[n2] == this.f172g[n2]; ++n2) {
                        }
                        bl = false;
                    }
                    if (n2 == 4) {
                        Log.i((String)"S3HealthDnurseTest", (String)"R: Wave HIGH(2) first");
                        if (DnurseDeviceTest.this.f81A == 0) {
                            DnurseDeviceTest.this.f82B = true;
                            n2 = 0;
                            bl = true;
                        } else {
                            bl = true;
                            n2 = 0;
                        }
                    } else if (DnurseDeviceTest.this.f81A == 0) {
                        for (n2 = 0; n2 < 4 && this.f151G[n2] == this.f173h[n2]; ++n2) {
                        }
                    }
                    if (n2 == 4) {
                        Log.i((String)"S3HealthDnurseTest", (String)"R: Wave LOW first");
                        DnurseDeviceTest.this.f82B = false;
                        n3 = 0;
                        bl2 = true;
                    } else {
                        if (DnurseDeviceTest.this.f81A == 0) {
                            for (n2 = 0; n2 < 4 && this.f151G[n2] == this.f174i[n2]; ++n2) {
                            }
                        }
                        int n6 = n2;
                        bl2 = bl;
                        n3 = n6;
                    }
                    if (n3 == 4) {
                        Log.i((String)"S3HealthDnurseTest", (String)"R: Wave LOW(2) first");
                        DnurseDeviceTest.this.f82B = false;
                        bl2 = true;
                    }
                    if (!bl2) {
                        this.m111a();
                    }
                    if (!bl2) return;
                    DnurseDeviceTest.this.m52b(2);
                    this.m115c();
                    return;
                }
                this.f170e = (byte)(-1 + this.f170e);
                Log.i((String)"S3HealthDnurseTest", (String)("RECV Diff: changed to " + this.f170e));
            }
            /* renamed from: f */
            private void m118f() {
                byte b = 0;
                byte b2 = 0;
                if (this.f156L != 0) {
                    Log.i("S3HealthDnurseTest", "F:" + this.f156L);
                    byte[] bArr = this.f151G;
                    byte b3 = this.f156L;
                    this.f156L = (byte) (b3 + 1);
                    bArr[b3] = (byte) (this.f158N & 255);
                    if (this.f156L == 8 && this.f158N < 255 && this.f158N > 8) {
                        this.f150F = (byte) (this.f158N & 255);
                    }
                    if (this.f156L < this.f150F) {
                        return;
                    }
                    if (((byte) this.f158N) != -1) {
                        m113b();
                        return;
                    }
                    for (int i = 0; i < this.f150F; i++) {
                        b2 = (byte) (b ^ this.f151G[i]);
                    }
                    if (b != 0) {
                        Log.i("S3HealthDnurseTest", "F XOR ERR! CRC=" + b);
                        m113b();
                    } else if (DnurseDeviceTest.this.f88H || this.f151G[2] == 0 || this.f151G[2] == 16) {
                        if ((DnurseDeviceTest.this.f88H && DnurseDeviceTest.this.f83C != -1) || (!DnurseDeviceTest.this.f88H && this.f151G[4] != -1)) {
                            b = (byte) (this.f151G[1] + this.f151G[2]);
                            for (int i2 = 4; i2 < this.f150F - 1; i2++) {
                                b = (byte) (b + this.f151G[i2]);
                            }
                        }
                        if (b != 0) {
                            Log.i("S3HealthDnurseTest", "F SUM ERR! CRC=" + b);
                            m113b();
                            return;
                        }
                        switch (this.f151G[2]) {
                            case 0:
                                if (this.f150F != 8) {
                                    DnurseDeviceTest.this.f83C = this.f151G[4];
                                    Log.i("S3HealthDnurseTest", "F: dev ver=" + DnurseDeviceTest.this.f83C);
                                    DnurseDeviceTest.this.f84D = this.f151G[5];
                                    Log.i("S3HealthDnurseTest", "F: Protocol ver=" + DnurseDeviceTest.this.f84D);
                                    DnurseDeviceTest.this.f99T = ((float) (((short) (this.f151G[8] & (byte) 0xFF)) + 100)) / 100.0f;
                                    Log.i("S3HealthDnurseTest", "F: V=" + DnurseDeviceTest.this.f99T);
                                    DnurseDeviceTest.this.f100U = ((float) ((short) (((short) ((this.f151G[6] & 1) << 8)) | (this.f151G[9] & (byte) 0xFF)))) / 10.0f;
                                    Log.i("S3HealthDnurseTest", "F: T=" + DnurseDeviceTest.this.f100U);
                                    DnurseDeviceTest.this.f85E = (this.f151G[10] & (byte) 0xFF) | ((this.f151G[11] & (byte) 0xFF) << 8) | ((this.f151G[12] & (byte) 0xFF) << 16);
                                    Log.i("S3HealthDnurseTest", "F: swVer=" + DnurseDeviceTest.this.f85E);
                                    char[] charArray = "0123456789ABCDEF".toCharArray();
                                    StringBuilder sb = new StringBuilder("");
                                    for (int i3 = 0; i3 < 10; i3++) {
                                        sb.append(charArray[(this.f151G[22 - i3] & 240) >> 4]);
                                        sb.append(charArray[this.f151G[22 - i3] & 15]);
                                    }
                                    DnurseDeviceTest.this.f86F = sb.toString();
                                    Log.i("S3HealthDnurseTest", "F: SN=" + DnurseDeviceTest.this.f86F);
                                    if ((this.f151G[6] & 128) == 0) {
                                        if ((this.f151G[6] & 1 << 6) == 0) {
                                            if (DnurseDeviceTest.this.f112k == 2) {
                                                DnurseDeviceTest.this.m52b(3);
                                                break;
                                            }
                                        } else {
                                            DnurseDeviceTest.this.m52b(11);
                                            break;
                                        }
                                    } else {
                                        DnurseDeviceTest.this.m52b(10);
                                        break;
                                    }
                                } else {
                                    if ((this.f151G[6] & 32) != 0) {
                                        short s = (short) (this.f151G[4] & (byte) 0xFF);
                                        if (s > 0) {
                                            DnurseDeviceTest.this.f99T = ((float) (s + 100)) / 100.0f;
                                            Log.i("S3HealthDnurseTest", "F: V=" + DnurseDeviceTest.this.f99T);
                                        }
                                    } else if (!DnurseDeviceTest.this.f88H && this.f151G[4] != -1) {
                                        DnurseDeviceTest.this.f83C = this.f151G[4];
                                        Log.i("S3HealthDnurseTest", "F: dev ver=" + DnurseDeviceTest.this.f83C);
                                    }
                                    if ((this.f151G[6] & 16) != 0) {
                                        short s2 = (short) (((((short) this.f151G[6]) << 8) & 768) | (((short) this.f151G[5]) & 255));
                                        if (s2 > 0) {
                                            DnurseDeviceTest.this.f100U = ((float) (s2 - 1)) / 10.0f;
                                            Log.i("S3HealthDnurseTest", "F: T=" + DnurseDeviceTest.this.f100U);
                                        }
                                    } else if (!DnurseDeviceTest.this.f88H && this.f151G[4] != -1) {
                                        DnurseDeviceTest.this.f84D = this.f151G[5];
                                        Log.i("S3HealthDnurseTest", "F: Protocol ver=" + DnurseDeviceTest.this.f84D);
                                    }
                                    if ((this.f151G[6] & 128) == 0) {
                                        if ((this.f151G[6] & 1 << 6) == 0) {
                                            if (DnurseDeviceTest.this.f112k == 2) {
                                                DnurseDeviceTest.this.m52b(3);
                                                break;
                                            }
                                        } else {
                                            DnurseDeviceTest.this.m52b(11);
                                            break;
                                        }
                                    } else {
                                        DnurseDeviceTest.this.m52b(10);
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                DnurseDeviceTest.this.f113l = ((float) (((short) ((((short) this.f151G[5]) << 8) | (((short) this.f151G[4]) & 255))) & Short.MAX_VALUE)) / 10.0f;
                                Log.i("S3HealthDnurseTest", "F: Glucose=" + DnurseDeviceTest.this.f113l);
                                DnurseDeviceTest.this.f91K = this.f151G[6];
                                DnurseDeviceTest.this.m52b(8);
                                break;
                            case 2:
                                if (this.f151G[4] != 0) {
                                    DnurseDeviceTest.this.m52b(5);
                                    break;
                                } else {
                                    short s3 = (short) (this.f151G[5] & (byte) 0xFF);
                                    if (DnurseDeviceTest.this.f83C != 255) {
                                        DnurseDeviceTest.this.f99T = ((float) (s3 + 100)) / 100.0f;
                                        Log.i("S3HealthDnurseTest", "Frame: Voltage=" + DnurseDeviceTest.this.f99T);
                                        DnurseDeviceTest.this.f100U = ((float) (((short) (this.f151G[6] & (byte) 0xFF)) * 2)) / 10.0f;
                                        Log.i("S3HealthDnurseTest", "F: T=" + DnurseDeviceTest.this.f100U);
                                    }
                                    DnurseDeviceTest.this.m52b(4);
                                    break;
                                }
                            case 3:
                                DnurseDeviceTest.this.m52b(7);
                                break;
                            case 4:
                                DnurseDeviceTest.this.m52b(6);
                                break;
                            case 6:
                                if (this.f151G[4] != 0) {
                                    if (this.f151G[4] != 1) {
                                        if (this.f151G[4] != 2) {
                                            if (this.f151G[4] == 3) {
                                                if (((short) ((((short) this.f151G[6]) << 8) | (((short) this.f151G[5]) & 255))) != 0) {
                                                    DnurseDeviceTest.this.m52b(13);
                                                    break;
                                                } else {
                                                    DnurseDeviceTest.this.m52b(12);
                                                    break;
                                                }
                                            }
                                        } else {
                                            DnurseDeviceTest.this.m52b(10);
                                            break;
                                        }
                                    } else {
                                        DnurseDeviceTest.this.m52b(9);
                                        break;
                                    }
                                }
                                break;
                            case 7:
                                byte b4 = (byte)((this.f151G[4] & (byte) 0xFF) | ((this.f151G[5] & (byte) 0xFF) << 8) | ((this.f151G[6] & (byte) 0xFF) << 16));
                                DnurseDeviceTest.this.f86F = String.format("%07d", new Object[]{Integer.valueOf(b4)});
                                Log.i("S3HealthDnurseTest", "F: SN=" + DnurseDeviceTest.this.f86F);
                                break;
                            case 8:
                                DnurseDeviceTest.this.f85E = (this.f151G[4] & (byte) 0xFF) | ((this.f151G[5] & (byte) 0xFF) << 8) | ((this.f151G[6] & (byte) 0xFF) << 16);
                                Log.i("S3HealthDnurseTest", "F: swVer=" + DnurseDeviceTest.this.f85E);
                                break;
                        }
                        m115c();
                    } else {
                        Log.i("S3HealthDnurseTest", "F sequence ERR!");
                        m115c();
                    }
                } else if (((byte) this.f158N) == -1) {
                    Log.i("S3HealthDnurseTest", "F: S");
                    byte[] bArr2 = this.f151G;
                    byte b5 = this.f156L;
                    this.f156L = (byte) (b5 + 1);
                    bArr2[b5] = (byte) this.f158N;
                    this.f150F = 8;
                }
            }

            public void run() {
                Log.d("S3HealthDnurseTest", "AudRec: thread started!");
                if (!(C0602d.this.f142c == null || C0602d.this.f142c.getRecordingState() == 3)) {
                    Log.i("S3HealthDnurseTest", "AudRec: can't record, released");
                    C0602d.this.f142c.release();
                    C0602d.this.f142c = null;
                    DnurseDeviceTest.this.m52b(15);
                }
                while (C0602d.this.f142c != null && C0602d.this.f142c.getRecordingState() == 3) {
                    int read = C0602d.this.f142c.read(this.f167b, 0, this.f169d);
                    if (-3 != read) {
                        m114b(read);
                    }
                }
                if (C0602d.this.f142c != null) {
                    Log.i("S3HealthDnurseTest", "AudRec: released");
                    C0602d.this.f142c.release();
                    C0602d.this.f142c = null;
                }
            }
        }

        public C0602d() {
            int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
            Log.i("S3HealthDnurseTest", "AudRec: min buffer=" + minBufferSize);
            if (minBufferSize < 0) {
                Log.i("S3HealthDnurseTest", "AudRec: Error to get min buffer!");
                this.f143d = 0;
                return;
            }
            this.f143d = 16384;
            if (this.f143d < minBufferSize) {
                this.f143d = ((minBufferSize * 8) + 7) / 8;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m106d() {
            if (this.f142c != null && this.f142c.getRecordingState() == 3) {
                Log.i("S3HealthDnurseTest", "AudRec: stopped");
                this.f142c.stop();
            }
        }

        /* renamed from: a */
        public Boolean mo10834a() {
            return Boolean.valueOf(this.f142c == null);
        }

        /* renamed from: b */
        public boolean mo10835b() {
            return this.f144e == 0;
        }

        /* renamed from: c */
        public Boolean mo10836c() {
            if (this.f143d <= 0) {
                return Boolean.valueOf(false);
            }
            this.f142c = new AudioRecord(1, 44100, 16, 2, this.f143d);
            if (this.f142c == null || this.f142c.getState() != 1) {
                Log.i("S3HealthDnurseTest", "AudRec: Create failed!");
                if (this.f142c != null) {
                    Log.i("S3HealthDnurseTest", "AudRec: released");
                    this.f142c.release();
                    this.f142c = null;
                }
                return Boolean.valueOf(false);
            }
            this.f142c.startRecording();
            new Thread(new C0603a(this.f143d / 2)).start();
            Log.i("S3HealthDnurseTest", "AudRec: Recording started!");
            return Boolean.valueOf(true);
        }
    }

    public DnurseDeviceTest(Context context) {
        this.f94N = context;
        if (Build.MODEL.equalsIgnoreCase("K-Touch T91") || Build.MODEL.equalsIgnoreCase("K-Touch C980t") || Build.MODEL.equalsIgnoreCase("K-Touch T789") || Build.MODEL.equalsIgnoreCase("K-Touch S5t") || Build.MODEL.equalsIgnoreCase("Lenovo A658t") || Build.MODEL.equalsIgnoreCase("Lenovo S868t") || Build.MODEL.equalsIgnoreCase("8295") || Build.MODEL.equalsIgnoreCase("ZTE U930HD") || Build.MODEL.equalsIgnoreCase("HUAWEI G606-T00") || Build.MODEL.equalsIgnoreCase("K-Touch T6")) {
            this.f124w = true;
        } else if (Build.MODEL.equalsIgnoreCase("8085") || Build.MODEL.equalsIgnoreCase("8085N") || Build.MODEL.equalsIgnoreCase("8190") || Build.MODEL.equalsIgnoreCase("8720")) {
            this.f117p = 200;
            this.f124w = true;
        } else if (Build.MODEL.equalsIgnoreCase("Coolpad 8703")) {
            this.f118q = 800;
        } else if (Build.MODEL.equalsIgnoreCase("Lenovo A330t")) {
            this.f118q = 500;
            this.f120s = 3000;
        } else if (Build.MODEL.equalsIgnoreCase("GT-I9200") || Build.MODEL.equalsIgnoreCase("SM-G3508I")) {
            this.f122u = 300;
        } else if (Build.MODEL.equalsIgnoreCase("MX4 Pro")) {
            this.f122u = 500;
            this.f120s = 2000;
        } else if (Build.MODEL.equalsIgnoreCase("R801")) {
            this.f118q = 50;
        } else if (Build.MODEL.equalsIgnoreCase("HTC One X") || Build.MODEL.equalsIgnoreCase("HUAWEI U8825-1")) {
            this.f117p = 200;
        } else if (Build.MODEL.equalsIgnoreCase("8150")) {
            this.f126y = false;
        } else if (Build.MODEL.equalsIgnoreCase("C1505")) {
            this.f123v = 1800;
        } else if (Build.MODEL.equalsIgnoreCase("GT-I9103")) {
            this.f123v = 200;
        } else if (Build.MODEL.equalsIgnoreCase("M040")) {
            this.f114m[0][6] = 0;
            this.f114m[1][6] = 0;
        } else if (Build.MODEL.startsWith("HTC T528") || Build.MODEL.equalsIgnoreCase("Coolpad8750")) {
            this.f116o = 1;
        } else if (Build.MODEL.equalsIgnoreCase("SCH-P709")) {
            this.f116o = 2;
            this.f81A = 1;
        } else if (Build.MODEL.equalsIgnoreCase("GT-S6352") || Build.MODEL.equalsIgnoreCase("GT-I9070")) {
            this.f121t = 500;
        } else if (Build.MODEL.equalsIgnoreCase("N5207")) {
            this.f121t = 1500;
            this.f127z = false;
        } else if (Build.MODEL.equalsIgnoreCase("8195") || Build.MODEL.equalsIgnoreCase("8150D")) {
            this.f122u = 300;
            this.f124w = true;
        } else if (Build.MODEL.endsWith("Lenovo A780e") || Build.MODEL.endsWith("Lenovo A385e") || Build.MODEL.endsWith("HTC T320e")) {
            this.f121t = 100;
        } else if (Build.MODEL.equalsIgnoreCase("ST25i") || Build.MODEL.equalsIgnoreCase("LT22i") || Build.MODEL.equalsIgnoreCase("HTC T329t")) {
            this.f81A = 1;
        }
    }

    public static String MD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (str == null || "".equals(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = (byte)(b & ((byte) 0xFF));
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private void m40a() {
        Date date = new Date(System.currentTimeMillis() + 1000);
        this.f89I = 10;
        this.f96P.removeCallbacks(this.f105d);
        if (this.f97Q != null) {
            this.f97Q.cancel();
            this.f97Q.purge();
        }
        this.f97Q = new Timer(true);
        this.f97Q.scheduleAtFixedRate(new C0609f(this), date, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41a(int i) {
        this.f96P.removeCallbacks(this.f105d);
        if (this.f97Q != null) {
            this.f97Q.cancel();
        }
        this.f96P.postDelayed(this.f105d, (long) i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44a(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.f94N.openFileOutput(str, 0);
            fileOutputStream.write("1".getBytes());
            fileOutputStream.flush();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m51b() {
        m52b(1);
        if (!this.f93M.mo10820a()) {
            Log.i("S3HealthDnurseTest", "AudPly: start failed!");
            m52b(14);
        } else if (!this.f92L.mo10836c().booleanValue()) {
            Log.i("S3HealthDnurseTest", "AudRec: start failed!");
            m52b(15);
        } else {
            m41a(this.f120s);
            this.f96P.postDelayed(this.f104c, (long) this.f122u);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m52b(int i) {
        if (i != this.f112k) {
            Log.i("S3HealthDnurseTest", "notifyChange,state=" + i);
            switch (i) {
                case 0:
                    this.f83C = -1;
                    this.f84D = -1;
                    this.f85E = 0;
                    this.f86F = "";
                    break;
                case 2:
                    if (this.f112k == 1) {
                        if (this.f115n <= 1) {
                            this.f93M.mo10819a(true);
                        } else {
                            this.f93M.mo10819a(false);
                        }
                        m41a(this.f120s);
                        this.f90J = -1;
                        break;
                    } else {
                        return;
                    }
                case 3:
                    this.f88H = true;
                    break;
                case 4:
                case 5:
                case 6:
                    break;
                case 7:
                    m40a();
                    break;
                case 8:
                    m41a(195000);
                    this.f93M.mo10823d();
                    if (this.f83C == -1 || this.f90J != this.f91K) {
                        this.f90J = this.f91K;
                        m62d();
                        Calendar instance = Calendar.getInstance();
                        SparseArray sparseArray = new SparseArray();
                        sparseArray.put(1, Float.valueOf(this.f113l));
                        sparseArray.put(2, instance);
                        sparseArray.put(3, this.f86F);
                        this.f95O.onSuccess(sparseArray);
                        break;
                    } else {
                        return;
                    }
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    m58c();
                    break;
            }
            m41a(195000);
            this.f112k = i;
            if (this.f112k == 7) {
                this.f95O.onMeasuring(this.f112k, this.f89I);
            } else {
                this.f95O.onMeasuring(this.f112k, 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m58c() {
        this.f96P.removeCallbacks(this.f102a);
        this.f96P.removeCallbacks(this.f104c);
        this.f96P.removeCallbacks(this.f105d);
        if (this.f93M != null) {
            this.f93M.mo10824e();
        }
        if (this.f87G && this.f93M != null) {
            this.f93M.mo10821b();
        }
        if (this.f92L != null) {
            this.f92L.m106d();
        }
        this.f88H = false;
    }

    /* renamed from: d */
    private void m62d() {
        String format = String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(this.f113l)});
        String format2 = String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(this.f99T)});
        String format3 = String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(this.f100U)});
        new C0600b(this, null).execute(new String[]{this.f86F, format, String.valueOf(System.currentTimeMillis() / 1000), newIdWithTag("C"), format2, format3, String.valueOf(this.f83C), String.valueOf(this.f85E)});
    }

    /* renamed from: e */
    private static SimpleDateFormat m64e() {
        if (f80S == null) {
            synchronized (DnurseDeviceTest.class) {
                if (f80S == null) {
                    f80S = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                }
            }
        }
        return f80S;
    }

    public static String newIdWithTag(String str) {
        String format = m64e().format(Calendar.getInstance().getTime());
        String format2 = String.format(Locale.US, "%06d", new Object[]{Integer.valueOf(new Random().nextInt(1000000))});
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        sb.append(format);
        sb.append(format2);
        return sb.toString();
    }

    public void startTest(IMeasureDataResultCallback iMeasureDataResultCallback) {
        this.f95O = iMeasureDataResultCallback;
        if (this.f93M == null) {
            this.f93M = new C0599a();
        }
        if (this.f92L == null) {
            this.f92L = new C0602d();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.f94N.registerReceiver(this.f101V, intentFilter);
        this.f95O.onMeasuring(this.f112k, 0);
    }

    public void stopTest() {
        try {
            this.f94N.unregisterReceiver(this.f101V);
        } catch (IllegalArgumentException e) {
        }
        m58c();
        if (this.f93M != null) {
            this.f93M.mo10824e();
            this.f93M = null;
        }
    }

    public void wakeupDevice() {
        if (this.f87G && !DnurseConstant.isWorking(this.f112k)) {
            this.f96P.postDelayed(this.f102a, (long) this.f121t);
        }
    }
}
