package com.example.administrator.menuwidget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CODE_LOGIN = 0;
    private SharedPreferences pref;

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

        pref = getSharedPreferences(CommonCode.FILE_PREFERENCE, MODE_PRIVATE);
        boolean loginstatus = pref.getBoolean(CommonCode.LOGIN_STATUS, false);
        if (loginstatus == false){
            setShowHideNavigation(loginstatus);
        }
        else{
            setShowNavigation(loginstatus);
        }
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
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {

            Intent i = new Intent(MainActivity.this, LoginActivity.class);

            startActivityForResult(i, REQUEST_CODE_LOGIN);

        } else if (id == R.id.nav_logout) {

            NavigationView navView = findViewById(R.id.nav_view);
            if (navView != null) {

                Menu menu = navView.getMenu();
                menu.findItem(R.id.nav_login   ).setVisible(true);
                menu.findItem(R.id.nav_logout  ).setVisible(false);
                menu.findItem(R.id.nav_register).setVisible(true);
                menu.findItem(R.id.nav_memedit ).setVisible(false);

                pref = getSharedPreferences(CommonCode.FILE_PREFERENCE, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean(CommonCode.LOGIN_STATUS, false);
                editor.apply();//저장
            }

        } else if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_register){

            Intent i = new Intent(MainActivity.this, Join_MembershipActivity.class);

            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        //requestCode == REQUEST_CODE_LOGIN
        //resultCode == RESULT_OK  정해져있음
        //data == 처리된 결과값

        //결과확인
        if (requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK) {
            //로그인이 되었을때
            boolean loginStatus = data.getBooleanExtra(CommonCode.LOGIN_STATUS, false);

            //menu보이고 감추기
            setShowNavigation(loginStatus);

        }
    }

    private void setShowNavigation(boolean loginStatus) {
        NavigationView navView = findViewById(R.id.nav_view);
        if (navView != null && loginStatus == true) {

            Menu menu = navView.getMenu();
            menu.findItem(R.id.nav_login   ).setVisible(false);
            menu.findItem(R.id.nav_logout  ).setVisible(true);
            menu.findItem(R.id.nav_register).setVisible(false);
            menu.findItem(R.id.nav_memedit ).setVisible(true);

        }
    }
    //flaglogin : 로그인이 안되어있으면 false 인자로
    //            로그인이 되어있으면 true를 인자로 받는다.
    private void setShowHideNavigation(boolean flagLogin) {
        NavigationView navView = findViewById(R.id.nav_view);
        if (navView != null) {
            Menu menu = navView.getMenu();
            menu.findItem(R.id.nav_login).setVisible(true);
            menu.findItem(R.id.nav_logout).setVisible(false);
            menu.findItem(R.id.nav_register).setVisible(true);
            menu.findItem(R.id.nav_memedit).setVisible(false);
        }
    }
}
