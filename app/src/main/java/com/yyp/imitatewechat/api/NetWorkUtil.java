package com.yyp.imitatewechat.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yangyoupeng on 2017/3/6.
 */

public class NetWorkUtil {

    public NetWorkUtil() {

    }

    /**
     * 判断网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService (Context
                .CONNECTIVITY_SERVICE);
        //        判断当前网络是否可用
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo ();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected ();
    }

    /**
     * 检测wifi是否连接
     */
    public static boolean isWifiConncted(Context context) {

        ConnectivityManager wifiManager = (ConnectivityManager) context.getSystemService (Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = wifiManager.getActiveNetworkInfo ();
        return wifiInfo != null && wifiInfo.getType () == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 检测手机3，4g是否连接
     */
    public static boolean isPhoneWorkconncted(Context context) {
        ConnectivityManager phoneManager = (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo phoneInfo = phoneManager.getActiveNetworkInfo ();

        return phoneInfo != null && phoneInfo.getType () == ConnectivityManager.TYPE_MOBILE;
    }

}
