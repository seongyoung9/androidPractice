package com.example.st3fragementtranaction;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class FragmentTwo extends Fragment {

    public static final String KEY_INPUT = "input";
    private int REQUST_CODE_OTHER_ACTIVITY = 100000;

    private String   inputText   = ""  ;
    private EditText inputView   = null;
    private TextView messageView = null;
    private Button   btnsend     = null;
    private Button   btnsend2    = null;
    private Button   btnsend3    = null;

    public static FragmentTwo newInstance( String input ) {

        FragmentTwo fragment = new FragmentTwo(  );

        Bundle b = new Bundle(  );
        b.putString( KEY_INPUT, input );
        fragment.setArguments( b );

        return fragment;
    }

    OnMessageCallback callback;

    public interface OnMessageCallback {
        public void displayMessage(String message);
    }

    public FragmentTwo(  ) {
        // Required empty public constructor
    }

    // Life-Cycle Method
    // Main에서 Oncreate된다음 실행되는 메서드들
    //-----------------------------------------
    @Override
    public void onAttach( Context context ) {
        super.onAttach( context );
        if ( context instanceof OnMessageCallback ) {
            // Callback Listener 작성
            callback = ( OnMessageCallback ) context;
        }
    }

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        // Activity에서 넘긴 Bundle 받기.
        Bundle b = getArguments(  );
        if ( b != null ) {
            inputText = b.getString( KEY_INPUT );
        }
    }

    @Override   // 중요 ***
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        inputView    = view.findViewById(R.id.edit_input);
        messageView  = view.findViewById(R.id.text_message);
        btnsend      = view.findViewById(R.id.btn_send);
        btnsend2     = view.findViewById(R.id.btn_send2);
        btnsend3     = view.findViewById(R.id.btn_send3);

        btnsend.setOnClickListener( new View.OnClickListener(  ) {
            @Override
            public void onClick( View v ) {
                String msg = inputView.getText(  ).toString(  );
                messageView.setText( msg );

                // MainActivity의 메서드 호출을 이용한 값 전달.
                ((MainActivity)getActivity()).update( msg );
            }
        });

        btnsend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = inputView.getText(  ).toString(  );
                messageView.setText( msg );

                if (callback != null){
                    callback.displayMessage( msg );
                }
            }
        });

        btnsend3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //엑티비티 띄우기
                Intent i = new Intent( getContext() , OtherActivity.class );
                startActivityForResult( i , REQUST_CODE_OTHER_ACTIVITY );
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUST_CODE_OTHER_ACTIVITY && resultCode == Activity.RESULT_OK){

            String msg = data.getStringExtra(Common.OTHER_MSG);
            inputView.setText( msg );
        }
    }


    //-----------------------------------------------
}
