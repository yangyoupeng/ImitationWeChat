package com.yyp.imitatewechat.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yangyoupeng on 2017/3/14.
 */

public class RxPresenter< T extends BaseView > implements BasePresenter< T > {
    
    private T mView;
    
    /**
     * 管理rxjava所有的订阅者，在activity里面ondestroy或者onpouse方法统一取消
     */
    protected CompositeSubscription compositeSubscription;
    
    /**
     * 取消订阅
     */
    protected void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe ();
        }
    }
    
    /**
     * 添加订阅
     */
    protected void addSubscribe(Subscription subscription) {
        if (compositeSubscription != null) {
            compositeSubscription.add (subscription);
        } else {
            compositeSubscription = new CompositeSubscription ();
        }
    }
    
    @Override
    public void attachView(T view) {
        this.mView = view;
    }
    
    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe ();
    }
}
