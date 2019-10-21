package com.example.hp.sensor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;

import com.dnurse.exttestlib.DnurseDeviceTest;
import com.dnurse.exttestlib.IMeasureDataResultCallback;

import java.util.Calendar;

public class AuxReceiver extends BroadcastReceiver {
    private Context mContext;
    public static DnurseDeviceTest m_deviceTest;

    /* access modifiers changed from: private */
    public String mDeviceSN;
    /* access modifiers changed from: private */
    public int mDnurseState = 0;
    private int mHeadsetState;
    private int mMicrophoneState;
    /* access modifiers changed from: private */
    public float mTestResult;
    /* access modifiers changed from: private */
    public Calendar mTime;
    /* access modifiers changed from: private */
    public int m_arg0;
    /* access modifiers changed from: private */
    public int m_arg1;
    private boolean state = true;

    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    IMeasureDataResultCallback iMeasureDataResultCallback = new IMeasureDataResultCallback() {
        public void onSuccess(SparseArray arg0) {
            AuxReceiver.this.mTestResult = ((Float) arg0.get(1)).floatValue();
            AuxReceiver.this.mTime = (Calendar) arg0.get(2);
            AuxReceiver.this.mDeviceSN = (String) arg0.get(3);
        }

        public void onMeasuring(int arg0, int arg1) {
            AuxReceiver.this.m_arg0 = arg0;
            AuxReceiver.this.m_arg1 = arg1;
            AuxReceiver.this.handler.post(AuxReceiver.this.usRunnable);
        }
    };

    Runnable usRunnable = new Runnable() {
        public void run() {
            try {
                AuxReceiver.this.mDnurseState = AuxReceiver.this.m_arg0;
                if (AuxReceiver.this.mDnurseState == 0 || AuxReceiver.this.mDnurseState == 1 || AuxReceiver.this.mDnurseState == 2 || AuxReceiver.this.mDnurseState == 3 || AuxReceiver.this.mDnurseState == 4 || AuxReceiver.this.mDnurseState == 5 || AuxReceiver.this.mDnurseState == 6 || AuxReceiver.this.mDnurseState == 7 || AuxReceiver.this.mDnurseState != 8) {
                }
                Log.d("App", "Arg0" + AuxReceiver.this.m_arg0);
                switch (AuxReceiver.this.m_arg0) {
                    case 0:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 2:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 3:
                        try {
                            Intent inGluco = new Intent(AuxReceiver.this.mContext, GlucometerActivity.class);
                            inGluco.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            inGluco.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            AuxReceiver.this.mContext.startActivity(inGluco);
                            MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    case 4:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 5:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 6:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 7:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 8:
                        try {
                            MyObservable.getInstance().updateValue(Float.valueOf(AuxReceiver.this.mTestResult));
                            Intent intent = new Intent(mContext,DataActivity.class);
                            intent.putExtra("glucose",String.valueOf(Float.valueOf(AuxReceiver.this.mTestResult)));
                            mContext.startActivity(intent);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    case 9:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        if (m_deviceTest != null) {
                            m_deviceTest.stopTest();
                            m_deviceTest = null;
                        }
                        if (m_deviceTest == null) {
                            m_deviceTest = new DnurseDeviceTest(AuxReceiver.this.mContext);
                        }
                        m_deviceTest.startTest(AuxReceiver.this.iMeasureDataResultCallback);
                        return;
                    case 10:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 11:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 12:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 13:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 14:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 15:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    case 16:
                        if (m_deviceTest != null) {
                            m_deviceTest.stopTest();
                            m_deviceTest = null;
                            return;
                        }
                        return;
                    case 17:
                        MyObservable.getInstance().updateValue(Integer.valueOf(AuxReceiver.this.m_arg0));
                        return;
                    default:
                        return;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    };



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("App", "HEADSET PLUGGED");

        Bundle extras = intent.getExtras();
        AuxReceiver.this.mContext = context;
        if (extras != null && intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
            AuxReceiver.this.mHeadsetState = intent.getIntExtra("state", 0);
            AuxReceiver.this.mMicrophoneState = intent.getIntExtra("microphone", 0);
            try {
                if (AuxReceiver.this.mHeadsetState == 1 && AuxReceiver.this.mMicrophoneState == 1) {
                    AuxReceiver.this.state = false;
                    try {
                        if (m_deviceTest == null) {
                            m_deviceTest = new DnurseDeviceTest(context);
                        }
                        m_deviceTest.startTest(AuxReceiver.this.iMeasureDataResultCallback);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
