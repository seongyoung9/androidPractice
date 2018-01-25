package com.example.slide;

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

import org.w3c.dom.Text;

public class IntroActivity extends AppCompatActivity {

    private ViewPager     mViewPager  = null;
    private LinearLayout  mLayoutDots = null;
    private Button        mBtnSkip    = null;
    private Button        mBtnNext    = null;

    private PrefManager   mPref       = null;
    private int[] mLayouts = {
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4
    };

    private SlidePagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // SharedPreference 를 이용하여 FirstLaunch값을 체크한다
        mPref = new PrefManager( IntroActivity.this );

        // intro 화면 4개를 모두 본 경우 다시 IntroActivity를 출력하지 않기 위해서
        if ( mPref.isFirstTimeLaunch() ){
            launchMain();
        }

        setContentView(R.layout.activity_intro);

        mViewPager  = findViewById(R.id.view_pager );


        // 위젯 설정 리스너 어뎁터
        // pager와 adapter
        mAdapter = new SlidePagerAdapter( IntroActivity.this );

        mViewPager.setAdapter( mAdapter );
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                addBottomDots( position );
                if ( position  == mLayouts.length -1 ){
                    mBtnNext.setText(R.string.end);
                }
                else{
                    mBtnNext.setText(R.string.next);
                }
            }
            @Override
            public void onPageSelected(int position) {  }
            @Override
            public void onPageScrollStateChanged(int state) {  }
        });
        // Button
        mBtnNext    = findViewById(R.id.btn_next   );
        mBtnSkip    = findViewById(R.id.btn_skip   );

        ButtonClickListener bclistener = new ButtonClickListener();
        mBtnNext .setOnClickListener( bclistener );
        mBtnSkip .setOnClickListener( bclistener );

        // 바닥에 있는 점 만들기 mLayouts 수대로
        mLayoutDots = findViewById(R.id.layout_dots);
        addBottomDots( 0 );
    }

    private void addBottomDots( int currentPage ) {
        TextView[] dots = new TextView[ mLayouts.length ];
        int[] colorActive   = getResources().getIntArray( R.array.array_dot_active   );
        int[] colorinActive = getResources().getIntArray( R.array.array_dot_inactive );

        // layout에 있는 모든 뷰를 삭제한다
        mLayoutDots.removeAllViews();

        for ( int i = 0; i < mLayouts.length; i++ ){
            dots[ i ] = new TextView( IntroActivity.this );
            dots[ i ].setText( Html.fromHtml( "&#8226;" ) );
            dots[ i ].setTextSize( 35 );
            dots[ i ].setTextColor( colorinActive[ i ] );
            mLayoutDots.addView( dots[ i ]);
        }
        dots[ currentPage ].setTextColor( colorActive[ currentPage ] );
    }


    private class SlidePagerAdapter extends PagerAdapter{

        private final LayoutInflater inflater;

        public SlidePagerAdapter(Context context) {
            inflater = LayoutInflater.from( context );
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
                                                 // layout을 배열로 저장해둔것
            View inflateView = inflater.inflate( mLayouts[position] , container , false );

            container.addView( inflateView );
            return inflateView;
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

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_next:
                    int currentposition = mViewPager.getCurrentItem() + 1;
                    if ( currentposition < mLayouts.length ){
                        mViewPager.setCurrentItem( currentposition );
                    }
                    else{
                        launchMain();
                    }
                    break;
                case R.id.btn_skip:
                    launchMain();  // intro를 그만보고 메인으로 간다
                    break;
            }
        }
    }
    private void launchMain() {
        mPref.setFirstTimeLaunch( true );
        Intent i = new Intent( IntroActivity.this, MainActivity.class);
        startActivity( i );

        finish();
    }
}
