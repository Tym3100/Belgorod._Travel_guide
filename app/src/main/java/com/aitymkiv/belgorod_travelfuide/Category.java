package com.aitymkiv.belgorod_travelfuide;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private List<CashBack> cashBackList = new ArrayList<>();
    private int imageResCategory;
    private String categoryName;
    private int cashbackValue;

    public Category(int imageResCategory, String categoryName, int cashbackValue) {
        this.imageResCategory = imageResCategory;
        this.categoryName = categoryName;
        this.cashbackValue = cashbackValue;
    }

    public List<CashBack> getCashBackList() {
        return cashBackList;
    }

    public void setCashBackList(List<CashBack> cashBackList) {
        this.cashBackList = cashBackList;
    }

    public void addCashBack(CashBack cashBack){
        cashBackList.add(cashBack);
    }

    public void addCashBack(List<CashBack> cashBacks){
        cashBackList.addAll(cashBacks);
    }

    public int getImageResCategory() {
        return imageResCategory;
    }

    public void setImageResCategory(int imageResCategory) {
        this.imageResCategory = imageResCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCashbackValue() {
        return cashbackValue;
    }

    public void setCashbackValue(short cashbackValue) {
        this.cashbackValue = cashbackValue;
    }
}
