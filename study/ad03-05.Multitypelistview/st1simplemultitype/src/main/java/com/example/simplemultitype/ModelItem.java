package com.example.simplemultitype;

import android.graphics.drawable.Drawable;

public class ModelItem {
    //View Type을 위한 필드  : 1 or 2
    private int type;

    //listviewitem1
    private String title   = ""  ;   //TextView
    private String desc    = ""  ;   //TextView

    //listviewitem2
    private Drawable image = null;   //ImageView
    private String   name  = ""  ;   //TextView

    //getter setter

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //toString

    @Override
    public String toString() {
        return "ModelItem{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                '}';
    }

    //Constructor
    public ModelItem() {
    }
    //type1 생성자

    public ModelItem(String title, String desc) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_TEXT;
        this.title = title;
        this.desc = desc;
    }

    //type2 생성자
    public ModelItem(String name , Drawable image) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_IMAGES;
        this.name = name;
        this.image = image;
    }

}
