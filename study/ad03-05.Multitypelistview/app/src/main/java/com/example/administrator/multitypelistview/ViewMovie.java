package com.example.administrator.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewMovie extends RelativeLayout {

    private ImageView image_picture = null;
    private TextView  text_title    = null;
    private TextView  text_year     = null;

    public ViewMovie(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_movie,this,true);

        image_picture = rowview.findViewById(R.id.imagePicture);
        text_title    = rowview.findViewById(R.id.textTitle);
        text_year     = rowview.findViewById(R.id.textYear);

    }

    ModelMovie movie;

    public ModelMovie getMovie() {
        return movie;
    }

    public void setMovie(ModelMovie movie) {
        this.movie = movie;

        image_picture .setImageDrawable(movie.getImagimagePicture());
        text_title    .setText         (movie.getTextTitle()   );
        text_year     .setText         (movie.getTextYear()    );
    }
}
