package com.example.administrator.simplecalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;

    private EditText txt1 = null;
    private EditText txt2 = null;
    private EditText txtresult = null;

    Float num1 = null;
    Float num2 = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txtresult = findViewById(R.id.txtresult);

        button1 = findViewById(R.id.button1);
        ButtonClick handler = new ButtonClick();
        button1.setOnClickListener( handler );

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener( handler );

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener( handler );

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener( handler );

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener( handler );
    }

    private class ButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int id = view.getId();
            float atm = 0;
            if( txt1.getText().equals("") && txt2.getText().equals("")){
                Toast.makeText(getApplicationContext(),"숫자를 입력해 주세요",Toast.LENGTH_SHORT).show();
            }
            num1=Float.parseFloat(txt1.getText().toString());
            num2=Float.parseFloat(txt2.getText().toString());

            txtresult.setTextSize(50);
            txtresult.setTextColor(Color.RED);

            switch ( id ){
               // num1 = Integer.parseInt(txt1.getText().toString());   //첫번째 숫자
               // num2 = Integer.parseInt(txt2.getText().toString());   //두번째 숫자

                case R.id.button1:


                    atm =  num1 + num2;
                    txtresult.setText("계산결과 : " + String.valueOf(atm));
                    break;

                case R.id.button2:
                    atm = num1 - num2;
                    txtresult.setText("계산결과 : " + String.valueOf(atm));
                    break;

                case R.id.button3:
                    atm = num1 * num2;
                    txtresult.setText("계산결과 : " + String.valueOf(atm));
                    break;

                case R.id.button4:
                    if ( num1 = 0.0 ) {
                        Toast.makeText(getApplicationContext(),"0은 안됨",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        atm = num1 / num2;
                        txtresult.setText("계산결과 : " + String.valueOf(atm));
                        break;
                    }
                case R.id.button5:
                    atm = num1 % num2;
                    txtresult.setText("계산결과 : " + String.valueOf(atm));
                    break;
            }
        }
    }

}
