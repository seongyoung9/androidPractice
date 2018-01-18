package com.example.progressbar;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1 ;
    private Button      btnInc       ;
    private Button      btnDec       ;
    private Button      button1      ;
    private SeekBar     seekBar1     ;
    private SeekBar     pb1          ;
    private SeekBar     pb2          ;
    private TextView    tvSeek       ;
    private TextView    tv1          ;
    private TextView    tv2          ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1 );
        btnInc       = findViewById(R.id.btnInc       );
        btnDec       = findViewById(R.id.btnDec       );
        seekBar1     = findViewById(R.id.seekBar1     );
        tvSeek       = findViewById(R.id.tvSeek       );
        tv1          = findViewById(R.id.tv1          );
        tv2          = findViewById(R.id.tv2          );
        pb1          = findViewById(R.id.pb1          );
        pb2          = findViewById(R.id.pb2          );
        button1      = findViewById(R.id.button1      );

        ButtonListener btnlistener = new ButtonListener();
        btnDec.setOnClickListener ( btnlistener );
        btnInc.setOnClickListener ( btnlistener );
        button1.setOnClickListener( btnlistener );

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행률 : " + progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnDec:
                    progressBar1.incrementProgressBy(-10);
                    break;
                case R.id.btnInc:
                    progressBar1.incrementProgressBy( 10);
                    break;
                case R.id.button1:

                    Thread th1 = new Thread(){
                        @Override
                        public void run() {
                            for (int i = pb1.getProgress(); i <= pb1.getMax(); i = i+2){

                                Runnable message = new Runnable() {

                                    @Override
                                    public void run() {
                                        pb1.setProgress( pb1.getProgress() + 2);
                                        tv1.setText("1번 진행률 : " + pb1.getProgress() + " %");
                                    }
                                };
                                // MainThread 에 message전송
                                MainActivity.this.runOnUiThread( message );
                                // delay추가
                                SystemClock.sleep(100);
                            }
                        }
                    };
                    th1.start();

                    Thread th2 = new Thread(){
                        @Override
                        public void run() {
                            for (int i = pb2.getProgress(); i <= pb2.getMax(); i = i+1){

                                Runnable message = new Runnable() {

                                    @Override
                                    public void run() {
                                        pb2.setProgress( pb2.getProgress() + 1);
                                        tv2.setText("2번 진행률 : " + pb2.getProgress() + " %");
                                    }
                                };
                                // MainThread 에 message전송
                                MainActivity.this.runOnUiThread( message );
                                // delay추가
                                SystemClock.sleep(100);
                            }
                        }
                    };
                    th2.start();



                    break;
            }
        }
    }
}
