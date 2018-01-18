package com.example.checklist;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //위젯 찾기
    private ListView          listView = null;
    private List<ModelPerson> data     = null;
    private AdapterPerson     adapter  = null;
    private int[]             images   = {
             R.drawable.sample_0
            ,R.drawable.sample_1
            ,R.drawable.sample_2
            ,R.drawable.sample_3
            ,R.drawable.sample_4
            ,R.drawable.sample_5
            ,R.drawable.sample_6
            ,R.drawable.sample_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 찾기
        listView = findViewById(R.id.listView);

        //위젯 설정. 리스너. 생략

        //데이터 만들기
        data = makeData();

        //adapter생성
        adapter = new AdapterPerson(MainActivity.this,R.layout.view_person,data);

        //listView와 adapter연결
        listView.setAdapter( adapter );
    }

    private List<ModelPerson> makeData() {
        List<ModelPerson> items = new ArrayList<ModelPerson>();
        ModelPerson person;
        for (int i = 0 ; i < 20; i++){
            person = new ModelPerson();
            person.setImageCheck(false);
            person.setTextAge(i + "");
            person.setTextName("name " + i);
            Drawable d = getResources().getDrawable(images[i % images.length], null);
            person.setImagePhoto( d );

            items.add( person );
        }

        return items;
    }
}
