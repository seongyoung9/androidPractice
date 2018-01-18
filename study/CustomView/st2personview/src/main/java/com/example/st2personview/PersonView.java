package com.example.st2personview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonView extends RelativeLayout{

    //OnimageClickLinstener이벤트 발생시 전달할 데이터
    private PersonData person = null;

    //인터페이스 정의
    public interface OnimageClickLinstener {
        void onImageClick( PersonView view, PersonData person);
    }
    //인터페이스 선언
    OnimageClickLinstener imageClickLinstener;
    public void setOnimageClickLinstener( OnimageClickLinstener linstener ){
        this.imageClickLinstener = linstener;
    }

    public PersonView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        //RelativeLayout 관련 속성 설정.
        //없음
        //디자인 xml 파일 inflation 하기.  xml을 자바코드로 바꾸기
        LayoutInflater.from(context).inflate(R.layout.view_person,this,true);

        //widget선언
        ImageView image_photo,image_check;
        TextView  textname,        textage;

        //widget찾기
        textname = findViewById(R.id.text_name);
        textage  = findViewById(R.id.text_age);
        image_photo = findViewById(R.id.image_photo);
        image_check = findViewById(R.id.image_check);


        //커스텀뷰 디자인에서 attrs로 정의한 속성 값 가져오기
        if ( attrs != null){
            TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.PersonView,defStyleAttr,0);

            //app:my_name에서 설정한 속성값을 불러오기
            String name = ta.getString(R.styleable.PersonView_my_name);
            textname.setText( name );

            //app:my_age에서 설정한 속성값을 불러오기
            int age = ta.getInt( R.styleable.PersonView_my_age,-1 );
            textage.setText( age + "" );

            //app:my_photo에서 설정한 속성값을 불러오기
            Drawable photo = ta.getDrawable( R.styleable.PersonView_my_photo );
            image_photo.setImageDrawable( photo );

            //재사용, 반드시 호출
            ta.recycle();
            //OnimageClickLinstener이벤트 발생시 전달할 데이터
            person = new PersonData(name,age,photo);
        }

        image_photo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( imageClickLinstener != null ){

                    //컨테이너 위젯으로 이벤트 발생.(부모로 이벤트 발생시킴)
                    imageClickLinstener.onImageClick(PersonView.this, person );
                }
            }
        });
    }
}
