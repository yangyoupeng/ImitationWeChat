package com.yyp.imitatewechat;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyoupeng on 2017/3/6.
 */

public class MyAppliction extends Application {

    public final static String TAG = "BaseApplication";
    public final static boolean DEBUG = true;

    private static MyAppliction myAppliction;

    private static int mainTid;

    private static List< BaseActivity > activities;

    public MyAppliction() {

    }

    public static Application getContext() {
        return myAppliction;
    }

    @Override
    public void onCreate() {
        super.onCreate ();
        myAppliction = this;
        mainTid = android.os.Process.myTid ();
        activities = new ArrayList<> ();
    }

    /**
     * 获取application
     *
     * @return
     */

    public static Context getAppliction() {
        return myAppliction;
    }

    /**
     * 获取主线程ID
     *
     * @return
     */
    public static int getMainTid() {
        return mainTid;
    }

    /**
     * 添加一个Activity
     *
     * @param activity
     */
    public void addActivity(BaseActivity activity) {
        if (activity != null) {
            activities.add (activity);
        }
    }

    /**
     * 删除一个activity
     */
    public void removeActivity(BaseActivity activity) {
        activities.remove (activity);
    }

    /**
     * 删除所有activity
     */
    public void removeAllActivity() {

        for (BaseActivity baseActivity : activities) {
            baseActivity.finish ();
        }
    }
}
