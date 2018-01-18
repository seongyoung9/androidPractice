package com.example.administrator.checkablecustom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPerson extends RelativeLayout implements Checkable{
//인터페이스 정의
    public static interface OnCheckedChangedListener{
        void onCheckedChanged( View checkableView, boolean isChecked );
    }
    //인터페이스 리스너 선언
    public OnCheckedChangedListener checkedChangedListener;
    public void setOnCheckedChangeListener( OnCheckedChangedListener listener ){
        this.checkedChangedListener = listener;
    }



    private ImageView imagephoto;
    private TextView  textname,textage;
    private CheckBox  check;
    boolean ischecked;

    public ViewPerson(Context context) {
        super(context);

        init(context, null, 0);
    }

    public ViewPerson(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs, 0);
    }

    public ViewPerson(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    @Override
    public void setChecked(boolean checked) {
        if (ischecked != checked){
            this.ischecked = checked;
            drawCheck();
        }
    }

    private void drawCheck() {
        if (this.ischecked){
            check.setChecked( this.ischecked );
            this.setBackgroundColor(Color.RED);
        }
        else{
            check.setChecked( this.ischecked );
            this.setBackgroundColor(Color.YELLOW);
        }

        Log.d("ViewPerson",ischecked+"");
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void toggle() {
        // true이면 false    false 면  true
        this.setChecked( !this.ischecked );
    }
    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        LayoutInflater.from( context )
                      .inflate( R.layout.view_person,this,true );

        textname      = findViewById(R.id.text_name);
        textage       = findViewById(R.id.text_age);
        imagephoto    = findViewById(R.id.image_photo);
        check         = findViewById(R.id.check);

    }
    ModelPerson person;

    public ModelPerson getPerson() {
        return person;
    }

    public void setPerson(ModelPerson person) {
        this.person = person;

        //추가해야하는 부분
        imagephoto  .setImageDrawable( person.getImage_photo() );
        textname    .setText( person.getText_name() );
        textage     .setText( person.getText_age() );
        //this.setChecked( person.getImage_check() );
    }

}
