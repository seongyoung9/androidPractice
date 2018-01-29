package com.example.bbs.article;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.bbs.AppConstans;
import com.example.bbs.R;
import com.example.bbs.fragment.FragmentArticleData;
import com.example.bbs.fragment.FragmentArticleQna;
import com.example.bbs.fragment.FragmentAticleFree;

public class ArticleActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArticlePagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTabLayout = findViewById( R.id.tab_layout );
        mTabLayout.addTab( mTabLayout.newTab().setIcon( android.R.drawable.ic_dialog_email  ) );
        mTabLayout.addTab( mTabLayout.newTab().setIcon( android.R.drawable.ic_dialog_dialer ) );
        mTabLayout.addTab( mTabLayout.newTab().setIcon( android.R.drawable.ic_dialog_map    ) );

        mViewPager = findViewById( R.id.view_pager );
        mAdapter = new ArticlePagerAdapter( getSupportFragmentManager(), mTabLayout.getTabCount() );
        mViewPager.setAdapter( mAdapter );

        // viewpager와 tablayout연결 둘다 같이 바뀌게
        mViewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( mTabLayout ));
        mViewPager.setOffscreenPageLimit( mAdapter.getCount() - 1 );

        // tablayout와 viewpager연결  둘다 같이 바뀌게
        mTabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem( tab.getPosition() );
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private class ArticlePagerAdapter extends FragmentPagerAdapter{

        private final int mTabCount;

        public ArticlePagerAdapter(FragmentManager fm , int numberOfTabs ) {
            super(fm);
            this.mTabCount = numberOfTabs;
        }
        @Override
        public int getCount() {
            return mTabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch ( position ){
                case 0:
                    return FragmentArticleQna.newInstance(AppConstans.TITLE_ARTICLE_QNA,  "");
                case 1:
                    return FragmentAticleFree.newInstance(AppConstans.TITLE_ARTICLE_FREE, "");
                case 2:
                    return FragmentArticleData.newInstance(AppConstans.TITLE_ARTICLE_DATA,"");
                default:
                    return null;
            }

        }

    }
}
