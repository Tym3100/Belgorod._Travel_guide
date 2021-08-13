package com.aitymkiv.belgorod_travelfuide;

import java.io.Serializable;

public class CashBack implements Serializable {
    private String name;
    private int imageRes;
    private int daysToCashBack;
    private int cashBack;

    public CashBack(String name, int imageRes, int daysToCashBack, int cashBack) {
        this.name = name;
        this.imageRes = imageRes;
        this.daysToCashBack = daysToCashBack;
        this.cashBack = cashBack;
    }


    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getDaysToCashBack() {
        return daysToCashBack;
    }

    public void setDaysToCashBack(int daysToCashBack) {
        this.daysToCashBack = daysToCashBack;
    }

    public int getCashBack() {
        return cashBack;
    }

    public void setCashBack(int cashBack) {
        this.cashBack = cashBack;
    }
}
