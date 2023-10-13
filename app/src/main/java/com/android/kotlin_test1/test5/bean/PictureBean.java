package com.android.kotlin_test1.test5.bean;

public class PictureBean {
    /**
     * large : https://randomuser.me/api/portraits/women/72.jpg
     * medium : https://randomuser.me/api/portraits/med/women/72.jpg
     * thumbnail : https://randomuser.me/api/portraits/thumb/women/72.jpg
     */

    private String large;
    private String medium;
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
