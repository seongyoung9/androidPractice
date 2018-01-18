package com.example.asynctaskbar;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar1 ;
    private Button      btnInc       ;
    private Button      btnDec       ;
    private TextView    tvSeek       ;
    private SeekBar     seekBar1     ;
    private TextView    tv1          ;
    private SeekBar     pb1          ;
    private TextView    tv2          ;
    private SeekBar     pb2          ;
    private Button      button1      ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        btnInc       = findViewById(R.id.btnInc      );
        btnDec       = findViewById(R.id.btnDec      );
        tvSeek       = findViewById(R.id.tvSeek      );
        seekBar1     = findViewById(R.id.seekBar1    );
        tv1          = findViewById(R.id.tv1         );
        pb1          = findViewById(R.id.pb1         );
        tv2          = findViewById(R.id.tv2         );
        pb2          = findViewById(R.id.pb2         );
        button1      = findViewById(R.id.button1     );

        Buttonclick click = new Buttonclick();
        btnInc.setOnClickListener( click );
        btnDec.setOnClickListener( click );
        button1.setOnClickListener( click );

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행률 : " + progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private class Buttonclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnDec:
                    progressBar1.incrementProgressBy(-10);
                    break;
                case R.id.btnInc:
                    progressBar1.incrementProgressBy( 10);
                    break;
                case R.id.button1:

                    new UpButton().execute ( pb1.getProgress(), pb2.getProgress() );
                    break;
            }
        }
    }

    private class UpButton extends AsyncTask<Integer,Integer,Boolean>{
        ProgressDialog pd = null;
        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("wait...");
            pd.getWindow().setGravity(Gravity.TOP);
            pd.show();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            for (int i = pb1.getProgress(), j = pb2.getProgress() ; i<= pb1.getMax() || j <= pb2.getMax() ; i = i+2, j = j+1){

                if (i >= 100){ i = 100; }
                if (j >= 100){ j = 100; }

                publishProgress( i , j );

                SystemClock.sleep(100);

            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb1.setProgress( values[0] );
            tv1.setText( "1번 진행률 : "+ values[0] + "%" );

            pb2.setProgress( values[1] );
            tv2.setText( "2번 진행률 : "+ values[1] + "%" );
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
