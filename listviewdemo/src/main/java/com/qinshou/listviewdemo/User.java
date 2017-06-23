package com.qinshou.listviewdemo;

/**
 * Description:
 * Created on 2017/6/20
 */
public class User {
    public String name;
    public String number;
    public String date;
    public int res;

    public User(String name, String number, String date, int res) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.res = res;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", date='" + date + '\'' +
                ", res=" + res +
                '}';
    }
}
