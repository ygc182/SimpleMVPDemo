package com.qinshou.myapplication.view;

import model.User;

/**
 * Description: Presenter与View交互是通过接口，这里定义view层借口，汇总方法
 *
 *      对于View的接口，去观察功能上的操作，然后考虑：

         该操作需要什么？（getUserName, getPassword）
         该操作的结果，对应的反馈？(toMainActivity, showFailedError)
         该操作过程中对应的友好的交互？(showLoading, hideLoading)
 * Created on 2017/6/15
 */
public interface ILoginView {
    String getUserName();
    String getPwd();
    void clearUserName();
    void clearPwd();
    void showLoading();
    void hideLoading();
    void jumpToMainActivity(User user);
    void showFailedError();
}
