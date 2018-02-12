package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View         inflatedview     = null ;
    private Tab1_Adapter_Card tab1Adapter;
    private GridView tab1GridView;
    private List<Tab1_Model_Card> data;


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

        data = MakeData( 1 , 20 );

        tab1Adapter = new Tab1_Adapter_Card( getContext(), R.layout.fragment_tab1_custom, data );
        tab1GridView = inflatedview.findViewById( R.id.gridView );
        tab1GridView.setAdapter( tab1Adapter );

        return inflatedview;
    }



    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );

    }

    private List<Tab1_Model_Card> MakeData( int start, int end ) {

        List<Tab1_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab1_Model_Card item = new Tab1_Model_Card();
            item.setImageCoffee(getResources().getDrawable(R.drawable.icon05));
            item.setTextCoffee ("추억의 테트리스 " + String.format("%3d", i ) );

            list.add(item);
        }

        return list;
    }
}
