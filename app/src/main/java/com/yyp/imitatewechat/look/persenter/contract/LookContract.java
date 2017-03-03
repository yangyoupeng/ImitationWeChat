package com.yyp.imitatewechat.look.persenter.contract;

import com.yyp.imitatewechat.BasePresenter;
import com.yyp.imitatewechat.BaseView;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public interface LookContract {

    interface LookPresenter extends BasePresenter {
        void showDate();

        void setTitle(String title);
    }

    interface LookView extends BaseView< LookPresenter > {

    }

}
