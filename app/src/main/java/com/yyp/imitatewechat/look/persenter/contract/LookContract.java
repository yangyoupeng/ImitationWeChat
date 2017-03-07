package com.yyp.imitatewechat.look.persenter.contract;

import com.yyp.imitatewechat.BasePresenter;
import com.yyp.imitatewechat.BaseView;
import com.yyp.imitatewechat.look.bean.Gank;
import com.yyp.imitatewechat.look.bean.Meizi;

import java.util.ArrayList;

/**
 * Created by yangyoupeng on 2017/3/3.
 */

public interface LookContract {

    interface LookPresenter extends BasePresenter {
        void getMeiZiPicture(int t);

        void getVedioData(int t);
    }

    interface LookView extends BaseView< LookPresenter > {
        void updateMeiziData(ArrayList< Meizi > list);
        void updateVedioData(ArrayList< Gank > list);

    }

}
