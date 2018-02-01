package com.example.tabpagerfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab4 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private Tab4_Adapter_Image tab4Adapter;
    private ListView tab4ListView;
    private int[] imageIds = {
              R.drawable.icon01
            , R.drawable.icon02
            , R.drawable.icon03
            , R.drawable.icon04
            , R.drawable.icon05
            , R.drawable.icon06
    };
    private List<Tab4_Model_Image> data;


    public FragmentTab4() {

    }

    public static FragmentTab4 newInstance(String param1, String param2) {
        FragmentTab4 fragment = new FragmentTab4();
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

        View v = inflater.inflate(R.layout.fragment_tab4, container, false);

        data = MakeData( 0 , 10);

        tab4Adapter = new Tab4_Adapter_Image( getContext(), R.layout.fragment_tab4_custom , data);
        tab4ListView = v.findViewById(R.id.tab4_listView);

        tab4ListView.setAdapter( tab4Adapter );

        return v;
    }

    private List<Tab4_Model_Image> MakeData( int start, int count ) {

        List<Tab4_Model_Image> newitems = new ArrayList<Tab4_Model_Image>();

        for(int i=start; i<start + count; i++){
            Tab4_Model_Image tab4Model = new Tab4_Model_Image();
            tab4Model.setFirstImage( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );
            tab4Model.setFirstText( "name1 " + i );
            tab4Model.setSecondImage( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );
            tab4Model.setSecondText( "name2 " + i );

            newitems.add( tab4Model );
        }
        return newitems;
    }

}
