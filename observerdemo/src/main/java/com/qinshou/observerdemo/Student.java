package com.qinshou.observerdemo;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 * Created on 2017/6/15
 */
public class Student implements Observer {
    private static final String TAG = "ygc";

    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Teacher teacher = (Teacher) o;
        Log.d(TAG, name+"收到通知： "+teacher.msg);
    }
}
