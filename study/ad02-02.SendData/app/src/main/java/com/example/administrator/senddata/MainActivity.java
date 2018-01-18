package com.example.administrator.senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1. 위젯 선언
    private EditText edtname = null;
    private Button btsend = null;
    private TextView txtname = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //2. 위젯 찾기
        edtname = findViewById(R.id.edtname);
        btsend = findViewById(R.id.btsend);
        txtname = findViewById(R.id.txtname);

        //3. 위젯 설정
        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //1. edtname에서 값 가져오기
                String tmp = edtname.getText().toString();

                //2. txtname에 값을 설정하기
                txtname.setText( tmp );
            }
        });

    }
}
