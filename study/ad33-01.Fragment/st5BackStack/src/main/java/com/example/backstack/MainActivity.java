package com.example.backstack;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_back ;
    private Button btn_next ;
    private Button btn_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back  = findViewById(R.id.btn_back );
        btn_next  = findViewById(R.id.btn_next );
        btn_empty = findViewById(R.id.btn_empty);

        ButtonClickListener bcclick = new ButtonClickListener();
        btn_back .setOnClickListener( bcclick );
        btn_next .setOnClickListener( bcclick );
        btn_empty.setOnClickListener( bcclick );
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            int count = -1;
            switch (v.getId()){
                case R.id.btn_back:
                    count = fm.getBackStackEntryCount();

                    if ( count > 0 ){
                        fm.popBackStack();
                    }
                    break;
                case R.id.btn_next:
                    count = fm.getBackStackEntryCount();

                    if ( count < 10 ){
                        // MessageFragment 인스턴스 생성1
                        Bundle b = new Bundle();
                        b.putString( MessageFragment.ARG_PARAM1, String.valueOf( count + 1 ) );

                        MessageFragment mf = new MessageFragment();
                        mf.setArguments( b );

                        // MessageFragment 인스턴스 생성2
                        MessageFragment mf1 = MessageFragment.newInstance( String.valueOf( count + 1 ) );

                        // BackStack 에 추가
                        fm.beginTransaction()
                          .replace( R.id.container , mf )
                          .addToBackStack( "entry" + count )
                          .commit();
                    }
                    break;
                case R.id.btn_empty:              // backstack의 모든것을 지운다
                    fm.popBackStack( null, FragmentManager.POP_BACK_STACK_INCLUSIVE );

                    break;
            }
        }
    }
}
