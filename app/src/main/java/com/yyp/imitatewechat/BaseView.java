package com.yyp.imitatewechat;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public interface BaseView<T>{

    void showPersenter(T presenter);

    void showProgressDialog();

    void hidProgressDialog();

    void showError(String error);
}
