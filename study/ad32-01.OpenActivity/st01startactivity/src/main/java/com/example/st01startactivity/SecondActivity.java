package com.example.st01startactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private Button   btn_finish = null;
    private TextView textview   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_finish = findViewById(R.id.btn_finish);
        textview   = findViewById(R.id.textview  );

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  //SecondActivity종료
            }
        });

        Intent intent = getIntent();
        String val = intent.getStringExtra("val");   //val --> 1
        textview.setText( val );

    }
}
