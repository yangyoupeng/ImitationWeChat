package com.yyp.imitatewechat.look.persenter.implContract.implPresenter;

import android.content.Context;

import com.google.gson.Gson;
import com.yyp.imitatewechat.look.persenter.contract.LookContract;
import com.yyp.imitatewechat.look.persenter.implContract.implView.ImplLookView;
import com.yyp.imitatewechat.utils.CacheUtil;

import rx.Subscription;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public class ImplLookPresenter implements LookContract.LookPresenter {
    private Context context;
    private ImplLookView implLookView;

    private Gson gson = new Gson ();

    private CacheUtil mCacheUtil;

    public ImplLookPresenter(Context context, ImplLookView implLookView) {
        this.context = context;
        this.implLookView = implLookView;
        mCacheUtil = CacheUtil.get (context);
    }

    @Override
    public void getMeiZiPicture(int t) {
        implLookView.showProgressDialog ();

    }

    @Override
    public void getVedioData(int t) {

    }

    /**
     * 添加订阅
     */
    private void addSubcrible(Subscription subscription) {

    }

    /**
     * 取消订阅
     */
    @Override
    public void unsubcrible() {

    }
}
