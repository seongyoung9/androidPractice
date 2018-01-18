package com.example.administrator.multitypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯선언
    private ListView     listView = null;
    private AdapterActor adapter  =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView = findViewById(R.id.listView);

        // 위젯 설정        현재 할거 없음

        // data 만들기
        ModelActor datas = makeData();

        // adapter 만들기
        adapter = new AdapterActor(MainActivity.this,datas);

        // listview와 adapter연결하기
        listView.setAdapter( adapter );
    }

    private ModelActor makeData() {
        ModelActor actor = new ModelActor();

        actor.setImagePhoto( getResources().getDrawable(R.drawable.sample_0,null) );
        actor.setTextAge("42");
        actor.setTextName("ysi");
        actor.setTextDescription("desc.....");

        List<ModelMovie>   movies   = new ArrayList<>();
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_1),"movie title 1","2015") );
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_2),"movie title 2","2016") );
        movies.add( new ModelMovie(getResources().getDrawable(R.drawable.sample_3),"movie title 3","2017") );

        actor.setMovies( movies );

        List<ModelDrama>   dramas   = new ArrayList<>();
        dramas.add( new ModelDrama(getResources().getDrawable(R.drawable.sample_4),"drama title 1","1~3"));
        dramas.add( new ModelDrama(getResources().getDrawable(R.drawable.sample_5),"drama title 2","4~6"));

        actor.setDramas( dramas );

        List<ModelComment> comments = new ArrayList<>();
        comments.add(new ModelComment("Comment...1","writer1") );
        comments.add(new ModelComment("Comment...2","writer2") );

        actor.setComments( comments );

        return actor;
    }
}
