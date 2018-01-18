package com.example.st1simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private EditText edttext;
    private Button btnAdd;
    private Button btnmodi;
    private Button btndel;
    private ListView listview;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview1);
        edttext = findViewById(R.id.edittext1);
        btnAdd = findViewById(R.id.btnadd);
        btnmodi = findViewById(R.id.btnmodi);
        btndel = findViewById(R.id.btndel);

        //데이터 만들기
        String[] items = getResources().getStringArray(R.array.items);
        //배열을 리스트로 변환
        list = new ArrayList<String>(Arrays.asList(items));

        //어댑터 생성 & 데이터 추가
        adapter = new ArrayAdapter<String>(MainActivity.this
                                                                ,android.R.layout.simple_list_item_single_choice
                                                                ,list);
        
        //어댑터 연결 
        listview.setAdapter( adapter );

        listview.setChoiceMode( listview.CHOICE_MODE_SINGLE );

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // i: 현재 선택된 배열의 방번호.
                String selecteditem = list.get(i);
                edttext.setText( selecteditem );

            }
        });
        //데이터 추가
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (listview.getChoiceMode() == listview.CHOICE_MODE_SINGLE) {
                    String input = edttext.getText().toString();

                    if (!TextUtils.isEmpty(input)) {
                        list.add(0, input);
                        adapter.notifyDataSetChanged();  // 리스트뷰를 새로고침 한다.
                        listview.smoothScrollToPosition(0);   //스크롤을 마지막으로 가라 list.size() -1
                                                              //처음으로는 0을 주면된다

                        edttext.setText("");
                    }
                }

            }
        });
        //데이터 수정
        btnmodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listview.getChoiceMode() == listview.CHOICE_MODE_SINGLE) {
                    String input = edttext.getText().toString();

                    if (!TextUtils.isEmpty(input)) {
                        int position = listview.getCheckedItemPosition();
                        list.set(position, input);
                        adapter.notifyDataSetChanged();  // 리스트뷰를 새로고침 한다.
                        listview.smoothScrollToPosition(position -1);
                        edttext.setText("");
                        listview.clearChoices(); //radio 선택 해재

                    }
                }
            }
        });
        //데이터 삭제
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listview.getChoiceMode() == listview.CHOICE_MODE_SINGLE) {

                    int position = listview.getCheckedItemPosition();
                    list.remove(position);
                    adapter.notifyDataSetChanged();  // 리스트뷰를 새로고침 한다.
                    listview.smoothScrollToPosition(position -1);
                    edttext.setText("");
                    listview.clearChoices(); //radio 선택 해재

                }
            }
        });
    }
}
