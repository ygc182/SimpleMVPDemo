package biz;

import model.User;

/**
 * Description: 登录结果监听
 * Created on 2017/6/15
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFiled();
}
