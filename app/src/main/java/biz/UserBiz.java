package biz;

import model.User;

/**
 * Description:
 * Created on 2017/6/15
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String pwd, final OnLoginListener onLoginListener) {
        // 模拟登录耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("ygc".equals(userName) && "123".equals(pwd)) {
                    User user = new User();
                    user.setName(userName);
                    user.setPwd(pwd);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFiled();
                }
            }
        }.start();


    }
}
