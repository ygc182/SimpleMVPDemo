package com.qinshou.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private ArrayList<User> datas;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initData();
        initListener();
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
    }

    private void initData() {
        if (datas == null) {
            datas = new ArrayList<>();
        } else {
            datas.clear();
        }
        datas.add(new User("张三", "110", "2017/06/13", R.mipmap.ic_launcher));
        datas.add(new User("ad", "9634654", "2017/06/13", R.mipmap.ic_launcher));
        datas.add(new User("fdf", "333", "2017/06/13", R.mipmap.ic_launcher));
        datas.add(new User("cxv", "44445555", "2017/06/13", R.mipmap.ic_launcher));
        datas.add(new User("dfwe", "765786", "2017/06/13", R.mipmap.ic_launcher));
        datas.add(new User("8878", "4444", "2017/06/13", R.mipmap.ic_launcher));

        mUserAdapter = new UserAdapter(this,datas);
        mLv.setAdapter(mUserAdapter);


    }

    private void initListener() {
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "you click : " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
