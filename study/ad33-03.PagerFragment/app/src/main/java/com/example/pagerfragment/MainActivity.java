package com.example.pagerfragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);

        // BgPagerAdapter 인스턴스 생성

        BgPagerAdapter adapter = new BgPagerAdapter(MainActivity.this );
        pager.setAdapter( adapter );
        pager.setOffscreenPageLimit( 4 );    // 이걸 안하면 주변 1개만 정보가 유지되는데
                                             // 이건 최대 4개까지 유지하도록 해줌

    }

    private class BgPagerAdapter extends PagerAdapter{

        LayoutInflater inflater = null;

        public BgPagerAdapter( Context context ) {

            inflater = LayoutInflater.from( context );
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = null;
            switch (position){
                case 0:
                    v = inflater.inflate(R.layout.layout0,null,false);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.layout1,null,false);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.layout2,null,false);
                    break;
                case 3:
                    v = inflater.inflate(R.layout.layout3,null,false);
                    break;
                case 4:
                    v = inflater.inflate(R.layout.layout4,null,false);
                    break;
            }

            container.addView( v );

            return  v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView( (View)object );
        }
    }
}
