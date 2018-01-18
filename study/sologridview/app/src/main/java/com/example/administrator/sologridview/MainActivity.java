package com.example.administrator.sologridview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridView gv     = null;
    private ImageView image = null;
    private Integer[] posterID = {
            R.drawable.mov00,R.drawable.mov10,R.drawable.mov20,
            R.drawable.mov01,R.drawable.mov11,R.drawable.mov21,
            R.drawable.mov02,R.drawable.mov12,R.drawable.mov22,
            R.drawable.mov03,R.drawable.mov13,R.drawable.mov23,
            R.drawable.mov04,R.drawable.mov14,R.drawable.mov24,
            R.drawable.mov05,R.drawable.mov15,R.drawable.mov25,
            R.drawable.mov06,R.drawable.mov16,R.drawable.mov26,
            R.drawable.mov07,R.drawable.mov17,R.drawable.mov27,
            R.drawable.mov08,R.drawable.mov18,R.drawable.mov28,
            R.drawable.mov09,R.drawable.mov19,R.drawable.mov29,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        gv = findViewById(R.id.gridview);

        GridViewAdapter adapter = new GridViewAdapter(this,-1);

        gv.setAdapter( adapter );


        /*gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View dialog = View.inflate(MainActivity.this,R.layout.dialog,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                image = dialog.findViewById(R.id.imageview);
                image.setImageResource(posterID[position]);
                builder.setTitle("큰 포스터");
                builder.setView(image);
                builder.setNegativeButton("취소",null);
                builder.show();
            }
        });*/
    }

    private class GridViewAdapter extends ArrayAdapter{
        Context context;
        public GridViewAdapter(@NonNull Context context, int resource) {
            super(context, -1);
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams( new GridView.LayoutParams(300,360) );
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialog = View.inflate(MainActivity.this,R.layout.dialog,null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    image = dialog.findViewById(R.id.imageview);
                    image.setImageResource(posterID[pos]);
                    builder.setTitle("큰 포스터");
                    builder.setView(image);
                    builder.setNegativeButton("취소",null);
                    builder.show();
                }
            });


            return imageView;
        }
    }
}
