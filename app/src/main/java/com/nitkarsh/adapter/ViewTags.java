package com.nitkarsh.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nitkarsh.navdrawerrecycler.R;

public class ViewTags extends RecyclerView.ViewHolder {
    private ImageView imageTag;
    private TextView textTag;
    ConstraintLayout constraintLayout;
    private static int last_position=-1;
    public ViewTags(final Context context, View itemView, final DrawerLayout drawerLayout, final RecyclerView.LayoutManager layoutManager) {
        super(itemView);
        imageTag=itemView.findViewById(R.id.image_tag);
        textTag=itemView.findViewById(R.id.text_tag);
        constraintLayout=itemView.findViewById(R.id.layout_inflate);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(last_position==-1) {
                    constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.colorTint));
                    last_position=getAdapterPosition();
                }
                else{
                    constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.colorTint));
                    constraintLayout=layoutManager.findViewByPosition(last_position).findViewById(R.id.layout_inflate);
                    constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.colorGone));
                    last_position=getAdapterPosition();
                    constraintLayout=layoutManager.findViewByPosition(last_position).findViewById(R.id.layout_inflate);
                }
                Toast.makeText(context,"Item Clicked at Position "+getAdapterPosition(),Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });
    }

    public ImageView getImageTag() {
        return imageTag;
    }

    public void setImageTag(ImageView imageTag) {
        this.imageTag = imageTag;
    }

    public TextView getTextTag() {
        return textTag;
    }

    public void setTextTag(TextView textTag) {
        this.textTag = textTag;
    }
}
