package com.qinshou.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.qinshou.myapplication.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import model.User;
import presenter.UserLoginPresenter;

/**
 * Activity 其实就是View层，需要实现View层定义的接口ILoginView
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {


    @InjectView(R.id.etUserName)
    EditText mEtUserName;
    @InjectView(R.id.etPwd)
    EditText mEtPwd;
    @InjectView(R.id.pbLoading)
    ProgressBar mPbLoading;
    @InjectView(R.id.btnLogin)
    Button btnLogin;
    @InjectView(R.id.btnClear)
    Button btnClear;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.btnLogin, R.id.btnClear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                mUserLoginPresenter.login();

                break;
            case R.id.btnClear:
                mUserLoginPresenter.clear();
                break;
        }
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUserName.setText("");
    }

    @Override
    public void clearPwd() {
        mEtPwd.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void jumpToMainActivity(User user) {
        Toast.makeText(LoginActivity.this, user.getName() + "login success,jump to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(LoginActivity.this, "failed!", Toast.LENGTH_SHORT).show();
    }
}
