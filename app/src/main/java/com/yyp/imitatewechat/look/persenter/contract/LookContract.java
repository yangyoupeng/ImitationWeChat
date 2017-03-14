package com.yyp.imitatewechat.look.persenter.contract;

import com.yyp.imitatewechat.base.BasePresenter;
import com.yyp.imitatewechat.base.BaseView;
import com.yyp.imitatewechat.look.model.DailyBeforeListBean;
import com.yyp.imitatewechat.look.model.DailyListBean;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public interface LookContract {
    
    interface LookPresenter extends BasePresenter< LookView > {
        void getDailyData();
        
        void getBeforeData();
        
        void startInterval();
        
        void stopInterval();
        
        void insertReadToDB(int id);
    }
    
    interface LookView extends BaseView {
        void showContent(DailyListBean info);
        
        void showMoreContent(String data, DailyBeforeListBean foreInfo);
        
        void doInterval(int currentCount);
    }
    
}
