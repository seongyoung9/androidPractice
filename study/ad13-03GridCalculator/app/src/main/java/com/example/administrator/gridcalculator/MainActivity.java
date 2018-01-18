package com.example.administrator.gridcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTxt = null;
    private Button bt1 = null;
    private Button bt2 = null;
    private Button bt3 = null;
    private Button bt4 = null;
    private Button bt5 = null;
    private Button bt6 = null;
    private Button bt7 = null;
    private Button bt8 = null;
    private Button bt9 = null;
    private Button bt0 = null;
    private Button btdot = null;
    private Button btpm = null;
    private Button btac = null;
    private Button btc = null;
    private Button bte = null;
    private Button bt90 = null;
    private Button btplus = null;
    private Button btminus = null;
    private Button btmul = null;
    private Button btdiv = null;
    private Button btlist = null;
    private Button btsave = null;
    private Button btcur = null;

    private String txt = "";
    private String doubleno = "";
    private Integer leng = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.edittext);
        editTxt.setInputType(0);
        editTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String infixExp = txt;

                Calc c = new Calc();

                String[] array = {"+","-","×","÷"};

                int cnt = c.getLastIndex(infixExp, array);

                int x = infixExp.length()-cnt-1;
                if(x >= 17){
                    leng = txt.length();
                    Toast.makeText(getApplicationContext(),"잘못입력",Toast.LENGTH_SHORT).show();
                    txt = txt.substring(0,leng-1);
                }

            }
        });

        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "1";
                editTxt.setText(txt);
            }
        });

        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "2";
                editTxt.setText(txt);
            }
        });

        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "3";
                editTxt.setText(txt);
            }
        });

        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "4";
                editTxt.setText(txt);
            }
        });

        bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "5";
                editTxt.setText(txt);
            }
        });

        bt6 = findViewById(R.id.bt6);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "6";
                editTxt.setText(txt);
            }
        });

        bt7 = findViewById(R.id.bt7);
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "7";
                editTxt.setText(txt);
            }
        });

        bt8 = findViewById(R.id.bt8);
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "8";
                editTxt.setText(txt);
            }
        });

        bt9 = findViewById(R.id.bt9);
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "9";
                editTxt.setText(txt);
            }
        });

        bt0 = findViewById(R.id.bt0);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + "0";
                editTxt.setText(txt);
            }
        });

        btdot = findViewById(R.id.btdot);
        btdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = txt + ".";
                editTxt.setText(txt);
            }
        });

        btplus = findViewById(R.id.btplus);
        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을입력하세요",Toast.LENGTH_LONG).show();
                }
                else{
                    leng = txt.length();
                    doubleno = txt.substring(leng-1,leng);
                    if(doubleno.contains("+")||doubleno.contains("-")||doubleno.contains("\u00D7")||doubleno.contains("\u00F7")){
                        txt = txt.substring(0,leng-1) + "+";
                        editTxt.setText(txt);
                    }
                    else {
                        txt = txt + "+";
                        editTxt.setText(txt);
                    }
                }
            }
        });

        btminus = findViewById(R.id.btmunus);
        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을입력하세요",Toast.LENGTH_LONG).show();
                }
                else {
                    leng = txt.length();
                    doubleno = txt.substring(leng-1,leng);
                    if (doubleno.contains("+") || doubleno.contains("-") || doubleno.contains("\u00D7") || doubleno.contains("\u00F7")) {
                        txt = txt.substring(0, leng - 1) + "-";
                        editTxt.setText(txt);
                    } else {
                        txt = txt + "-";
                        editTxt.setText(txt);
                    }
                }
            }
        });

        btmul = findViewById(R.id.btmul);
        btmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을입력하세요",Toast.LENGTH_LONG).show();
                }
                else {
                    leng = txt.length();
                    doubleno = txt.substring(leng-1,leng);
                    if (doubleno.contains("+") || doubleno.contains("-") || doubleno.contains("\u00D7") || doubleno.contains("\u00F7")) {
                        txt = txt.substring(0, leng - 1) + "\u00D7";
                        editTxt.setText(txt);
                    } else {
                        txt = txt + "\u00D7";
                        editTxt.setText(txt);
                    }
                }
            }
        });

        btdiv = findViewById(R.id.btdiv);
        btdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을입력하세요",Toast.LENGTH_LONG).show();
                }
                else {
                    leng = txt.length();
                    doubleno = txt.substring(leng-1,leng);
                    if (doubleno.contains("+") || doubleno.contains("-") || doubleno.contains("\u00D7") || doubleno.contains("\u00F7")) {
                        txt = txt.substring(0, leng - 1) + "\u00F7";
                        editTxt.setText(txt);
                    } else {
                        txt = txt + "\u00F7";
                        editTxt.setText(txt);
                    }
                }
            }
        });

        btac = findViewById(R.id.btac);
        btac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = "";
                editTxt.setText(txt);
            }
        });

        btc = findViewById(R.id.btc);
        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int leng = txt.length();
                txt = txt.substring(0,leng-1);
                editTxt.setText(txt);
            }
        });

        bt90 = findViewById(R.id.bt90);
        bt90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leng = txt.length();
                doubleno = txt.substring(leng-1,leng);

            }
        });

        bte = findViewById(R.id.bte);
        bte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을입력하세요",Toast.LENGTH_LONG).show();
                }
                else {
                    if (txt.contains("\u00D7")){
                        txt = txt.replace("\u00D7","*");
                    }
                    if (txt.contains("\u00F7")){
                        txt = txt.replace("\u00F7","/");
                    }
                    String infixExp = txt;
                    System.out.println("중위 표기법 " + infixExp );

                    Calc c = new Calc();

                    // 수식 검증
                    if (!c.bracketsBalance(infixExp)) {
                        System.out.println("괄호를 정확히 하세요~");
                        System.exit(1);
                    }

                    // 중위 표기법을 후위 표기법으로 바꾸기
                    String postfixExp = c.postfix(infixExp);
                    System.out.println("후위 표기법 : " + postfixExp);

                    // 후위 표기법을 이용하여 수식 계산
                    Double result = c.result(postfixExp);

                    // 결과 출력
                    System.out.println("The result = " + result);
                    txt = String.valueOf(result);
                    editTxt.setText(txt);
                }
            }
        });
    }



}
