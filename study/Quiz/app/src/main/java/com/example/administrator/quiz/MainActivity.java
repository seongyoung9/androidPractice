package com.example.administrator.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView textsolve;
    private Button   btntrue  ;
    private Button   btnfalse ;
    private Button   btncheat ;
    private Button   btnpre   ;
    private Button   btnnext  ;

    private ModelQuestion[] allQuestion = new ModelQuestion[]{
            new ModelQuestion(R.string.question_africa , false),
            new ModelQuestion(R.string.question_america, true ),
            new ModelQuestion(R.string.question_asia   , true ),
            new ModelQuestion(R.string.question_constan, true ),
            new ModelQuestion(R.string.question_mideast, false),
            new ModelQuestion(R.string.question_oceans , true )
    };
    private int     questionnumber = 0;
    private boolean correct;
    private int     message = 0;
    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textsolve = findViewById(R.id.textsolve);
        btntrue   = findViewById(R.id.btntrue  );
        btnfalse  = findViewById(R.id.btnfalse );
        btncheat  = findViewById(R.id.btncheat );
        btnpre    = findViewById(R.id.btnpre   );
        btnnext   = findViewById(R.id.btnnext  );

        ButtonClick btnclick = new ButtonClick();

        btntrue .setOnClickListener( btnclick );
        btnfalse.setOnClickListener( btnclick );
        btncheat.setOnClickListener( btnclick );
        btnpre  .setOnClickListener( btnclick );
        btnnext .setOnClickListener( btnclick );

        // 첫 data 설정
        updatequestion();

    }

    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btntrue:

                    correct = allQuestion[questionnumber].isAnswertrue();

                    if ( correct == true ){
                        message = R.string.true_toast;
                    }
                    else {
                        message = R.string.false_toast;
                    }
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btnfalse:

                    correct = allQuestion[questionnumber].isAnswertrue();

                    if ( correct == false ){
                        message = R.string.true_toast;
                    }
                    else {
                        message = R.string.false_toast;
                    }
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

                    break;
                case R.id.btncheat:

                    Intent i = new Intent(MainActivity.this,CheatActivity.class);
                    i.putExtra("correct",correct);
                    startActivity( i );

                    break;
                case R.id.btnpre:
                    if (questionnumber <= 0){
                        questionnumber = allQuestion.length;
                    }

                    questionnumber = (questionnumber -1) % allQuestion.length;
                    updatequestion();

                    break;
                case R.id.btnnext:

                    questionnumber = (questionnumber +1) % allQuestion.length;
                    updatequestion();

                    break;
            }
        }
    }
    // data업데이트를 해줌
    private void updatequestion() {
        int question = allQuestion[questionnumber].getQuestiontext();
        textsolve.setText( question );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_INDEX,questionnumber);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if ( savedInstanceState != null ){
            questionnumber = savedInstanceState.getInt(KEY_INDEX,0);
        }
    }
}
