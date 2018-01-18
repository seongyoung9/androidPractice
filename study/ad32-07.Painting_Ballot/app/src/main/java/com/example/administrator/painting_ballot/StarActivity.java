package com.example.administrator.painting_ballot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.content.Intent;

public class StarActivity extends AppCompatActivity {

    private RatingBar   star00,star01,star02,
                        star03,star04,star05,
                        star06,star07,star08;
    private ImageView   firstimage;
    private Button      btnback,btnimage;
    private float[] rating = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        star00 = findViewById(R.id.star00);
        star01 = findViewById(R.id.star01);
        star02 = findViewById(R.id.star02);
        star03 = findViewById(R.id.star03);
        star04 = findViewById(R.id.star04);
        star05 = findViewById(R.id.star05);
        star06 = findViewById(R.id.star06);
        star07 = findViewById(R.id.star07);
        star08 = findViewById(R.id.star08);
        btnback  = findViewById(R.id.btnback );
        btnimage = findViewById(R.id.btnimage);
        firstimage = findViewById(R.id.firstimage);

        Intent i = getIntent();
        rating = i.getFloatArrayExtra("rating");

        star00.setRating(rating[0]/2);
        star01.setRating(rating[1]/2);
        star02.setRating(rating[2]/2);
        star03.setRating(rating[3]/2);
        star04.setRating(rating[4]/2);
        star05.setRating(rating[5]/2);
        star06.setRating(rating[6]/2);
        star07.setRating(rating[7]/2);
        star08.setRating(rating[8]/2);

        ButtonClick buttonclick = new ButtonClick();
        btnback .setOnClickListener( buttonclick );
        btnimage.setOnClickListener( buttonclick );

    }

    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnback:
                    finish();
                    break;
                case R.id.btnimage:
                    float first = 0;
                    for (int i = 0; 0 < rating.length; i++){
                        if (first < rating[i]) {
                            first = rating[i];
                        }
                    }
                    break;
            }
        }
    }
}
