package com.yyp.imitatewechat.look.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yyp.imitatewechat.look.persenter.contract.LookContract;

/**
 * Created by yangyoupeng on 2017/2/28.
 */

public class LookFragment extends Fragment implements LookContract.LookView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView (inflater, container, savedInstanceState);
    }

    @Override
    public void showPersenter(LookContract.LookPresenter presenter) {

    }
}
