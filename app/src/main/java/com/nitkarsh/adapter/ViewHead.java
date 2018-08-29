package com.nitkarsh.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.nitkarsh.navdrawerrecycler.R;

public class ViewHead extends RecyclerView.ViewHolder {
    private TextView tvHead;
    public ViewHead(View itemView) {
        super(itemView);
        tvHead=itemView.findViewById(R.id.text_head);
    }

    public TextView getTvHead() {
        return tvHead;
    }

    public void setTvHead(TextView tvHead) {
        this.tvHead = tvHead;
    }
}
