package com.example.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThr extends Fragment {

    String[] imagetitle    = { "Dream 01" , "Dream 02" , "Dream 03" };
    int   [] imageDrawable = { R.drawable.mov55, R.drawable.mov56, R.drawable.mov57 };
    private View view;

    public FragmentThr() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_thr, container, false);

        return view;
    }

    public void update( int index ){
        TextView  title = view.findViewById( R.id.title );
        ImageView image = view.findViewById( R.id.image );

        title.setText( imagetitle[ index ] );
        image.setImageDrawable( getResources().getDrawable( imageDrawable[ index ] ) );
    }
}
