package com.example.administrator.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = findViewById(R.id.textview1);

        new CountUpTask().execute( 20 );

    }
    //
    private class CountUpTask extends AsyncTask<Integer,Integer,Boolean>{
        ProgressDialog pd = null;
        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("처리중....");
            pd.getWindow().setGravity(Gravity.TOP);
            pd.show();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {        //...은 배열로 처리

            int count = 0;
            for ( int i = 0; i <= integers[0]; i++ ){
                publishProgress( count++, i );

                // 1초 딜레이
                android.os.SystemClock.sleep(1000);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textview1.setText( values[0] +"" );
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if ( pd != null ){
                pd.dismiss();
                pd = null;
            }
        }
    }

}
