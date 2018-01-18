package com.example.administrator.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewDrama extends FrameLayout{

    private ImageView image_picture = null;
    private TextView  text_title    = null;
    private TextView  text_interval = null;

    public ViewDrama(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewDrama(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                .inflate(R.layout.view_drama,this,true);

        image_picture = rowview.findViewById(R.id.imagePicture);
        text_title    = rowview.findViewById(R.id.textTitle);
        text_interval = rowview.findViewById(R.id.textInterval);
    }

    ModelDrama drama;

    public ModelDrama getDrama() {
        return drama;
    }

    public void setDrama(ModelDrama drama) {
        this.drama = drama;

        image_picture .setImageDrawable(drama.getImagePicture());
        text_title    .setText         (drama.getTextTitle()   );
        text_interval .setText         (drama.getTextInterval());
    }
}
