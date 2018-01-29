package com.example.tabpagerfragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // tablayout설정
        tablayout = findViewById(R.id.tab_layout);
        tablayout.addTab(tablayout.newTab().setText("Tab One"));
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_dialog_email));
        tablayout.addTab(tablayout.newTab().setText("Tab Three"));
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_dialog_map));

        // xml에서 설정하는것처럼 가능
        tablayout.setTabGravity(Gravity.FILL);  // in design : app:tabMode
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);  // in design : app:tabMode

        // ViewPager 설정
        viewpager = findViewById(R.id.view_pager);
        TabPagerAdapter adapter = new TabPagerAdapter( getSupportFragmentManager(), tablayout.getTabCount() );
        viewpager.setAdapter( adapter );   //TabPagerAdapter와 ViewPager연결

        // TabLayout과 ViewPager연결
        viewpager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tablayout ));

        // 화면에서 tab을 클릭 했을때 ViewPager화면 바꾸기
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.setOffscreenPageLimit( 4 );    // 이걸 안하면 주변 1개만 정보가 유지되는데
        // 이건 최대 4개까지 유지하도록 해줌
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {

        private int tabcount = 0;

        public TabPagerAdapter( FragmentManager fm, int numberOfTabs ) {
            super( fm );
            this.tabcount = numberOfTabs;
        }

        @Override
        public Fragment getItem( int position ) {

            switch (position) {
                case 0:
                    return FragmentTab1.newInstance("one","one");
                case 1:
                    return FragmentTab2.newInstance("two","two");
                case 2:
                    return FragmentTab3.newInstance("three","three");
                case 3:
                    return FragmentTab4.newInstance("four","four");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return this.tabcount;
        }
    }
}
