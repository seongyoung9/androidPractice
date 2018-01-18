package com.example.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    private TextView textview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        textview = findViewById(R.id.textview);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textview.setText( str );

    }
}
