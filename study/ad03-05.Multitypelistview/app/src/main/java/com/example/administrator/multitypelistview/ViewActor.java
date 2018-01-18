package com.example.administrator.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewActor extends RelativeLayout{

    private ImageView image_photo      = null;
    private TextView  text_name        = null;
    private TextView  text_age         = null;
    private TextView  text_description = null;

    public ViewActor(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewActor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewActor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_actor,this,true);

        image_photo      = rowview.findViewById(R.id.imagePhoto);
        text_name        = rowview.findViewById(R.id.textName);
        text_age         = rowview.findViewById(R.id.textAge);
        text_description = rowview.findViewById(R.id.textDescription);
    }

    ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        image_photo      .setImageDrawable(actor.getImagePhoto());
        text_name        .setText         (actor.getTextName());
        text_age         .setText         (actor.getTextAge());
        text_description .setText         (actor.getTextDescription());
    }
}
