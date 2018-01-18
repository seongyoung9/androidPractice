package com.example.administrator.basicwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //이벤트 핸들러 설정 선언 찾기 설정
        Button button1 = null;
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RadioActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }

        );
        Button button2 = null;
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),WidthButtonActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }
        );
        Button button3 = null;
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HeightButtonActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }

        );
        Button button4 = null;
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ColorButtonActivity.class);
                startActivity(i);  //새창 띄우기

            }
        }

        );
        Button button5 = null;
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MarginActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }

        );
        Button button6 = null;
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),PaddingActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }

        );
        Button button7 = null;
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),VisibleActivity.class);
                startActivity(i);  //새창 띄우기
            }
        }

        );
    }
}
