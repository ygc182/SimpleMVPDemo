import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Description:
 * Created on 2017/6/23
 */

public class MyApp extends Application {
    public static Context sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        SpeechUtility.createUtility(sApp, SpeechConstant.APPID + "=594cdef3");
    }
}
