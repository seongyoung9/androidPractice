package com.example.administrator.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button    btn1;
    private Button    btn2;
    private Button    btn3;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1  = findViewById(R.id.btn1);
        btn2  = findViewById(R.id.btn2);
        btn3  = findViewById(R.id.btn3);


        //핸들러 설정
        clickhandler handler = new clickhandler();
        btn1.setOnClickListener( handler );
        btn2.setOnClickListener( handler );
        btn3.setOnClickListener( handler );

        //pager와 adapter연결
        pager = findViewById(R.id.pager);
        MyPagerAdater adapter = new MyPagerAdater(getApplicationContext());
        pager.setAdapter( adapter );

    }
    //버튼 클릭 핸들러
    private class clickhandler implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.btn1:
                    pager.setCurrentItem(0,true);
                    break;

                case R.id.btn2:
                    pager.setCurrentItem(1,true);
                    break;

                case R.id.btn3:
                    pager.setCurrentItem(2,true);
                    break;

            }
        }
    }

    private class MyPagerAdater extends PagerAdapter{

        //필드선언
        private LayoutInflater inflater;

        //생성자 : 반드시 Context를 생성자의 매개변수로 받아야 한다.
        public MyPagerAdater(Context c) {
            this.inflater = LayoutInflater.from( c );
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            View v = null;

            switch (position) {
                case 0:
                    v = inflater.inflate(R.layout.inflate_one, null,false);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.inflate_two, null,false);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.inflate_three, null,false);
                    break;
            }
            pager.addView( v );

            return v;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            pager.removeView((View)object);
        }
    }
}
