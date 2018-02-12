package com.example.st1drawermenu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.st1drawermenu.AppBar.AppBarMainActivity;
import com.example.st1drawermenu.AppBar.SearchActivity;
import com.example.st1drawermenu.Fragment.Tab2.Tab2Fragment;
import com.example.st1drawermenu.Fragment.Tab1.Tab1Fragment;
import com.example.st1drawermenu.Fragment.Tab3Fragment;
import com.example.st1drawermenu.Fragment.Tab4Fragment;
import com.example.st1drawermenu.LoginPackage.CommonCode;
import com.example.st1drawermenu.LoginPackage.LoginActivity;
import com.example.st1drawermenu.LoginPackage.RegisterActivity;
import com.example.st1drawermenu.LoginPackageSpring.LoginSpringActivity;
import com.example.st1drawermenu.PayMenu.PayMenuActivity;

public class MainActivity extends AppBarMainActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // 상수 
    private static final int REQUEST_CODE_LOGIN = 9999;
    private static final int REQUEST_CODE_REGISTER = 9999;

    private ViewPager pager;
    private TabLayout tabLayout;

    private ImageView main_logo;
    private ImageView cart;
    private ImageView search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Preference 객체 얻기. 파일이름은 Settings.xml
        SharedPreferences pref = getSharedPreferences( CommonCode.FILE_PREFERECE, MODE_PRIVATE);
        boolean loginStatus = pref.getBoolean( CommonCode.LOGIN_STATUS, false);
        setShowHideNavigation( loginStatus );

        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_email).setText("기브빈"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_dialer).setText("메뉴"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_dialog_map).setText("친구"));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.ic_menu_add).setText("더보기"));

        //ViewPager설정
        pager = findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(adapter);

        //ViewPager의 PagerChange와 TabLayout연동 설정
        //ViewPager를 스크롤하면 Tab도 같이 바뀌게 하는 설정.

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //TabLayout에서 Tab를 클릭하면
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        main_logo = findViewById(R.id.main_logo);
        main_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "메인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기

            }
        });

        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "장바구니로 이동합니다.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), PayMenuActivity.class);
                startActivity(i); //새창 띄우기

            }
        });

        search_button = findViewById(R.id.search_button);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "검색창으로 이동합니다.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(i); //새창 띄우기

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_pref) {
            return true;
        } else if (id == R.id.action_pref2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            // 새창 띄우기
            Intent i = new Intent( /* context */ MainActivity.this  ,  /* class 이름 */ LoginActivity.class);
            startActivityForResult( i, REQUEST_CODE_LOGIN );

        } else if (id == R.id.nav_login_spring) {
            Intent i = new Intent( MainActivity.this , LoginSpringActivity.class);
            startActivity( i );
        }
        else if (id == R.id.nav_register) {
            // 새창 띄우기
            Intent i = new Intent( /* context */ MainActivity.this  ,  /* class 이름 */ RegisterActivity.class);
            startActivityForResult( i, REQUEST_CODE_REGISTER);
        }
        else if (id == R.id.nav_manage) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode == REQUEST_CODE_LOGIN
        // resultCode  == RESULT_OK
        // data   == 처리된 결과 정보가 들어 있다.

        // 결과 확인
        if( requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK ){
            // 로그인에 성공했을 때.
            boolean loginStatus = data.getBooleanExtra(CommonCode.LOGIN_STATUS, false);
            // menu 보이고 감추기..
            NavigationView navView = findViewById(R.id.nav_view);
            setShowHideNavigation( true );

        }
    }

    /**
     *
     * @param isVisible : 로그인이 안되어 있으면 false 인자로
     *                    로그인이 되어 있는 true를 인자로 받는다.
     */
    private void setShowHideNavigation(boolean isVisible) {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        if (navView != null) {
            Menu menu = navView.getMenu();
            menu.findItem(R.id.nav_login   ).setVisible(!isVisible);
            menu.findItem(R.id.nav_register).setVisible(!isVisible);
            menu.findItem(R.id.nav_logout  ).setVisible( isVisible);
            menu.findItem(R.id.nav_memedit ).setVisible( isVisible);
        }
    }



    private class PagerAdapter extends FragmentPagerAdapter {

        private int tabCount ;
        public PagerAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);

            this.tabCount = numberOfTabs;
        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {

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
