package com.example.administrator.solo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chbcir;
    private Button   btncir;
    private Integer  rota    = 0;

    private EditText edttoast;

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edttoast = findViewById(R.id.edttoast);

        edttoast.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                String txt = edttoast.getText().toString();
                Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        chbcir = findViewById(R.id.chbcir);
        btncir = findViewById(R.id.btncir);

        chbcir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b == true){
                    rota += 45;
                    btncir.setRotation(rota);

                }

            }
        });

        img.findViewById(R.id.img);

        btncir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rota += 10;
                img.setRotation(rota);
            }
        });
    }
}
