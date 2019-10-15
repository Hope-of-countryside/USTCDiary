package com.grouptwo.ustcdiary.main.topics;


import androidx.annotation.DrawableRes;



public interface ITopic {

    int TYPE_CONTACTS = 0;

    int TYPE_DIARY = 1;


    int TYPE_MEMO = 2;

    String getTitle();


    void setTitle(String title);

    int getType();

    long getId();

    @DrawableRes
    int getIcon();


    void setCount(long count);

    long getCount();

    int getColor();

    void setColor(int color);


    void setPinned(boolean pinned);

    boolean isPinned();
}
