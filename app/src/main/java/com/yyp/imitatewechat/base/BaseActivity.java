package com.yyp.imitatewechat.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yyp.imitatewechat.App;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangyoupeng on 2017/2/28.
 */

public abstract class BaseActivity< T extends BasePresenter > extends AppCompatActivity
        implements BaseView {
    @Inject
    protected T mPresenter;
    
    protected Activity mContext;
    private Unbinder bind;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (getLayout ());
        bind = ButterKnife.bind (this);
        this.mContext = this;
        initInject ();
        //       当Presenter不等于空，就把当前的实例传入Presenter attachView()方法里面
        if (mPresenter != null) {
            mPresenter.attachView (this);
            App.getInstance ().addActivity (this);
            // 初始化数据
            initEventAndData ();
        }
    }
    
    
    /**
     * 填充布局到当前view
     */
    protected abstract int getLayout();
    
    /**
     * 填充数据到当前view
     */
    protected abstract void initEventAndData();
    
    /**
     * 子类必须实例，注射
     */
    protected abstract void initInject();
}
