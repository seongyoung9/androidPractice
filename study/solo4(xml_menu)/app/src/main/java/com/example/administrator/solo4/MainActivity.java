package com.example.administrator.solo4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout baseLayout;
    private Button       btn1      ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");

        baseLayout = findViewById(R.id.baseLayout);
        btn1       = findViewById(R.id.btn1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.itemred:
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.itemblue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.itemgreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.subRotate:
                btn1.setRotation(45);
                return true;

            case R.id.subSize:
                btn1.setScaleX(2);
                return true;
        }

        return false;
    }
}
