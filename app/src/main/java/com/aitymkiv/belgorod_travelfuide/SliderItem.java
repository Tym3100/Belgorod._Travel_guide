package com.aitymkiv.belgorod_travelfuide;

public class SliderItem {

    private String description;
    private int imageRes;

    public SliderItem(String description, int imageRes) {
        this.description = description;
        this.imageRes = imageRes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
