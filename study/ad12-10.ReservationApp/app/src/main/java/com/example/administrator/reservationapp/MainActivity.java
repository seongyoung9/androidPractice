package com.example.administrator.reservationapp;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

   private Chronometer chrono         = null;
   private Button      btnstart       = null;
   private RadioButton rddate         = null;
   private RadioButton rdtime         = null;
   private DatePicker  datereser      = null;
   private TimePicker  timereser      = null;
   private Button      btnend         = null;
   private TextView    txtdatereser   = null;
   private TextView    txttimereser   = null;
   private RadioGroup  rgrd           = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono    = findViewById(R.id.chrono);
        btnstart  = findViewById(R.id.btnstart);
        rddate    = findViewById(R.id.rddate);
        rdtime    = findViewById(R.id.rdtime);
        datereser = findViewById(R.id.datereser);
        timereser = findViewById(R.id.timereser);
        btnend    = findViewById(R.id.btnend);
        txtdatereser  = findViewById(R.id.txtdatereser);
        txttimereser = findViewById(R.id.txttimereser);
        rgrd = findViewById(R.id.rdrg);

        //예약 시작 버튼
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chrono.setBase(SystemClock.elapsedRealtime());    //0부터 시작해서 경과된 시간
                chrono.start();    //시작
                rgrd.setVisibility(View.VISIBLE);


                //날짜설정버튼 눌렀을때
                rddate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b == true){
                            datereser.setVisibility(View.VISIBLE);
                            timereser.setVisibility(View.GONE);
                        }
                    }
                });

                //시간설정버튼 눌렀을때
                rdtime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b == true){
                            timereser.setVisibility(View.VISIBLE);
                            datereser.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        //예약 종료버튼
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String datemsg = "예약날짜 : ";
                String timemsg = "예약시간 : ";

                datemsg += datereser.getYear()+"년 "+(datereser.getMonth()+1)+"월 "+datereser.getDayOfMonth()+"일";
                timemsg += timereser.getCurrentHour()+"시  "+timereser.getCurrentMinute()+"분";

                txtdatereser.setText(datemsg);
                txttimereser.setText(timemsg);

                txtdatereser.setVisibility(View.VISIBLE);
                txttimereser.setVisibility(View.VISIBLE);
                timereser.setVisibility(View.GONE);
                datereser.setVisibility(View.GONE);
                chrono.stop();     //중지
                rgrd.setVisibility(View.GONE);
            }
        });
    }
}
