package com.android.kotlin_test1;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.android.kotlin_test1.test2.db.AppDatabase;
import com.android.kotlin_test1.test2.db.bean.Person;
import com.android.kotlin_test1.util.Loge;

public class MyAPP extends Application {
    private static MyAPP application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ARouter.init(this);
        // Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    public static MyAPP getApplication() {
        return application;
    }

    private Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            restartApp(); //发生崩溃异常时,重启应用
        }
    };

    private void restartApp() {
        Loge.e("重启了");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent restartIntent = PendingIntent.getActivity(
                application.getApplicationContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        //退出程序
        AlarmManager mgr = (AlarmManager) application.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000,
                restartIntent); // 1秒钟后重启应用
        //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
