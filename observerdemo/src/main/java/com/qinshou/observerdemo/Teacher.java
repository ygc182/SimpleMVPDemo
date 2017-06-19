package com.qinshou.observerdemo;

import java.util.Observable;

/**
 * Description:
 * Created on 2017/6/15
 */
public class Teacher extends Observable {

    public String msg;
    public void publishMsg(String msg){
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
