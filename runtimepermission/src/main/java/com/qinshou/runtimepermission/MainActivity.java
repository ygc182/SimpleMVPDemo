package com.qinshou.runtimepermission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ygc";
    @InjectView(R.id.etNumber)
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.btnDial)
    public void onViewClicked() {
        String num = etNumber.getText().toString();
        Log.d(TAG, "onViewClicked: " + num);
        if (!TextUtils.isEmpty(num)) {
            Intent intent = new Intent();
//           android.intent.action.CALL
            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + num));
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "onViewClicked: Have permission");
            } else {
                Log.d(TAG, "onViewClicked: No permission");
                return;
            }

            startActivity(intent);
        }
    }
}
