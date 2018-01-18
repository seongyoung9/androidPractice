package com.example.startactivityforresult2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MAIN = 10000;  //임의값 아무거나 정하면 됨

    private EditText edtnum1 = null;
    private EditText edtnum2 = null;
    private Button   btnsend = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnum1 = findViewById(R.id.edtnum1);
        edtnum2 = findViewById(R.id.edtnum2);
        btnsend = findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                i.putExtra("p1",Integer.valueOf( edtnum1.getText().toString().isEmpty() ? "0" : edtnum1.getText().toString() ) );
                i.putExtra("p2",Integer.valueOf( edtnum2.getText().toString().isEmpty() ? "0" : edtnum2.getText().toString() ) );

                //새창띄우기
                startActivityForResult( i , REQUEST_CODE_MAIN );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (MainActivity.REQUEST_CODE_MAIN == requestCode && resultCode == RESULT_OK){
            // SecondActivity 에서 넘겨준 값
            int sum = data.getIntExtra("sum",-1);

            AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("계산결과");
            ad.setIcon(R.mipmap.ic_launcher);
            ad.setMessage("합계는 : " + sum + "입니다.");
            ad.setPositiveButton("확인",null);
            ad.show();

            /*Toast.makeText(MainActivity.this,sum,Toast.LENGTH_SHORT).show();*/
        }
    }
}
