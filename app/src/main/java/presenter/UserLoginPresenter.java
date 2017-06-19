package presenter;

import android.os.Handler;

import com.qinshou.myapplication.view.ILoginView;

import biz.IUserBiz;
import biz.OnLoginListener;
import biz.UserBiz;
import model.User;

/**
 * Description:
 *  Presenter是用作Model和View之间交互的桥梁
 *      那么应该有什么方法呢？
        其实也是主要看该功能有什么操作，比如本例，两个操作:login和clear。
 * Created on 2017/6/15
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private ILoginView loginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.userBiz = new UserBiz();
    }

    /**
     *  P层 方法
     */
    public void login(){
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPwd(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.jumpToMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFiled() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        loginView.clearUserName();
        loginView.clearPwd();

    }
}
