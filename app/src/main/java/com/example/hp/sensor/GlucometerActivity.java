package com.example.hp.sensor;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.dnurse.exttestlib.DnurseDeviceTest;

import java.util.Observable;
import java.util.Observer;

public class GlucometerActivity extends Activity implements Observer{
    private DnurseDeviceTest m_deviceTest;
    private AuxReceiver auxReceiver;
    private float mTestResult;

    public static TextView status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucometer);
        status = (TextView)findViewById(R.id.status);
    }

    public void handleDnurseMessage(int m_arg0) {
        switch (m_arg0) {
            case 0:
                status.setText("Plug your device with app");
                Log.d("App", "Plug your device with app");
                break;
            case 3:
                status.setText("Insert Strip");
                Log.d("App", "Insert Strip");
                return;
            case 4:
                status.setText("Prick & put blood");
                Log.d("App", "Prick & put blood");
                return;
            case 5:
                status.setText("Used Strip");
                Log.d("App", "Used Strip");
                return;
            case 6:
                Log.d("App", "Insert Strip now..");
                return;
            case 7:
                Log.d("App", "Please wait for result");
                return;
            case 8:
                status.setText(""+Double.valueOf((double) this.mTestResult).doubleValue());
                //double mgdl = App.mmolTomgdlConvert(Double.valueOf((double) this.mTestResult).doubleValue());
                Log.d("App", "" + Double.valueOf((double) this.mTestResult).doubleValue());
                return;
            case 14:
                Log.d("App", "Oops, the communication failed with Glucometer.  Please try reinserting glucometer\nor \nfollow the troubleshooting tips as below");
                return;
            case 15:
                Log.d("App", "Oops, the communication failed with Glucometer.  Please try reinserting glucometer\nor \nfollow the troubleshooting tips as below.  ");
                return;
            case 16:
                Log.d("App", "Oops, the communication failed with Glucometer.  Please try reinserting glucometer\nor \nfollow the troubleshooting tips as below. ");
                return;
            case 17:
                Log.d("App", "Oops, the communication failed with Glucometer.  Please try reinserting glucometer\nor \nfollow the troubleshooting tips as below.  ");
                return;
            default:
                return;
        }
    }


    @Override
    public void update(Observable observable, Object data) {
        if (this != null) {
            try {
                if (data instanceof Integer) {
                    this.m_deviceTest = AuxReceiver.m_deviceTest;
                    handleDnurseMessage(((Integer) data).intValue());
                }
                if (data instanceof Float) {
                    this.mTestResult = ((Float) data).floatValue();
                    handleDnurseMessage(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
