package com.example.bbs.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bbs.R;
import com.example.bbs.model.ModelComments;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterComment extends ArrayAdapter<ModelComments> {

    private final LayoutInflater mInflater;
    private List<ModelComments> mList;

    public AdapterComment(@NonNull Context context, int resource, @NonNull List<ModelComments> objects) {
        super(context, resource, objects);

        this.mList = objects;
        this.mInflater = LayoutInflater.from( context );

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rowView = convertView;
        // 뷰생성
        viewholder holder = null;
        if ( rowView == null ){
            holder = new viewholder();
            rowView = mInflater.inflate(R.layout.activity_article_detail_customview, parent, false );

            holder.commentno = rowView.findViewById( R.id.commentno );
            holder.refgate   = rowView.findViewById( R.id.regdate   );
            holder.memo      = rowView.findViewById( R.id.memo      );

            rowView.setTag( holder );
        }
        else{
            holder = (viewholder) rowView.getTag();
        }

        // 데이터 관련 설정
        ModelComments item = getItem( position );
        holder.commentno  .setText( item.getCommentno() + "" );
        holder.memo       .setText( item.getMemo() + ""  );

        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");   // 날짜라서
        holder.refgate    .setText( tf.format(item.getRegdate() ) );

        return rowView;
    }
    private class viewholder{

        TextView commentno;
        TextView refgate;
        TextView memo;
    }

}
