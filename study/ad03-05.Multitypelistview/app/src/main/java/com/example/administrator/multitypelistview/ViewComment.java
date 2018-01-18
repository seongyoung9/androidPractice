package com.example.administrator.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewComment extends RelativeLayout{

    private TextView text_message = null;
    private TextView text_writer  = null;

    public ViewComment(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewComment(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewComment(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                                     .inflate(R.layout.view_comment,this,true);

        text_message = rowview.findViewById(R.id.textMessage);
        text_writer  = rowview.findViewById(R.id.textWriter);

    }

    ModelComment comment;

    public ModelComment getComment() {
        return comment;
    }

    public void setComment(ModelComment comment) {
        this.comment = comment;

        text_message .setText(comment.getTextMessage());
        text_writer  .setText(comment.getTextWriter());
    }
}
