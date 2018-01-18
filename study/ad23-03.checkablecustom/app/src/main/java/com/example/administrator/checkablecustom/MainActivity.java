package com.example.administrator.checkablecustom;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    EditText headeredit;
    Button   headerbutton;

    private PersonAdapter personadapter;
    private List<ModelPerson> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        data = initData();

        personadapter = new PersonAdapter(MainActivity.this,R.layout.view_person,data);

        listview.setAdapter( personadapter );

        View headerview = LayoutInflater.from(MainActivity.this)
                                        .inflate(R.layout.header_list_item, null);
        headeredit   = headerview.findViewById(R.id.headeredit);
        headerbutton = headerview.findViewById(R.id.headerbutton);
        listview.addHeaderView( headerview );

        headerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = headeredit.getText().toString();
                if ( !text.isEmpty() ){
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int[] imagetIds={

            R.drawable.sample_0
           ,R.drawable.sample_1
           ,R.drawable.sample_2
           ,R.drawable.sample_3
           ,R.drawable.sample_4
           ,R.drawable.sample_5
           ,R.drawable.sample_6
           ,R.drawable.sample_7

    };

    private List<ModelPerson> initData() {

        data = new ArrayList<ModelPerson>();

        Random r = new Random();
        for(int i = 0; i<20; i++){

            ModelPerson person = new ModelPerson();
            person.setText_name("name " + i);
            person.setText_age("age " + i);
            person.setImage_photo( getResources().getDrawable(imagetIds[ i % imagetIds.length],null) );
            data.add( person );
        }

        return data;
    }
}
