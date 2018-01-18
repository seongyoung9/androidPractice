package com.example.administrator.arrayadapter_studen;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button      btn_add,btn_search,btn_sort,btn_all_del,btn_init;
    private EditText    edit_name,edit_number,edit_department,edit_item;
    private Spinner     spinner;
    private RadioButton rdoasc,rdodesc;
    private ListView    list_view;


    private List<Modelstudent> data;
    private studentadapter     adapter;
    private String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add     = findViewById(R.id.btn_add);
        btn_search  = findViewById(R.id.btn_search);
        btn_sort    = findViewById(R.id.btn_sort);
        btn_all_del = findViewById(R.id.btn_all_del);
        btn_init    = findViewById(R.id.btn_init);

        // 버튼 핸들러 설정
        Clickhandler handler = new Clickhandler();

        btn_add    .setOnClickListener(handler);
        btn_search .setOnClickListener(handler);
        btn_sort   .setOnClickListener(handler);
        btn_all_del.setOnClickListener(handler);
        btn_init   .setOnClickListener(handler);

        edit_name       = findViewById(R.id.edit_name);
        edit_number     = findViewById(R.id.edit_number);
        edit_department = findViewById(R.id.edit_department);
        edit_item       = findViewById(R.id.edit_item);

        spinner      = findViewById(R.id.spinner);
        rdoasc  = findViewById(R.id.rdoasc);
        rdodesc = findViewById(R.id.rdodesc);
        list_view    = findViewById(R.id.list_view);

        items = getResources().getStringArray(R.array.spinneritems);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this,
                                                                                 android.R.layout.simple_spinner_item,
                                                                                 items);

        spinner.setAdapter( adapterSpinner );

        data = new ArrayList<>();
        for( int i = 0 ; i < 10 ; i++ ) {
            Modelstudent student = new Modelstudent();
            student.setText_name("name " + i); ;
            student.setText_number("number " + i); ;
            student.setText_department(i + "" + i + "" + "-" + i + "" + i); ;
            data.add(student);
        }

        adapter = new studentadapter(MainActivity.this,R.layout.view_student,data);

        list_view.setAdapter(adapter);

        //리스트뷰에 머리 아이템 추가
        View headerView = getLayoutInflater().inflate( R.layout.list_view_header, null);
        TextView headerTitle = (TextView)headerView.findViewById( R.id.header_header_text );
        headerTitle.setText( "리스트의 시작입니다." );
        list_view.addHeaderView( headerView, null, false );


        //리스트뷰에 꼬리 아이템 추가
        View footerView = getLayoutInflater().inflate( R.layout.list_view_footer, null);
        TextView footerTitle = (TextView)footerView.findViewById( R.id.header_footer_text );
        footerTitle.setText( "로딩 중 입니다" );
        list_view.addFooterView(footerView, null, false );

        // 리스트뷰 아이템 구분선 설정
        list_view.setDivider( new ColorDrawable(Color.YELLOW) );
        list_view.setDividerHeight( 3 );

        // 리스트뷰 핸들러 설정
        ListtViewHandler lvhandler = new ListtViewHandler();
        list_view.setOnItemClickListener( lvhandler );
        list_view.setOnItemLongClickListener( lvhandler );

    }

    private class Clickhandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String searchitem = "";
            String searchvalue = "";

            switch (v.getId()) {
                case R.id.btn_add:

                    Modelstudent s = new Modelstudent();
                    s.setText_name      ( edit_name      .getText().toString() );
                    s.setText_number    ( edit_number    .getText().toString() );
                    s.setText_department( edit_department.getText().toString() );
                    if ( !TextUtils.isEmpty( s.getText_name() ) ) {
                        data.add(s);                   //데이터 저장
                        adapter.notifyDataSetChanged();  //데이터 변경 알림
                        list_view.smoothScrollToPosition( data.size()-1 );    //리스트뷰 마지막 레코드로 이동
                    }
                    init();

                    break;
                case R.id.btn_search:
                    //spinner에서 값가져오기
                    searchitem = getFieldName( spinner.getSelectedItem().toString() );
                    searchvalue = edit_item.getText().toString();

                    Modelstudent.MyPredicate predicate = new Modelstudent.MyPredicate(searchitem,searchvalue);
                    List<Modelstudent> result = (List<Modelstudent>)CollectionUtils.select( data,predicate);

                    studentadapter aa = new studentadapter(MainActivity.this,R.layout.view_student,result);
                    list_view.setAdapter( aa );

                    adapter.notifyDataSetChanged();
                    break;
                case R.id.btn_sort:
                    //spinner에서 값가져오기
                    searchitem = getFieldName( spinner.getSelectedItem().toString() );

                    //radio가져오기
                    RadioGroup rdogr = findViewById(R.id.rdogr);
                    int ascdesc = rdogr.getCheckedRadioButtonId();
                    boolean mode = false;
                    switch (ascdesc) {
                        case R.id.rdoasc:
                            mode = false;
                            break;
                        case R.id.rdodesc:
                            mode = true;
                            break;
                        default:
                            mode = false;
                            break;
                    }

                    Comparator<Modelstudent> comparator = null;
                    if ( searchitem.equals( "name" ) ){
                        comparator = new Modelstudent.NameCompare(mode);
                    }
                    else if ( searchitem.equals("number") ){
                        comparator = new Modelstudent.NumberCompare(mode);
                    }
                    else if (searchitem.equals("department") ){
                        comparator = new Modelstudent.DepartmentCompare(mode);
                    }

                    Collections.sort(data, comparator);
                    adapter.notifyDataSetChanged();

                    break;
                case R.id.btn_all_del:

                    data.clear();             //removeall도 가능 더 어려움

                    adapter.notifyDataSetChanged();  //데이터 변경 알림

                    break;
                case R.id.btn_init:

                    init();

                    break;
            }
        }

        private String getFieldName(String selectedItem) {
            if (selectedItem.equals("이름")){
                return "name";
            }else if (selectedItem.equals("학번")){
                return "number";
            }else if (selectedItem.equals("학과")){
                return "department";
            }else{
                return "";
            }
        }
    }
    //리스트뷰 클릭 핸들러
    private class ListtViewHandler implements ListView.OnItemClickListener
                                             ,ListView.OnItemLongClickListener {


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String msg = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("삭제");
            dlg.setMessage(data.get( position-1 ).getText_name().toString());
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    data.remove(position - list_view.getHeaderViewsCount() );
                    adapter.notifyDataSetChanged();  //데이터 변경 알림
                }
            });
            dlg.setNegativeButton("취소",null);
            dlg.show();

            return false;
        }
    }


    //데이터 초기화
    private void init() {
        edit_name       .setText("");
        edit_number     .setText("");
        edit_department .setText("");
        edit_item       .setText("");

        list_view.setAdapter( adapter );
    }


}
