package com.aitymkiv.belgorod_travelfuide;


import android.net.Uri;

import java.util.Date;

public class NewsItem {
    public String getHeading() {
        return mHeading;
    }

    public void setHeading(String heading) {
        this.mHeading = heading;
    }

    public String getNewsText() {
        return mNewsText;
    }

    public void setNewsText(String newsText) {
        this.mNewsText = newsText;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(int imageRes) {
        this.mImageRes = imageRes;
    }

    public void setURINews(Uri uriNews) {
        this.mURINews = uriNews;
    }

    private String mHeading;
    private String mNewsText;
    private String mDate;
    private int mImageRes;
    private Uri mURINews;

    public NewsItem(String heading, String newsText, String date, int imageRes, Uri uriNews) {
        this.mHeading = heading;
        this.mNewsText = newsText;
        this.mDate = date;
        this.mImageRes = imageRes;
        this.mURINews = uriNews;
    }
    public Uri getURINews(){
        return this.mURINews;
    }
}
