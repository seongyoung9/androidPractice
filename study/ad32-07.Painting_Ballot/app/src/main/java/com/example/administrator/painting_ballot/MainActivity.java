package com.example.administrator.painting_ballot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView   mov00,mov01,mov02,
                        mov03,mov04,mov05,
                        mov06,mov07,mov08;
    private Button      btngo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mov00 = findViewById(R.id.mov0);
        mov01 = findViewById(R.id.mov1);
        mov02 = findViewById(R.id.mov2);
        mov03 = findViewById(R.id.mov3);
        mov04 = findViewById(R.id.mov4);
        mov05 = findViewById(R.id.mov5);
        mov06 = findViewById(R.id.mov6);
        mov07 = findViewById(R.id.mov7);
        mov08 = findViewById(R.id.mov8);
        btngo = findViewById(R.id.btngo);

        Intent i = new Intent();

        MovClick click = new MovClick();
        mov00.setOnClickListener( click );
        mov01.setOnClickListener( click );
        mov02.setOnClickListener( click );
        mov03.setOnClickListener( click );
        mov04.setOnClickListener( click );
        mov05.setOnClickListener( click );
        mov06.setOnClickListener( click );
        mov07.setOnClickListener( click );
        mov08.setOnClickListener( click );
        btngo.setOnClickListener( click );
    }

    private class MovClick implements View.OnClickListener{
        private float[] rating = new float[10];

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.mov0:
                    rating[0] += 1;
                    Toast.makeText(MainActivity.this,"월E 총 " + rating[0] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov1:
                    rating[1]++;
                    Toast.makeText(MainActivity.this,"써니 총 " + rating[1] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov2:
                    rating[2]++;
                    Toast.makeText(MainActivity.this,"완득이 총 " + rating[2] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov3:
                    rating[3]++;
                    Toast.makeText(MainActivity.this,"괴물 총 " + rating[3] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov4:
                    rating[4]++;
                    Toast.makeText(MainActivity.this,"라디오스타 총 " + rating[4] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov5:
                    rating[5]++;
                    Toast.makeText(MainActivity.this,"비열한거리 총 " + rating[5] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov6:
                    rating[6]++;
                    Toast.makeText(MainActivity.this,"왕의남자 총 " + rating[6] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov7:
                    rating[7]++;
                    Toast.makeText(MainActivity.this,"아일랜드 총 " + rating[7] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mov8:
                    rating[8]++;
                    Toast.makeText(MainActivity.this,"웰컴투동막골 총 " + rating[8] + "표",
                                            Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btngo:
                    Intent i = new Intent(MainActivity.this,StarActivity.class);
                    i.putExtra("rating",rating);
                    startActivity( i );
                    break;
            }
        }

    }
}
