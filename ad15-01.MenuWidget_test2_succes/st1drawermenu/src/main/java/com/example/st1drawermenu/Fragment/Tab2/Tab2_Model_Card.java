package com.example.st1drawermenu.Fragment.Tab2;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Tab2_Model_Card implements Parcelable{

    private Drawable imageCoffee;
    private String   textCoffee ;
    private String   payCoffee  ;
    private String positionCoffee;

    /*-----------------------------------------*/
    /*getter & setter*/

    protected Tab2_Model_Card(Parcel in) {
        textCoffee = in.readString();
        payCoffee = in.readString();
        positionCoffee = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textCoffee);
        dest.writeString(payCoffee);
        dest.writeString(positionCoffee);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tab2_Model_Card> CREATOR = new Creator<Tab2_Model_Card>() {
        @Override
        public Tab2_Model_Card createFromParcel(Parcel in) {
            return new Tab2_Model_Card(in);
        }

        @Override
        public Tab2_Model_Card[] newArray(int size) {
            return new Tab2_Model_Card[size];
        }
    };

    public String getPayCoffee() {
        return payCoffee;
    }

    public void setPayCoffee(String payCoffee) {
        this.payCoffee = payCoffee;
    }

    public String getPositionCoffee() {
        return positionCoffee;
    }

    public void setPositionCoffee(String positionCoffee) {
        this.positionCoffee = positionCoffee;
    }

    public Drawable getImageCoffee() {
        return imageCoffee;
    }

    public void setImageCoffee(Drawable imageCoffee) {
        this.imageCoffee = imageCoffee;
    }

    public String getTextCoffee() {
        return textCoffee;
    }

    public void setTextCoffee(String textCoffee) {
        this.textCoffee = textCoffee;
    }

    /*-----------------------------------------*/
    /*toString*/

    @Override
    public String toString() {
        return "Tab2_Model_Card{" +
                "imageCoffee=" + imageCoffee +
                ", textCoffee='" + textCoffee + '\'' +
                ", payCoffee='" + payCoffee + '\'' +
                ", positionCoffee='" + positionCoffee + '\'' +
                '}';
    }

    public Tab2_Model_Card(Drawable imageCoffee, String textCoffee, String payCoffee, String countCofee) {
        this.imageCoffee = imageCoffee;
        this.textCoffee = textCoffee;
        this.payCoffee = payCoffee;
        this.positionCoffee = countCofee;
    }

    public Tab2_Model_Card() {
    }
}
