package com.example.administrator.paginglistview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    private ItemAdapter itemadapter;
    private List<ModelItem> data;
    private boolean modeGetDate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);

        data = makeData(0,20);

        itemadapter = new ItemAdapter(MainActivity.this,R.layout.customview_item,data);

        listview.setAdapter( itemadapter );
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //alertdialog 출력하기
                ModelItem item = data.get( position );

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(item.getDataItem01());
                builder.setMessage(item.toString());
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("확인",null);
                builder.setNegativeButton("취소",null);
                builder.show();
            }
        });

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            //스크롤 아래에 닿으면 생성
            /*firstVisibleItem+visibleItemCount = totalItemCount   바닥이다.*/
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if ( totalItemCount == firstVisibleItem+visibleItemCount){

                    //데이터 추가
                    if (modeGetDate == false) {
                        modeGetDate = true;

                        new HttpGetData().execute(data.size(), 20);

                    }
                }
            }
        });

    }
    private List<ModelItem> makeData( int start, int last ) {

        List<ModelItem> newitems = new ArrayList<ModelItem>();

        Random r = new Random();
        for(int i = start; i< (start + last); i++){

            ModelItem item = new ModelItem();
            item.setDataItem01("name " + i);
            item.setDataItem02( getRandString() );
            item.setDataItem03( 20 + r.nextInt(3000) + "" );
            item.setIconItem( getResources().getDrawable( imagetIds[ i % imagetIds.length],null) );

            newitems.add( item );
        }

        return newitems;
    }
    private int[] imagetIds={

             R.drawable.icon01
            ,R.drawable.icon02
            ,R.drawable.icon03
            ,R.drawable.icon04
            ,R.drawable.icon05
            ,R.drawable.icon06

    };
    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random()*10000); i++) {
//char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf( (char) ((Math.random() * 26) + 97) );
        }
        return str;
    }

    private class HttpGetData extends AsyncTask< Integer, Integer, List< ModelItem > >{

        private ProgressDialog prdg;
        // 네트워크로 데이터 요청하기 직전에 실행되는 메서드 요청전
        //사용자에게 요청을 알림. 시계 표시(ProgressDialog)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            prdg = new ProgressDialog(MainActivity.this);
            prdg.setMessage("데이터 기다리는중....");
            prdg.show();

        }
        // 요청중
        @Override
        protected List<ModelItem> doInBackground(Integer... integers) {
            List<ModelItem> temp = null;

            //4초간 기다리기... sleep 주기
            try {
                Thread.sleep(4000);

                //1. 네트워크를 통해 데이터 요청
                temp = makeData(integers[0], integers[1]);
            }catch (InterruptedException e ){
                e.printStackTrace();
            }

            return temp;
        }

        // 네트워크로 데이터 요청이 완료되었을때 실행되는 메서드 요청후
        //사용자에게 요청 알린것을 제거. 시계 제거(ProgressDialog)
        @Override
        protected void onPostExecute(List<ModelItem> modelItems) {
            super.onPostExecute(modelItems);
            if (prdg != null){
                prdg.dismiss();
                prdg = null;
            }

            //데이터 받은 후의 작업
            //2. 데이터를 수신 완료한 경우
            data.addAll( modelItems );
            itemadapter.notifyDataSetChanged();

            modeGetDate = false;
        }


    }

}
