package com.grouptwo.ustcdiary.main.topics;

import com.grouptwo.ustcdiary.R;

public class Diary implements ITopic {

    private String title;
    private long id;
    private long count;
    private int color;
    private boolean pinned = false;

    public Diary(long id, String title, int color) {
        this.id = id;
        this.title = title;
        this.color = color;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return TYPE_DIARY;
    }

    @Override
    public int getIcon() {
        return R.drawable.diary;
    }

    @Override
    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    @Override
    public boolean isPinned() {
        return pinned;
    }
}
