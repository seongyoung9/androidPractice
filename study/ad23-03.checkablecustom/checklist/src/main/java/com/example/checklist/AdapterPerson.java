package com.example.checklist;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterPerson extends ArrayAdapter<ModelPerson>{

    private Context           context = null;
    private List<ModelPerson> lists   = null;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super(context, resource, objects);

        this.context = context;
        this.lists   = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
       // return getViewHolder(position, convertView, parent);
        return getViewClass(position, convertView, parent);

    }
    @NonNull
    private View getViewClass(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewPerson rowView = (ViewPerson)convertView;

        if (rowView == null){
            rowView = new ViewPerson( parent.getContext() );
            rowView.setTag( "Exist" );
        }
        // 데이터 ViewPerson에 데이터 설정
        ModelPerson p = lists.get(position);
        rowView.setPerson( p );

        return rowView;
    }


































/*
    private class ViewHolder{
        ImageView imagePhoto ;
        TextView  textName   ;
        TextView  textAge    ;
        CheckBox  imageCheck ;
    };
*/

    /*@NonNull
    private View getViewHolder(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = null;

        if ( rowView == null ){
            rowView = LayoutInflater.from(this.context)
                                    .inflate(R.layout.view_person, parent, false);

            holder = new ViewHolder();

            holder.imagePhoto   = rowView.findViewById(R.id.image_photo);
            holder.textName     = rowView.findViewById(R.id.text_name  );
            holder.textAge      = rowView.findViewById(R.id.text_age   );
            holder.imageCheck   = rowView.findViewById(R.id.image_check);

            rowView.setTag( holder );

        }
        else{
            holder = (ViewHolder) rowView.getTag();
        }
        ModelPerson p = lists.get( position );
        holder.imagePhoto .setImageDrawable   ( p.getImagePhoto() );
        holder.textName   .setText            ( p.getTextName() );
        holder.textAge    .setText            ( p.getTextAge() );
        holder.imageCheck .setChecked         ( p.getImageCheck() );

        //listView를 위아래로 스크롤 할때 화면 새로 고침을 위해서
        if ( p.getImageCheck() ){
            //배경색 칠하기  check상태 바꾸기
            rowView.setBackgroundColor(Color.YELLOW);
            p.setImageCheck(true);
        }
        else{
            rowView.setBackgroundColor(Color.TRANSPARENT );
            p.setImageCheck(false);
        }

        final View finalRowView = rowView;
        holder.imageCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelPerson person = lists.get( position );
                if ( !person.getImageCheck() ){
                    //배경색 칠하기  check상태 바꾸기
                    finalRowView.setBackgroundColor(Color.YELLOW);
                    person.setImageCheck(true);
                }
                else{
                    finalRowView.setBackgroundColor(Color.TRANSPARENT );
                    person.setImageCheck(false);
                }
            }
        });

        return rowView;
    }*/
}