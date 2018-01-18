package com.example.st2preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button   btnSave  ;
    private EditText edtNum   ;
    private EditText edtText  ;
    private CheckBox chkSound ;
    private SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSave  = findViewById(R.id.btnSave);
        edtNum   = findViewById(R.id.edtnum);
        edtText  = findViewById(R.id.edtText);
        chkSound = findViewById(R.id.ckbSound);
        
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean( "SOUND_SET" ,  chkSound.isChecked());
                editor.putInt("TEXT_NUMBER", Integer.parseInt(edtNum.getText().toString()));
                editor.putString("TEXT_STRING",edtText.getText().toString());

                editor.apply();  //저장
                
            }
        });
        
        
        //preference객체 얻기
        pref = getSharedPreferences("Settings",MODE_PRIVATE);
        Boolean chk = pref.getBoolean("SOUND_SET",false);
        Integer number = pref.getInt("TEXT_NUMBER",-1);
        String txt = pref.getString("TEXT_STRING","");

        chkSound.setChecked(chk);
        edtNum.setText(number.toString());
        edtText.setText(txt);

    }
}
