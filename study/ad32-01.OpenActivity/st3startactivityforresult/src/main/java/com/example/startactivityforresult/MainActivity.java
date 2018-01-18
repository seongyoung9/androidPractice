package com.example.startactivityforresult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText edttext;
    private Button   btn1   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edttext = findViewById( R.id.edttext );
        btn1    = findViewById( R.id.btn1    );

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edttext.getText().toString();
                Intent intent = new Intent(MainActivity.this,BActivity.class );
                intent.putExtra("name", str );
                startActivity( intent );
            }
        });
    }
}
