package com.example.tabpagerfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        // tablayout 설정
        tablayout = findViewById(R.id.tab_layout);
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_dialog_email).setText("1"));
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_dialog_map  ).setText("2"));
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_dialog_info ).setText("3"));
        tablayout.addTab(tablayout.newTab().setIcon(android.R.drawable.ic_input_delete).setText("4"));

        // viewpager 설정
        pager = findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter( getSupportFragmentManager(  ) , tablayout.getTabCount(  ) );
        pager.setAdapter( adapter );

        // viewpager의 pagechange와 tablayout 연동 설정
        // viewpager스크롤 하면 tab도 같이 바뀌게 하는것
        pager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tablayout ) );

        // tablayout에 tab을 클릭했을때 바뀌게
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {  }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {  }
        });
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        private int tabCount;

        public PagerAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            this.tabCount = numberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Tab1Fragment();
                case 1:
                    return new Tab2Fragment();
                case 2:
                    return new Tab3Fragment();
                case 3:
                    return new Tab4Fragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return this.tabCount;
        }
    }
}
