package com.aitymkiv.belgorod_travelfuide;

import android.net.Uri;

public class Product {
    private String name;
    private float price;
    private int imageRes;
    private Uri uri;

    public Product(String name, float price, int imageRes, Uri uri) {
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
