package com.yyp.imitatewechat.look.persenter.implContract.implPresenter;

import com.yyp.imitatewechat.base.RxPresenter;
import com.yyp.imitatewechat.look.persenter.contract.LookContract;

/**
 * Created by codeest on 16/8/11.
 * 日期为明天时，取latest接口的数据
 * 其他日期，取before接口的数据
 */

public class ImplLookPresenter extends RxPresenter< LookContract.LookView > implements
        LookContract.LookPresenter {
    
    
    @Override
    public void attachView(LookContract.LookView view) {
        
    }
    
    @Override
    public void detachView() {
        
    }
    
    @Override
    public void getDailyData() {
        
    }
    
    @Override
    public void getBeforeData() {
        
    }
    
    @Override
    public void startInterval() {
        
    }
    
    @Override
    public void stopInterval() {
        
    }
    
    @Override
    public void insertReadToDB(int id) {
        
    }
}
