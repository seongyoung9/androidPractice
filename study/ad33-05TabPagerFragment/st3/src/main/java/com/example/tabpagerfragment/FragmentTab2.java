package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentTab2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button   btnadd       = null;
    private Button   btnmodify    = null;
    private Button   btndel       = null;
    private EditText edtinput     = null;
    private ListView listview     = null;

    private View                 inflatedview  = null;
    private ArrayAdapter<String> tab2Adapter   = null;
    private List<String> list;

    public FragmentTab2() {

    }

    public static FragmentTab2 newInstance(String param1, String param2) {
        FragmentTab2 fragment = new FragmentTab2();
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

        inflatedview = inflater.inflate(R.layout.fragment_tab2, container, false);
        return inflatedview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnadd    = inflatedview.findViewById(R.id.btn_ADD   );
        btnmodify = inflatedview.findViewById(R.id.btn_MODIFY);
        btndel    = inflatedview.findViewById(R.id.btn_DEL   );
        edtinput  = inflatedview.findViewById(R.id.edt_input );
        listview  = inflatedview.findViewById(R.id.list_view );

        //데이터 만들기
        String[] items = getResources().getStringArray(R.array.items);
        //배열을 리스트로 변환
        list = new ArrayList<String>(Arrays.asList(items));

        tab2Adapter = new ArrayAdapter<String>( getContext(),android.R.layout.simple_list_item_multiple_choice,list);

        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listview.setAdapter( tab2Adapter );

        ButtonClick bclick =  new ButtonClick();
        btnadd    .setOnClickListener( bclick );
        btnmodify .setOnClickListener( bclick );
        btndel    .setOnClickListener( bclick );

    }

    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_ADD:

                    list.add( edtinput.getText().toString());
                    tab2Adapter.notifyDataSetChanged();
                    listview.smoothScrollToPosition( tab2Adapter.getCount() -1 );

                    break;

                case R.id.btn_MODIFY:

                    SparseBooleanArray array = listview.getCheckedItemPositions();
                    String temp = edtinput.getText().toString();

                    for(int index = 0; index < array.size(); index++){
                        int position = array.keyAt(index);
                        list.set(position,temp);
                    }
                    edtinput.setText("");
                    listview.clearChoices(); //선택 해재
                    tab2Adapter.notifyDataSetChanged();  // 리스트뷰를 새로고침 한다.
                    break;

                case R.id.btn_DEL:

                    array = listview.getCheckedItemPositions();

                    for(int index = array.size()-1 ; index >= 0 ; index--){
                        int position = array.keyAt(index);
                        list.remove(position);
                    }
                    listview.clearChoices(); //선택 해재
                    tab2Adapter.notifyDataSetChanged();  // 리스트뷰를 새로고침 한다.

                    break;
            }
        }
    }
}
