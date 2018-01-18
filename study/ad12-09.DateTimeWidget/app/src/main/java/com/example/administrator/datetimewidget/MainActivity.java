package com.example.administrator.datetimewidget;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AnalogClock  aclock1       = null;
    private DigitalClock dclock2       = null;
    private Chronometer  chronometer1  = null;
    private TimePicker   timePicker1   = null;
    private TimePicker   timePicker2   = null;
    private DatePicker   datePicker1   = null;
    private DatePicker   datePicker2   = null;
    private CalendarView calendarView1 = null;
    private Button       btn1          = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aclock1       = findViewById(R.id.aclock1);
        dclock2       = findViewById(R.id.dclock2);
        chronometer1  = findViewById(R.id.chronometer1);
        timePicker1   = findViewById(R.id.timepicker1);
        timePicker2   = findViewById(R.id.timepicker2);
        datePicker1   = findViewById(R.id.datepicker1);
        datePicker2   = findViewById(R.id.datepicker2);
        calendarView1 = findViewById(R.id.calendarview1);
        btn1          = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = "";
                msg += " aclock1       = " + aclock1.toString() + " \n";
                msg += " dclock2       = " + dclock2.getText() + " \n";
                msg += " chronometer1  = " + chronometer1.getText() + " \n";
                msg += " timePicker1   = " + timePicker1.getCurrentHour() + timePicker1.getCurrentMinute() + " \n";
                msg += " timePicker2   = " + timePicker2.getCurrentHour() + timePicker2.getCurrentMinute() + " \n";;
                msg += " datePicker1   = " + datePicker1.getYear() + datePicker1.getMonth() + datePicker1.getDayOfMonth() + " \n";
                msg += " datePicker2   = " + datePicker2.getYear() + datePicker2.getMonth() + datePicker2.getDayOfMonth() + " \n";
                msg += " calendarView1 = " + calendarView1.getDate();



                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
        //chronometer중지&시작
        chronometer1.stop();     //중지
        chronometer1.setBase(SystemClock.elapsedRealtime());    //0부터 시작해서 경과된 시간
        chronometer1.start();    //시작

        //timePicker1에 시간 설정하기
        timePicker1.setCurrentHour(13);
        timePicker1.setCurrentMinute(35);

        //datePicker1에 날짜 설정하기
        //자바에서 날짜를 처리하는 클래스
        //java.util.Date
        //java.util.Calendar
        java.util.Calendar c = Calendar.getInstance();

        datePicker1.updateDate(2017
                             , 11
                             , 14);

        //calendarView1에 날짜 설정하기
        Date date = null;
        date = new Date(114,2,18);
        calendarView1.setDate(date.getTime());


    }
}
