package com.example.checklist;

import android.graphics.drawable.Drawable;
import android.widget.CheckBox;

public class ModelPerson {

    private Drawable imagePhoto = null;
    private String   textName   = ""  ;
    private String   textAge    = ""  ;
    private Boolean  imageCheck = null;

    @Override
    public String toString() {
        return "ModelPerson{" +
                "imagePhoto=" + imagePhoto +
                ", textName='" + textName + '\'' +
                ", textAge='" + textAge + '\'' +
                ", imageCheck=" + imageCheck +
                '}';
    }

    public ModelPerson(Drawable imagePhoto, String textName, String textAge, Boolean imageCheck, boolean check) {
        this.imagePhoto = imagePhoto;
        this.textName = textName;
        this.textAge = textAge;
        this.imageCheck = imageCheck;
    }

    public Drawable getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(Drawable imagePhoto) {
        this.imagePhoto = imagePhoto;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextAge() {
        return textAge;
    }

    public void setTextAge(String textAge) {
        this.textAge = textAge;
    }

    public Boolean getImageCheck() {
        return imageCheck;
    }

    public void setImageCheck(Boolean imageCheck) {
        this.imageCheck = imageCheck;
    }

    public ModelPerson() {
    }

}
