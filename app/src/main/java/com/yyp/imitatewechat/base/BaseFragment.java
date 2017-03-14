package com.yyp.imitatewechat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

/**
 * Created by yangyoupeng on 2017/3/14.
 */

public abstract class BaseFragment< T extends BasePresenter > extends Fragment implements BaseView {
    protected T mPresenter;
    private View view;
    protected boolean isInited = false;
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        view = inflater.inflate (getLayoutId (), null);
        initInject ();
        return view;
    }
    
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView (this);
        }
        
        if (savedInstanceState != null) {
            if (!isHidden ()) {
                isInited = true;
                initEventAndData ();
            }
        }
    }
    
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged (hidden);
        if (!isInited && !hidden) {
            isInited = true;
            initEventAndData ();
        }
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        unbinder.unbind ();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy ();
    
        if (mPresenter != null) {
            mPresenter.detachView ();
        }
    }
    
    protected abstract void initInject();
    
    protected abstract int getLayoutId();
    
    protected abstract void initEventAndData();
}
