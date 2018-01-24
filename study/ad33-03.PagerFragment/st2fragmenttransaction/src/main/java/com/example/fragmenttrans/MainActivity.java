package com.example.fragmenttrans;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private ViewPager pager ;
    private static final String FRAGMENT_TAG_ZERO = "ZERO";
    private static final String FRAGMENT_TAG_ONE  = "ONE" ;
    private static final String FRAGMENT_TAG_TWO  = "TWO" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonClick bclick = new ButtonClick();
        btn1.setOnClickListener( bclick );
        btn2.setOnClickListener( bclick );
        btn3.setOnClickListener( bclick );

        PagerAdapter pa = new PagerAdapter(MainActivity.this);
        pager.setAdapter( pa );

    }

    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:



                    break;
                case R.id.btn2:

                    break;
                case R.id.btn3:

                    break;
            }
        }
    }

    private class PagerAdapter extends android.support.v4.view.PagerAdapter{

        LayoutInflater inflater = null;

        public PagerAdapter(Context context ) {

            inflater = LayoutInflater.from( context );
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
