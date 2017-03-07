package com.yyp.imitatewechat.api;

import com.yyp.imitatewechat.look.bean.ImageResponse;
import com.yyp.imitatewechat.zhihu.bean.ZhihuDaily;
import com.yyp.imitatewechat.zhihu.bean.ZhihuStory;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yangyoupeng on 2017/3/6.
 */

public interface ZhifuApi {

    @GET("/api/4/news/latest")
    Observable< ZhihuDaily > getLastDaily();


    @GET("/api/4/news/before/{date}")
    Observable< ZhihuDaily > getTheDaily(@Path("date") String date);


    @GET("/api/4/news/{id}")
    Observable<ZhihuStory > getZhihuStory(@Path("id") String id);

    @GET("http://lab.zuimeia.com/wallpaper/category/1/?page_size=1")
    Observable<ImageResponse > getImage();
}
