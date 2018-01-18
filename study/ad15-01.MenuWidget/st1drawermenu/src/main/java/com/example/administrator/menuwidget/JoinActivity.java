package com.example.administrator.menuwidget;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {


    private EditText txtemail  ;
    private EditText txtpw     ;
    private EditText txtpwch   ;
    private Button   btnlogingo;
    private TextView chch      ;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        txtemail   = findViewById(R.id.txtemail);
        txtpw      = findViewById(R.id.txtpw);
        txtpwch    = findViewById(R.id.txtpwch);
        btnlogingo = findViewById(R.id.btnlogingo);
        chch       = findViewById(R.id.chch);

        btnlogingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwtxt = txtpw.getText().toString();
                String pwchtxt = txtpwch.getText().toString();
                if (pwtxt.equals(pwchtxt) && pwtxt != ""){

                    chch.setVisibility(View.GONE);

                    pref = getSharedPreferences(CommonCode.FILE_PREFERENCE, MODE_PRIVATE);
                    SharedPreferences.Editor edit = pref.edit();

                    edit.putString(CommonCode.LOGIN_ID,txtemail.getText().toString());
                    edit.putString(CommonCode.LOGIN_PW,txtpw.getText().toString());

                    edit.apply();  //저장

                    Intent i = new Intent(JoinActivity.this, LoginActivity.class);

                    startActivity(i);

                    finish();   //화면 종료

                }
                else{
                    chch.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
