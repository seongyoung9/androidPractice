package com.example.administrator.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorOptionsView extends LinearLayout{

    private View value;
    private ImageView image;
    private TextView title;

    public ColorOptionsView(Context context) {
        super(context);
        init( context,null ,0);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init( context,attrs,0);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init( context,attrs,defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        //CustomView  attr속성 가져오기
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ColorOptionsView,defStyleAttr,0);

        String titleText  = a.getString(R.styleable.ColorOptionsView_titleText);
        @SuppressLint("ResourceAsColor")
        int    valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor, android.R.color.holo_blue_bright);
        a.recycle();//재사용

        //LinearLayout 관련 속성 설정.
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

        //inflation하기.
        LayoutInflater inflater = LayoutInflater.from( context );
        inflater.inflate( R.layout.view_color_options, this, true );

        //자식 뷰에 값을 설정하기
        //0번째 자식 불러오고 값설정
        title = (TextView) this.getChildAt(0);
        title.setText( titleText );

        //1번째 자식 불러오고 값설정
        value = this.getChildAt(1);
        value.setBackgroundColor( valueColor );

        //2번째 자식 불러오고 값설정
        image = (ImageView) this.getChildAt(2);

        //3번째 자식 불러오고 값설정
        CheckBox check = (CheckBox) this.getChildAt(3);
    }

    public void setValueColor(int color){
        value.setBackgroundColor( color );
    }
    public void setImage(int resurceID){
        image.setImageResource(resurceID);
        //image.setImageDrawable();
    }
    public void setImageVisible( boolean visible ){
        image.setVisibility(visible ? View.VISIBLE : View.GONE);

    }
    public String getText(){
            return title.getText().toString();
    }
}
