package biz;

/**
 * Description: 登录功能接口
 * Created on 2017/6/15
 */
public interface IUserBiz {
    void login(String userName, String pwd, OnLoginListener onLoginListener);
}
