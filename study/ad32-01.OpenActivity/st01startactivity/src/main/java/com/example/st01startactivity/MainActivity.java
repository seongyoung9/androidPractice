package com.example.st01startactivity;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1 = null;
    private Button btn2 = null;
    private Button btn3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonClickHandler btnclick = new ButtonClickHandler();
        btn1.setOnClickListener( btnclick );
        btn2.setOnClickListener( btnclick );
        btn3.setOnClickListener( btnclick );
    }

    private class ButtonClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId()){
                case R.id.btn1:

                    intent = new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtra("val","1");
                    startActivity( intent );//새창

                    break;
                case R.id.btn2:

                    intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("val","2");
                    startActivity( intent );//새창

                    break;
                case R.id.btn3:

                    ComponentName comname = new ComponentName("com.example.st01startactivity",
                            "com.example.st01startactivity.SecondActivity");

                    intent = new Intent();
                    intent.setComponent( comname );
                    intent.putExtra("val","3");
                    startActivity( intent );//새창
                    break;
            }
        }
    }
}
