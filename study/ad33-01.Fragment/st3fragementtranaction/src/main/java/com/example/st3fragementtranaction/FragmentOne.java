package com.example.st3fragementtranaction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {


    public static final String KEY_INPUT = "fragment one";

    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance( String input ) {

        FragmentOne fragment = new FragmentOne(  );

        Bundle b = new Bundle(  );
        b.putString( KEY_INPUT , input );
        fragment.setArguments( b );

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}
