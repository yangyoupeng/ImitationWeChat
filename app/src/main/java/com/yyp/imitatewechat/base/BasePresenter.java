package com.yyp.imitatewechat.base;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public interface BasePresenter<T extends BaseView> {
    
    void attachView(T view);
    
    void detachView();
}
