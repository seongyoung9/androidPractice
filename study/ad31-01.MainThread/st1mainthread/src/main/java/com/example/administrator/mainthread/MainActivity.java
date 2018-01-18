package com.example.administrator.mainthread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView textView = null;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        handler = new Handler();

        Thread countthread = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count++;
                    Log.i("sutperdroid", "Current Count : " + count);
                    try {
                        Runnable message = new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Count : " + count);
                            }
                        };
                        // 메인 쓰레드의 messageQueue에 넣어준다
                        //handler.post(message);
                        //textView.post(message);
                        MainActivity.this.runOnUiThread( message );

                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        countthread.start();           //thread 시작

    }
}
