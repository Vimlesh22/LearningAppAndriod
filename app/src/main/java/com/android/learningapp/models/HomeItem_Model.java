package com.android.learningapp.models;

public class HomeItem_Model {
    private int image;
    private String title;

    public HomeItem_Model(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
