package com.example.administrator.scroll;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {


    private ScrollView   scroll;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = findViewById(R.id.scroll);
        layout = findViewById(R.id.layout);

        //설정 ScrollView.OnScrollChangedListener 작성
        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,     //가로
                        LinearLayout.LayoutParams.WRAP_CONTENT      //세로
                );
                //바닥 조건 : layout.getHeight() == scroll.getScrollY() + scroll.getHeight()
                if(layout.getHeight() == scroll.getScrollY() + scroll.getHeight()) {

                    for (int i = 1; i <= 5; i++) {
                        Button btn = new Button(getApplicationContext());
                        btn.setText("push me"+i);
                        btn.setLayoutParams(lp);//생성된 버튼의 뷰 영역 설정
                        btn.setBackgroundColor(Color.BLUE);
                        layout.addView(btn);
                    }
                }
            }
        });
    }
}
