package com.example.administrator.textattribute;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView editText1 = null;
    private TextView editText2 = null;
    private TextView editText3 = null;
    private TextView editText4 = null;
    private TextView editText5 = null;
    private TextView editText6 = null;
    private Button   button1   = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        editText6 = findViewById(R.id.editText6);

        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //타이틀 변경
                setTitle("속성 변경 후 : 타이핑");
                setTitle(R.string.app_name2);

                //text1 size 변경
                editText1.setTextSize(30);

                //text2 color변경
                editText2.setTextColor(Color.YELLOW);

                //text3 기울기 변경 ITALIC BOLD
                editText3.setTypeface(editText3.getTypeface(), Typeface.BOLD_ITALIC | Typeface.ITALIC);



            }
        });
    }
}
