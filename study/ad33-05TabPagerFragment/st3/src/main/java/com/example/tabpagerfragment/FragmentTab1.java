package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View         inflatedview     = null ;
    private Button       btnadd           = null ;
    private EditText     edtinput         = null ;
    private List<String> mData            = null ;
    private ListView     mListview        = null ;
    private ArrayAdapter<String> mAdapter = null ;


    public FragmentTab1() {

    }

    public static FragmentTab1 newInstance(String param1, String param2) {
        FragmentTab1 fragment = new FragmentTab1();
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

    @Override                      // 인플레이션은 이곳에서
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflatedview = inflater.inflate(R.layout.fragment_tab1, container, false);

        return inflatedview;
    }

    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );

        btnadd   = inflatedview.findViewById(R.id.btn_add);
        edtinput = inflatedview.findViewById(R.id.edt_input);
        mData = makeData();

        // ListView 찾기
        // ArrayAdapter 생성
        // Listview와  Arrayadapter연결
        mListview = inflatedview.findViewById( R.id.list_view );
        mAdapter = new ArrayAdapter<String>( getContext() ,
                                                              android.R.layout.simple_list_item_1 ,
                                                              mData );
        mListview.setAdapter( mAdapter );
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mData.add( edtinput.getText().toString());
                mAdapter.notifyDataSetChanged();
                mListview.smoothScrollToPosition( mAdapter.getCount() -1 );
            }
        });


    }

    private List<String> makeData() {

        List<String> data = new ArrayList<>();

        data.add("Item 00");
        data.add("Item 01");
        data.add("Item 02");
        data.add("Item 03");
        data.add("Item 04");
        data.add("Item 05");
        data.add("Item 06");
        data.add("Item 07");
        data.add("Item 08");
        data.add("Item 09");
        data.add("Item 10");
        data.add("Item 11");
        data.add("Item 12");
        data.add("Item 13");
        data.add("Item 14");
        data.add("Item 15");
        data.add("Item 16");
        data.add("Item 17");
        data.add("Item 18");
        data.add("Item 19");
        data.add("Item 20");
        data.add("Item 21");
        data.add("Item 22");
        return data;
    }
}
