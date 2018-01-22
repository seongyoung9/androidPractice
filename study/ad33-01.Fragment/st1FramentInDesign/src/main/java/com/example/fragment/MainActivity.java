package com.example.fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById( R.id.btn_image0 );
        btn1 = findViewById( R.id.btn_image1 );
        btn2 = findViewById( R.id.btn_image2 );

        ButtonClick bclick = new ButtonClick();

        btn0.setOnClickListener( bclick );
        btn1.setOnClickListener( bclick );
        btn2.setOnClickListener( bclick );
    }

    private class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            // Fragment 찾기

            FragmentThr fragment = ( FragmentThr )getSupportFragmentManager().findFragmentById(R.id.fragmentthr);

            switch (v.getId()){
                case R.id.btn_image0:
                    fragment.update( 0 );
                    break;
                case R.id.btn_image1:
                    fragment.update( 1 );
                    break;
                case R.id.btn_image2:
                    fragment.update( 2 );
                    break;
            }
        }
    }
}
