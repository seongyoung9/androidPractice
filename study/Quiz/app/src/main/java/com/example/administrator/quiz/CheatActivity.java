package com.example.administrator.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class CheatActivity extends AppCompatActivity {

    private TextView  cheating  ;
    private ImageView nocheating;
    private Button    btn_back  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        cheating   = findViewById(R.id.cheating  );
        nocheating = findViewById(R.id.nocheating);
        btn_back   = findViewById(R.id.btn_back  );

        Intent i = getIntent();
        boolean correct = i.getBooleanExtra("correct",true);

        cheating.setText( correct +"" );

        nocheating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nocheating.setVisibility(View.GONE);
                cheating.setVisibility(View.VISIBLE);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
