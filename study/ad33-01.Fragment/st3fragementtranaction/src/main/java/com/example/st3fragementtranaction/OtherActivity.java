package com.example.st3fragementtranaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class OtherActivity extends AppCompatActivity {

    private Button   btn;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = edit.getText().toString();

                Intent i = new Intent();
                i.putExtra( Common.OTHER_MSG ,msg);

                setResult( RESULT_OK , i );

                finish();

            }
        });
    }
}
