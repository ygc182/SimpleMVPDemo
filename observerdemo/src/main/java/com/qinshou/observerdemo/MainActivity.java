package com.qinshou.observerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Teacher teacher = new Teacher();
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        Student s3 = new Student("s3");
        teacher.addObserver(s1);
        teacher.addObserver(s2);
        teacher.addObserver(s3);

        teacher.publishMsg("放假了！！！");
    }
}
