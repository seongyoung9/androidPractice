package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentTab3 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ArrayList<Modelstudent> data;
    private ListView listView;
    private View v;
    private AdapterStudent studentAdapter;

    private Button btnAdd    = null;
    private Button btnSearch = null;
    private Button btnSort   = null;
    private Button btnAllDel = null;
    private Button btnInit   = null;
    private EditText editName       = null;
    private EditText editNumber     = null;
    private EditText editDepartment = null;
    private EditText editItme       = null;


    public FragmentTab3() {

    }

    public static FragmentTab3 newInstance(String param1, String param2) {
        FragmentTab3 fragment = new FragmentTab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tab3, container, false);

        // 데이터 만들기
        data = new ArrayList<>();
        for(int i=0; i<10; i++){
            Modelstudent student  = new Modelstudent();
            student.setTextName("name " + i );
            student.setTextNumber("number " + i );
            student.setTextDepartment(i+"-"+i);
            data.add(student);
        }

        studentAdapter = new AdapterStudent(getContext(),R.layout.tab3_student_view,data);
        listView = v.findViewById(R.id.list_view);

        listView.setAdapter( studentAdapter );

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        // 버튼 클릭 리스너
        /*----------------------------------*/
        btnAdd     = v.findViewById( R.id.btn_add    );
        btnSearch  = v.findViewById( R.id.btn_search );
        btnSort    = v.findViewById( R.id.btn_sort   );
        btnAllDel  = v.findViewById( R.id.btn_all_del);
        btnInit    = v.findViewById( R.id.btn_init   );

        buttonclick bclick = new buttonclick();
        btnAdd     .setOnClickListener( bclick );
        btnSearch  .setOnClickListener( bclick );
        btnSort    .setOnClickListener( bclick );
        btnAllDel  .setOnClickListener( bclick );
        btnInit    .setOnClickListener( bclick );
        /*-------------------------------------------*/

        // textview 관리
        /*---------------------------------------*/
        editName       = v.findViewById(R.id.edit_name       );
        editNumber     = v.findViewById(R.id.edit_number     );
        editDepartment = v.findViewById(R.id.edit_department );
        editItme       = v.findViewById(R.id.edit_itme       );
        /*---------------------------------------*/

    }

    private class buttonclick implements View.OnClickListener{
        @Override
        public void onClick( View v ) {
            switch ( v.getId() ){
                case R.id.btn_add:
                    String name       = editName      .getText().toString();
                    String number     = editNumber    .getText().toString();
                    String department = editDepartment.getText().toString();

                    Modelstudent student = new Modelstudent();
                    student.setTextName        ( name       );
                    student.setTextNumber      ( number     );
                    student.setTextDepartment  ( department );

                    data.add( student );

                    // 데이터 변경 알림
                    studentAdapter.notifyDataSetChanged();

                    // listview의 마지막 레코드로 이동.                 // headerview 가 있을시
                    listView.smoothScrollToPosition( data.size()-1/* + listView.getHeaderViewsCount()*/);

                    initialization();
                    break;
                case R.id.btn_search:

                    initialization();
                    break;
                case R.id.btn_sort:

                    initialization();
                    break;
                case R.id.btn_all_del:
                    data.clear(); // 전체 삭제.
                    // 데이터 변경 알림
                    studentAdapter.notifyDataSetChanged();

                    initialization();
                    break;
                case R.id.btn_init:

                    initialization();
                    break;
            }
        }

        private void initialization() {
            editName      .setText("");
            editNumber    .setText("");
            editDepartment.setText("");
        }
    }
}
