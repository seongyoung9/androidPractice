package com.example.administrator.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textview = findViewById(R.id.textview);

        Intent i = getIntent();
        String d1 = i.getStringExtra("data");

        if ( d1 != null && !d1.isEmpty() ){
            textview.setText( textview.getText() + " : " + d1 + "\n" );
        }

        int[] array = i.getIntArrayExtra("data");
        if (array != null){

            for (int val : array)
                textview.setText( textview.getText() + " : " + val + " " );
        }

        ModelSerial s1 = (ModelSerial) i.getSerializableExtra("serial");
        if (s1 != null){
            textview.setText( textview.getText() + " : " + s1.toString() + "\n" );
        }

        ModelParcel p1 = i.getParcelableExtra("parcel");
        if (p1 != null){
            textview.setText( textview.getText() + " : " + p1.toString() + "\n" );
        }

        Bundle b1 = i.getBundleExtra("bundle");
        if (b1 != null){
            int idata = b1.getInt("idata",-1);
            String sdata = b1.getString("sdata","");
            textview.setText( textview.getText() + " : " + idata + "\n" );
            textview.setText( textview.getText() + " : " + sdata + "\n" );
        }

    }
}
