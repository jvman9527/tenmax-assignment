package com.tenmax.interview.assignment.basic.domain;

/**
 * TenMax 廣告圖
 */
public class Image {

    private String url;

    private int w;

    private int h;

    public Image() {}

    public Image(String url, int w, int h) {
        this.url = url;
        this.w = w;
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

}

