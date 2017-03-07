package com.yyp.imitatewechat.api;

import com.yyp.imitatewechat.MyAppliction;
import com.yyp.imitatewechat.look.bean.GankApi;
import com.yyp.imitatewechat.wangyi.bean.TopNews;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangyoupeng on 2017/3/6.
 */

public class ApiManage {
    /**
     * 控制拦截器，重写缓存
     */
    private static Interceptor rewrite_cache_control_interceptor = new Interceptor () {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request ();
            Response proceedResponse = chain.proceed (request);
            //            如果网络可用
            if (NetWorkUtil.isNetWorkAvailable (MyAppliction.getContext ())) {
                int maxAge = 60; // 在线缓存在1分钟内可读取
                return proceedResponse.newBuilder ().removeHeader ("Pragma").removeHeader
                        ("Cache-Control").header ("Cache-Control", "public, max-age=" + maxAge)
                        .build ();

            } else {
                //        网络不可用
                int maxStale = 60 * 60 * 24 * 7 * 4; // 缓存四周（28 天）
                return proceedResponse.newBuilder ().removeHeader ("Pragma").removeHeader
                        ("Cache-control").header ("Cache-control", "public, max-stale=" +
                        maxStale).build ();
            }
        }
    };

    public static ApiManage apiManage;

    private static File httpCacheDirectroy = new File (MyAppliction.getContext ().getCacheDir (),
            "zhifuCache");
    private static int cacheSize = 10 * 1024 * 1024;//10G
    private static Cache cache = new Cache (httpCacheDirectroy, cacheSize);
    private static OkHttpClient client = new OkHttpClient ().newBuilder ().addInterceptor
            (rewrite_cache_control_interceptor).addNetworkInterceptor
            (rewrite_cache_control_interceptor).cache (cache).build ();

    public ZhifuApi zhifuApi;
    public TopNews topNews;
    private Object zhihuMonitor = new Object ();

    public static ApiManage getInstence() {
        if (apiManage == null) {
            synchronized (ApiManage.class) {
                if (apiManage == null) {
                    apiManage = new ApiManage ();
                }
            }
        }
        return apiManage;
    }

    public ZhifuApi getZhifuApiService() {
        if (zhifuApi == null) {
            synchronized (zhihuMonitor) {
                if (zhifuApi == null) {
                    zhifuApi = new Retrofit.Builder ()
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create ())
                            .addConverterFactory(GsonConverterFactory.create ())
                            .client (client)
                            .build ()
                            .create(ZhifuApi.class);

                }
            }
        }
        return zhifuApi;
    }

    public  TopNews getTopNewsService(){
        if (topNews==null) {
            synchronized (zhihuMonitor) {
                if (topNews == null) {
                    topNews = new Retrofit
                            .Builder ()
                            .baseUrl ("http://c.m.163.com")
                            .addCallAdapterFactory (RxJavaCallAdapterFactory.create ())
                            .addConverterFactory (GsonConverterFactory.create ()).client (client)
                            .build ()
                            .create (TopNews.class);
                }
            }
        }
        return topNews;
    }

    private GankApi gankApi;

    public GankApi getGankApiService(){
        if (gankApi == null) {
            synchronized (zhihuMonitor) {
                if (gankApi == null) {
                    gankApi = new Retrofit.Builder ()
                            .baseUrl("http://gank.io")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create ())
                            .addConverterFactory (GsonConverterFactory.create ())
                            .client (client)
                            .build ()
                            .create (GankApi.class);
                }
            }
        }
        return gankApi;
    }
}
