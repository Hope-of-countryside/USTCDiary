package com.grouptwo.ustcdiary.main;

public class Topic {
    private String name;
    private int imageId;
    public Topic(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
