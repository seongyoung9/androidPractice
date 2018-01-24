package com.example.stsolofragmentpractice;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private Button   btnsend1;
    private Button   btnsend2;
    private Button   btnsend3;
    private TextView textview;
    private EditText edttext ;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        edttext  = v.findViewById(R.id.edttext );
        btnsend1 = v.findViewById(R.id.btnsend1);
        btnsend2 = v.findViewById(R.id.btnsend2);
        btnsend3 = v.findViewById(R.id.btnsend3);
        textview = v.findViewById(R.id.textview);

        btnsend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = edttext.getText().toString();
                textview.setText( msg );

                ((MainActivity)getActivity()).sendtext( msg );

            }
        });

        btnsend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = edttext.getText().toString();
                textview.setText( msg );


            }
        });
        return v;
    }

}
