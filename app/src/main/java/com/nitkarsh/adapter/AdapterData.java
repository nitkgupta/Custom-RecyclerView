package com.nitkarsh.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nitkarsh.navdrawerrecycler.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> list;
    private DrawerLayout drawerLayout;
    private RecyclerView.LayoutManager layoutManager;
    private final int head=0,tag=1;

    public AdapterData(Context context, List<Object> list, DrawerLayout drawerLayout, RecyclerView.LayoutManager layoutManager){
        this.context=context;
        this.list=list;
        this.drawerLayout=drawerLayout;
        this.layoutManager=layoutManager;
    }

    private List<Object> objectList;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        switch (viewType){
            case tag:
                View v1=inflater.inflate(R.layout.recycler_menu_item,parent,false);
                viewHolder=new ViewTags(context,v1,drawerLayout,layoutManager);
                break;
            case head:
                View v2=inflater.inflate(R.layout.recycler_menu_head,parent,false);
                viewHolder= new ViewHead(v2);
                break;
            default:
                View v3=inflater.inflate(R.layout.recycler_menu_item,parent,false);
                viewHolder = new ViewTags(context,v3,drawerLayout,layoutManager);
                break;
        }

        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof TagData) {
            return tag;
        }
        else{
            return head;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case tag:
                ViewTags tags=(ViewTags)holder;
                TagData dataTag=(TagData)list.get(position);
                tags.getImageTag().setImageDrawable(ContextCompat.getDrawable(context,dataTag.getImage()));
                tags.getTextTag().setText(dataTag.getText());
                break;
            case head:
                ViewHead head=(ViewHead)holder;
                HeadData dataHead=(HeadData)list.get(position);
                head.getTvHead().setText(dataHead.getHead());
                break;
            default:
                ViewTags defaultTag=(ViewTags)holder;
                TagData dataDefault=(TagData)list.get(position);
                defaultTag.getImageTag().setImageDrawable(ContextCompat.getDrawable(context,dataDefault.getImage()));
                defaultTag.getTextTag().setText(dataDefault.getText());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
