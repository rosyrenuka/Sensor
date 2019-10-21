package com.example.hp.sensor;

import android.util.Log;

import java.util.Observable;

public class MyObservable extends Observable {
    private static MyObservable instance = new MyObservable();

    public static MyObservable getInstance() {
        return instance;
    }

    private MyObservable() {
    }

    public void updateValue(Object data_arg0) {
        synchronized (this) {
            setChanged();
            Log.d("App", "myobs" + data_arg0);
            notifyObservers(data_arg0);
        }
    }
}