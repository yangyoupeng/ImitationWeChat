package com.yyp.imitatewechat.model;

import com.yyp.imitatewechat.BuildConfig;

import okhttp3.OkHttpClient;

/**
 * Created by yangyoupeng on 2017/3/14.
 */

public class RetrofitHelper {
    
    private static OkHttpClient okHttpClient;
    
    
    private void intitOkHttp(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder ();
        if (BuildConfig.DEBUG) {
                
        }
        
    }
    
}
