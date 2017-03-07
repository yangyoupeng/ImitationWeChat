package com.yyp.imitatewechat.look.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yyp.imitatewechat.R;
import com.yyp.imitatewechat.look.bean.Meizi;
import com.yyp.imitatewechat.utils.DensityUtil;

import java.util.ArrayList;

/**
 * Created by yangyoupeng on 2017/3/7.
 */

public class LookAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder > {


    private static final int TYPE_LOADING_MORE = -1;
    private static final int NOMAL_ITEM = 1;
    boolean showLoadingMore;

    int[] decsi;
    private ArrayList< Meizi > meiziItemes = new ArrayList<> ();
    private Context mContext;


    public LookAdapter(Context mContext) {
        this.mContext = mContext;

        decsi = DensityUtil.getDeviceInfo (mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return meiziItemes.size ();
    }
    class MeiziViewHolder extends RecyclerView.ViewHolder {
        //        final TextView textView;

        BadgedFourThreeImageView imageView;

        MeiziViewHolder(View itemView) {
            super (itemView);
            imageView = (BadgedFourThreeImageView) itemView.findViewById (R.id.item_image_id);
            //            textView = (TextView) itemView.findViewById(R.id.item_text_id);

        }
    }

}
