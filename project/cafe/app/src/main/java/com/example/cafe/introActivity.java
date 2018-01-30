package com.example.cafe;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.TextView;

public class introActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayoutDots;
    private Button mBtnPre;
    private Button mBtnNext;

    private int[] mLayouts = {
                    R.layout.intro_layout1,
                    R.layout.intro_layout2,
                    R.layout.intro_layout3
    };

    private introAdapter mIntroAdapter;
    private PrefManager  mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPref = new PrefManager( introActivity.this );
        if ( mPref.isFirstTimeLaunch() ){
            GoMain();
        }
        setContentView(R.layout.activity_intro);

        // 위젯 찾기.
        mViewPager  = findViewById(R.id.intro_view_pager);
        mLayoutDots = findViewById(R.id.bottom_dot);
        mBtnPre     = findViewById(R.id.btn_pre);
        mBtnNext    = findViewById(R.id.btn_next);

        mIntroAdapter = new introAdapter( introActivity.this );
        mViewPager.setAdapter( mIntroAdapter );
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                bottomdots( position );
            }
            @Override
            public void onPageSelected(int position) {  }
            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        ButtonClickListener bcListener = new ButtonClickListener();
        mBtnPre .setOnClickListener( bcListener );
        mBtnNext.setOnClickListener( bcListener );

        /*바닥 ... 만들기*/
        bottomdots( 0 );
    }

    private void bottomdots( int currentpage ) {
        TextView[] dots = new TextView[mLayouts.length];

        int currencolor = getResources().getColor(R.color.dot_active_screen1);
        int currennotcolor = getResources().getColor(R.color.dot_inactive_screen1);

        // LinearLayout 안의 모든 뷰를 삭제.
        mLayoutDots.removeAllViews();

        for( int i=0; i<mLayouts.length; i=i+1 ){
            dots[ i ] = new TextView( introActivity.this );
            dots[ i ].setText(  Html.fromHtml("&#8226;") );
            dots[ i ].setTextSize(35);
            dots[ i ].setTextColor( currennotcolor );
            mLayoutDots.addView( dots[i] );
        }

        dots[ currentpage ].setTextColor( currencolor );

    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int currentnumber = mViewPager.getCurrentItem();
            switch (v.getId()){
                case R.id.btn_pre:
                    if ( currentnumber >= 1 ){
                        currentnumber--;
                        mViewPager.setCurrentItem( currentnumber );
                    }

                    break;
                case R.id.btn_next:
                    if ( currentnumber < mLayouts.length-1 ) {
                        currentnumber++;
                        mViewPager.setCurrentItem(currentnumber);

                    }
                    else{
                        GoMain();
                    }
                    break;

            }
        }
    }

    private void GoMain() {
        mPref.setFirstTimeLaunch( true );

        Intent i = new Intent( introActivity.this , MainActivity.class );
        startActivity( i );

        finish();
    }


    /*intro pager 하는 adapter*/
    private class introAdapter extends PagerAdapter{

        LayoutInflater introLayout = null;

        public introAdapter( Context context ) {
            introLayout = LayoutInflater.from( context );
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = introLayout.inflate( mLayouts[ position ], container, false );
            container.addView( view );
            return view;
        }

        @Override
        public int getCount() {
            return mLayouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }
    }

}
