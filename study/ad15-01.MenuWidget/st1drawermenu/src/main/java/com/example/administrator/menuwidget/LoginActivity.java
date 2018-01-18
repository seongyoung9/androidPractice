package com.example.administrator.menuwidget;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private Button btnlogin;
    private TextView btnjoin;
    private EditText edtid;
    private EditText edtpw;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtid = findViewById(R.id.edtid);
        edtpw = findViewById(R.id.edtpw);
        btnlogin = findViewById(R.id.btnlogin);
        btnjoin = findViewById(R.id.btnjoin);

        pref = getSharedPreferences(CommonCode.FILE_PREFERENCE, MODE_PRIVATE);

        btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //정상 로그인
                if (edtid.getText().toString().trim().equals(pref.getString(CommonCode.LOGIN_ID,""))
                 && edtpw.getText().toString().trim().equals(pref.getString(CommonCode.LOGIN_PW,""))) {

                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString(CommonCode.LOGIN_ID, edtid.getText().toString());
                    //editor.putString("TEXT_PW",edtpw.getText().toString());
                    editor.putBoolean(CommonCode.LOGIN_STATUS, true);

                    editor.apply();  //저장

                    //추후코드 작성 결과 반환
                    Intent data = new Intent();
                    //intent에 반환값 저장하기
                    data.putExtra(CommonCode.LOGIN_STATUS,true);
                    //결과반환
                    setResult(RESULT_OK,data);

                    finish();   //화면 종료

                }//로그인 실패시
                else {
                    Toast.makeText(getApplicationContext(), R.string.login_fail, Toast.LENGTH_SHORT).show();
                }

            }
        });

        String idtxt = pref.getString(CommonCode.LOGIN_ID, "");

        edtid.setText(idtxt);

        btnjoin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Join_MembershipActivity.class);

                startActivity(i);

                finish();   //화면 종료
            }
        });
    }
}

