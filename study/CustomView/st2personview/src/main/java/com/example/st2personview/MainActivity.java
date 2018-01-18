package com.example.st2personview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private PersonView personview1;
    private ImageView image_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_select = findViewById(R.id.image_select);
        personview1 = findViewById(R.id.view_person);

        personview1.setOnimageClickLinstener(new PersonView.OnimageClickLinstener() {
            @Override
            public void onImageClick(PersonView view, PersonData person) {

                image_select.setImageDrawable( person.getPhoto() );
                image_select.setVisibility( View.VISIBLE );

            }
        });
    }
}
