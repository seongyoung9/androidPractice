package com.example.stsolofragmentpractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_ONE = "ONE";
    private Button   btn1    ;
    private Button   btn2    ;
    private Button   btn3    ;
    private TextView maintext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1     = findViewById(R.id.btn1    );
        btn2     = findViewById(R.id.btn2    );
        btn3     = findViewById(R.id.btn3    );
        maintext = findViewById(R.id.maintext);

        ButtonclickListener bcListener = new ButtonclickListener();
        btn1.setOnClickListener( bcListener );
        btn2.setOnClickListener( bcListener );
        btn3.setOnClickListener( bcListener );

    }



    private class ButtonclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn1:

                    Fragment one = getSupportFragmentManager().findFragmentByTag( FRAGMENT_ONE );

                    if (one == null){

                        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                        FragmentOne FO = new FragmentOne();
                        FT.replace(R.id.container,FO,FRAGMENT_ONE);
                        FT.commit();

                    }

                    break;
                case R.id.btn2:

                    break;
                case R.id.btn3:

                    break;
            }
        }
    }

    public void sendtext(String msg) {

        maintext.setText( "메서드 : " + msg );

    }
}
