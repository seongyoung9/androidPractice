package com.example.administrator.checkablecustom;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class ModelPerson{

    private Drawable  image_photo;
    private String    text_name;
    private String    text_age;
    private Boolean   image_check;

    public String getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name = text_name;
    }

    public String getText_age() {
        return text_age;
    }

    public void setText_age(String text_age) {
        this.text_age = text_age;
    }

    public Drawable getImage_photo() {
        return image_photo;
    }

    public void setImage_photo(Drawable image_photo) {
        this.image_photo = image_photo;
    }

    public Boolean getImage_check() {
        return image_check;
    }

    public void setImage_check(Boolean image_check) {
        this.image_check = image_check;
    }

    @Override
    public String toString() {
        return "ModelPerson{" +
                "image_photo=" + image_photo +
                ", text_name=" + text_name +
                ", text_age=" + text_age +
                ", image_check=" + image_check +
                '}';
    }

    public ModelPerson() {
    }

    public ModelPerson(Drawable image_photo, String text_name, String text_age, Boolean image_check) {
        this.image_photo = image_photo;
        this.text_name = text_name;
        this.text_age = text_age;
        this.image_check = image_check;
    }
}
