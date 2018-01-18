package com.example.administrator.menuwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.Intent;

public class Join_MembershipActivity extends AppCompatActivity {

    private Button   btngo   ;
    private CheckBox chkagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join__membership);

        btngo    = findViewById(R.id.btngo);
        chkagree = findViewById(R.id.chkagree);

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkagree.isChecked() == false){
                    Toast.makeText(getApplicationContext(),"동의를 해주세요",Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent i = new Intent(getApplication(), JoinActivity.class);

                    startActivity(i);

                    finish();   //화면 종료
                }
            }
        });

    }
}
