package com.nitkarsh.adapter;

import com.nitkarsh.navdrawerrecycler.R;

import java.util.ArrayList;
import java.util.List;

public class AllData {
    private static List<Object> tag=new ArrayList<>();
        public List<Object> getData(){
            TagData mData1=new TagData();
            TagData mData2=new TagData();
            TagData mData3=new TagData();
            TagData mData4=new TagData();
            TagData mData5=new TagData();
            TagData mData6=new TagData();
            TagData mData10=new TagData();
            HeadData mData7=new HeadData();
            HeadData mData8=new HeadData();
            HeadData mData9=new HeadData();

            mData7.setHead("Image Capture");
            tag.add(mData7);
            mData1.setImage(R.drawable.ic_menu_camera);
            mData1.setText("Camera");
            tag.add(mData1);
            mData2.setImage(R.drawable.ic_menu_gallery);
            mData2.setText("Gallery");
            tag.add(mData2);
            mData8.setHead("Extra Functions");
            tag.add(mData8);
            mData5.setImage(R.drawable.ic_menu_slideshow);
            mData5.setText("Slideshow");
            tag.add(mData5);
            mData4.setImage(R.drawable.ic_menu_manage);
            mData4.setText("Manage");
            tag.add(mData4);
            mData9.setHead("Send and Share");
            tag.add(mData9);
            mData3.setImage(R.drawable.ic_menu_send);
            mData3.setText("Send");
            tag.add(mData3);
            mData6.setImage(R.drawable.ic_menu_share);
            mData6.setText("Share");
            tag.add(mData6);
            mData10.setImage(R.drawable.ic_menu_manage);
            mData10.setText("Distribution");
            tag.add(mData10);


            return tag;
        }
}
