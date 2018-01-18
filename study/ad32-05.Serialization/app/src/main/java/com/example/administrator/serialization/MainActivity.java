package com.example.administrator.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        ButtonClick bclick = new ButtonClick();
        btn1.setOnClickListener( bclick );
        btn2.setOnClickListener( bclick );
        btn3.setOnClickListener( bclick );
        btn4.setOnClickListener( bclick );
        btn5.setOnClickListener( bclick );
    }

    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,SubActivity.class);

            switch (v.getId()){
                case R.id.btn1:
                    // 기본타입을 이용한 데이터 전달
                    i.putExtra("data","test");

                    break;
                case R.id.btn2:
                    // 배열을 이용한 데이터 전달
                    int[] array = {0,1,2,3,4,5,6,7,8};
                    i.putExtra("data", array);

                    break;
                case R.id.btn3:
                    // serializable을 이용한 데이터 전달   // Model클래스에 implements Serializable
                    ModelSerial serial = new ModelSerial(10,"serial");
                    i.putExtra("serial",serial);

                    break;
                case R.id.btn4:
                    // parcelable을 이용한 데이터 전달
                    ModelParcel parcel = new ModelParcel();
                    parcel.setIdata( 20 );
                    parcel.setSdata( "parcelable" );

                    i.putExtra("parcel",parcel);

                    break;
                case R.id.btn5:
                    // bundle을 이용한 데이터 전달
                    Bundle b = new Bundle();
                    b.putInt("idata",30);
                    b.putString("sdata","bundle");

                    i.putExtra("bundle",b);

                    break;
            }

            startActivity( i );//i를 포함한 새창 띄우기
        }
    }
}
