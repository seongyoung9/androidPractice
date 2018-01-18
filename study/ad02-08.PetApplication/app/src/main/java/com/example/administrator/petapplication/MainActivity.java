package com.example.administrator.petapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch switch1 = null;
    private View scroll = null;
    private RadioGroup rdogroup = null;
    private ImageView imgjelly = null;
    private ImageView imgloly = null;
    private ImageView imgluka = null;
    private Button btnfir = null;
    private Button btnexit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        scroll = findViewById(R.id.scroll);
        rdogroup = findViewById(R.id.rdogroup);
        imgjelly = findViewById(R.id.imagejelly);
        imgloly = findViewById(R.id.imageloly);
        imgluka = findViewById(R.id.imageluka);
        btnfir = findViewById(R.id.btnfir);
        btnexit = findViewById(R.id.btnexit);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    scroll.setVisibility(View.VISIBLE);
                    rdogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if ( checkedId == R.id.rdojelly){
                                imgjelly.setVisibility(View.VISIBLE);
                                imgloly.setVisibility(View.GONE);
                                imgluka.setVisibility(View.GONE);
                            }

                            else if ( checkedId == R.id.rdololy){
                                imgjelly.setVisibility(View.GONE);
                                imgloly.setVisibility(View.VISIBLE);
                                imgluka.setVisibility(View.GONE);
                            }

                            else if ( checkedId == R.id.rdoluka){
                                imgjelly.setVisibility(View.GONE);
                                imgloly.setVisibility(View.GONE);
                                imgluka.setVisibility(View.VISIBLE);;
                            }
                        }
                    });

                }
                else if (b == false){
                    scroll.setVisibility(View.GONE);
                }
            }
        });
        btnfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch1.setChecked(false);
                scroll.setVisibility(View.GONE);
            }
        });

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
