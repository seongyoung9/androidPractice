package com.example.administrator.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AddButtonActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnAdd5;
    private LinearLayout scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd5 = findViewById(R.id.btnAdd5);
        scroll = findViewById(R.id.scroll);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //step1. 추가되는 버튼에 대한 LayoutParam 설정, 뷰 영역 설정.


                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,     //가로
                        LinearLayout.LayoutParams.WRAP_CONTENT      //세로
                );
                //마진추가
                lp.setMargins(10,10,10,10);

                //step2. 버튼생성.
                Button btn = new Button(getApplicationContext());
                btn.setText("push me");
                btn.setLayoutParams( lp );//생성된 버튼의 뷰 영역 설정
                btn.setBackgroundColor(Color.DKGRAY);

                //step3. 생성된 버튼을 LinearLayout에 추가, View.addView메서드 사용.
                scroll.addView( btn );
            }
        });

        btnAdd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout.LayoutParams lp5 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                for (int i = 1; i <= 5 ; i++) {
                    Button bt5 = new Button(getApplicationContext());
                    bt5.setText("push"+i);
                    bt5.setLayoutParams(lp5);
                    bt5.setBackgroundColor(Color.RED);
                    scroll.addView(bt5);
                }
            }
        });
    }

}
