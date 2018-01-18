package com.example.intro;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class IntroActivity extends AppCompatActivity {
    private TextView textview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setTitle("Intro");

        //3초 기다리기  스레드 or  ▼
        Handler h = new Handler();
        Runnable r = new Runnable() {
            Intent intent = null;

            @Override
            public void run() {
                intent = new Intent(IntroActivity.this,MainActivity.class);
                startActivity( intent );
                IntroActivity.this.finish();
            }
        };
        h.postDelayed( r , 3000);

       /* textview = findViewById(R.id.textview);
        new count().execute();*/

    }
    /*private class count extends AsyncTask<Integer,Integer,Boolean>{

        Intent intent = null;

        @Override
        protected Boolean doInBackground(Integer... integers) {

            for (int i = 1; i <= 3; i++){

                publishProgress( i );
                SystemClock.sleep(1000);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textview.setText( values[0] + "" );
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity( intent );

        }
    }*/
}
