package com.example.administrator.multitypelistview;

import android.graphics.drawable.Drawable;

public class ModelMovie {

    private Drawable imagimagePicture = null;
    private String   textTitle = ""  ;
    private String   textYear = ""  ;

    public Drawable getImagimagePicture() {
        return imagimagePicture;
    }

    public void setImagimagePicture(Drawable imagimagePicture) {
        this.imagimagePicture = imagimagePicture;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextYear() {
        return textYear;
    }

    public void setTextYear(String textYear) {
        this.textYear = textYear;
    }

    @Override
    public String toString() {
        return "ModelMovie{" +
                "imagimagePicture=" + imagimagePicture +
                ", textTitle='" + textTitle + '\'' +
                ", textYear='" + textYear + '\'' +
                '}';
    }

    public ModelMovie(Drawable image_picture, String text_title, String text_year) {
        this.imagimagePicture = image_picture;
        this.textTitle = text_title;
        this.textYear = text_year;
    }


    public ModelMovie() {
    }
}
