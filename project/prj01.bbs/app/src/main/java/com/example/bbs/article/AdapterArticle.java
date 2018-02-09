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
import com.example.bbs.model.ModelArticle;

import java.util.List;

public class AdapterArticle extends ArrayAdapter<ModelArticle> {

    private final LayoutInflater mInflater;
    private List<ModelArticle> mList;

    public AdapterArticle(@NonNull Context context, int resource, @NonNull List<ModelArticle> objects) {
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
            rowView = mInflater.inflate(R.layout.activity_article_list_customview, parent, false );

            holder.no      = rowView.findViewById( R.id.no      );
            holder.title   = rowView.findViewById( R.id.title   );
            holder.hit     = rowView.findViewById( R.id.hit     );

            rowView.setTag( holder );
        }
        else{
            holder = (viewholder) rowView.getTag();
        }

        // 데이터 관련 설정
        ModelArticle item = getItem( position );
        holder.no     .setText( item.getArticleno() + "" );
        holder.title  .setText( item.getTitle()     );
        holder.hit    .setText( item.getHit() + ""  );

        return rowView;
    }
    private class viewholder{

        TextView no     ;
        TextView title  ;
        TextView hit    ;
    }

}
