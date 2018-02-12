package com.example.tabpagerfragment;

import android.graphics.drawable.Drawable;

public class Tab4_Model_Image {

    private Drawable firstImage   = null ;
    private Drawable    secondImage  = null ;
    private String      firstText    = ""   ;
    private String      secondText   = ""   ;

    /*------------------------------------------------------*/
    /*getter & setter*/

    public Drawable getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(Drawable firstImage) {
        this.firstImage = firstImage;
    }

    public Drawable getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(Drawable secondImage) {
        this.secondImage = secondImage;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }
    /*------------------------------------------------------*/
    /*toString*/

    @Override
    public String toString() {
        return "Tab4_Model_Image{" +
                "firstImage=" + firstImage +
                ", secondImage=" + secondImage +
                ", firstText='" + firstText + '\'' +
                ", secondText='" + secondText + '\'' +
                '}';
    }

    /*------------------------------------------------------*/
    /*toString*/

    public Tab4_Model_Image() {
    }

    public Tab4_Model_Image(Drawable firstImage, Drawable secondImage, String firstText, String secondText) {
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.firstText = firstText;
        this.secondText = secondText;
    }
}
