package com.example.senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        android.content.Intent i = getIntent();
        String str = i.getStringExtra( "name" );

        TextView textView = findViewById(R.id.textView);
        textView.setText( str );
    }
}
