package com.example.startactivityforresult2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button   btnback  = null;
    private TextView txt_view = null;

    private int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnback  = findViewById(R.id.btnback );
        txt_view = findViewById(R.id.txt_view);

        Intent i = getIntent();
        int p1 = i.getIntExtra("p1",-1 );
        int p2 = i.getIntExtra("p2",-1 );
        sum = p1 + p2;

        StringBuilder sb = new StringBuilder();
        sb.append("p1 : " + p1);
        sb.append("\n");
        sb.append("p2 : " + p2);

        txt_view.setText(sb.toString());

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sum값을 main으로 반환
                Intent data = new Intent();
                data.putExtra("sum",sum);
                setResult(RESULT_OK,data);

                finish();
            }
        });
    }
}