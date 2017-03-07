package com.yyp.imitatewechat.look.persenter.implContract.implPresenter;

import android.content.Context;

import com.google.gson.Gson;
import com.yyp.imitatewechat.Config;
import com.yyp.imitatewechat.api.ApiManage;
import com.yyp.imitatewechat.look.bean.MeiziData;
import com.yyp.imitatewechat.look.bean.VedioData;
import com.yyp.imitatewechat.look.persenter.contract.LookContract;
import com.yyp.imitatewechat.utils.CacheUtil;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public class ImplLookPresenter implements LookContract.LookPresenter {
    private Context context;
    private LookContract.LookView implLookView;

    private Gson gson = new Gson ();
    private CacheUtil mCacheUtil;

    public ImplLookPresenter(Context context, LookContract.LookView implLookView) {
        this.context = context;
        this.implLookView = implLookView;
        mCacheUtil = CacheUtil.get (context);
    }

    @Override
    public void getMeiZiPicture(int page) {
        implLookView.showProgressDialog ();
        Subscription subscribe = ApiManage.getInstence ()
                .getGankApiService ().getMeizhiData(page)
                .subscribeOn (Schedulers.io ())
                .observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Subscriber< MeiziData > () {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                implLookView.hidProgressDialog ();
                implLookView.showError (e.getMessage ());
            }

            @Override
            public void onNext(MeiziData meiziData) {
                implLookView.hidProgressDialog ();
                mCacheUtil.put (Config.ZHIHU, gson.toJson (meiziData));
                implLookView.updateMeiziData (meiziData.getResults ());
            }
        });
        addSubcrible(subscribe);
    }

    @Override
    public void getVedioData(int t) {
        Subscription subscribe = ApiManage.getInstence ().getGankApiService ().getVedioData (t)
                .subscribeOn (Schedulers.io ()).observeOn (AndroidSchedulers.mainThread ())
                .subscribe (new Subscriber< VedioData > () {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace ();
                implLookView.hidProgressDialog ();
                implLookView.showError (e.getMessage ());
            }

            @Override
            public void onNext(VedioData vedioData) {
                implLookView.hidProgressDialog ();
                implLookView.updateVedioData (vedioData.getResults ());
            }
        });
        addSubcrible (subscribe);
    }

    private CompositeSubscription mCompositeSubscription;
    /**
     * 添加订阅
     */
    private void addSubcrible(Subscription subscription) {
        if (this.mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription ();
        }
        this.mCompositeSubscription.add (subscription);
    }

    /**
     * 取消订阅
     */
    @Override
    public void unsubcrible() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription.unsubscribe ();
        }
    }
}
