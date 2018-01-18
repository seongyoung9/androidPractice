package com.example.administrator.solo5_toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("토스트 연습");

        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tmsg;
                tmsg = Toast.makeText(getApplicationContext(),"토스트 연습",Toast.LENGTH_SHORT);

                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                int xoffset = (int)(Math.random() * display.getWidth());
                int yoffset = (int)(Math.random() * display.getHeight());

                tmsg.setGravity(Gravity.TOP | Gravity.LEFT,xoffset,yoffset);
                tmsg.show();
            }
        });
    }
}
