package com.example.st2personview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private  PersonView personview1;
    private ImageView imageselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        imageselect = findViewById(R.id.image_select);

        personview1 = findViewById(R.id.view_person );
        personview1.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, PersonData person) {
                imageselect.setImageDrawable( person.getPhoto() );
                imageselect.setVisibility( View.VISIBLE );
            }
        });
    }
}
