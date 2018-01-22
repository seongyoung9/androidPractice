package com.example.st3fragementtranaction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
                          implements FragmentTwo.OnMessageCallback{

    private static final String FRAGMENT_TAG_ONE = "ONE";
    private static final String FRAGMENT_TAG_TWO = "TWO";

    private Button btn0,btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById( R.id.btn0 );
        btn1 = findViewById( R.id.btn1 );
        btn2 = findViewById( R.id.btn2 );

        Buttonclick bclick =  new Buttonclick();

        btn0.setOnClickListener( bclick );
        btn1.setOnClickListener( bclick );
        btn2.setOnClickListener( bclick );
    }


    private class Buttonclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch ( v.getId() ){
                case R.id.btn0:
                    Fragment old = getSupportFragmentManager().findFragmentByTag( FRAGMENT_TAG_ONE );

                    if ( old == null ){

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentOne fo = new FragmentOne();
                        Bundle b = new Bundle();
                        b.putString(FragmentOne.KEY_INPUT,"bundle로 값 전달하기");
                        fo.setArguments( b );

                        ft.replace(R.id.container,fo,FRAGMENT_TAG_ONE);
                        ft.commit();

                    }
                    break;
                case R.id.btn1:
                    Fragment old2 = getSupportFragmentManager().findFragmentByTag( FRAGMENT_TAG_TWO );

                    if ( old2 == null ){

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentTwo fo = FragmentTwo.newInstance("fragment two");
                        ft.replace(R.id.container,fo,FRAGMENT_TAG_TWO);
                        ft.commit();

                    }
                    break;
                case R.id.btn2:

                    break;
            }
        }
    }

    // 메서드를 통한 fragment 값전달
    public void update( String msg ){
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText( "메서드 " + msg );
    }

    // callback을 통한 fragment 값전달
    @Override
    public void displayMessage(String message) {
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText( "callback " + message );
    }
}
