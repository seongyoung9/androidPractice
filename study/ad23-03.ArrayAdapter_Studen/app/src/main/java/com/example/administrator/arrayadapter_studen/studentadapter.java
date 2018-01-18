package com.example.administrator.arrayadapter_studen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class studentadapter extends ArrayAdapter<Modelstudent> {
    private Context context;

    public studentadapter(@NonNull Context context, int resource, @NonNull List<Modelstudent> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    // viewholder란
    // 커스텀 뷰의 위젯을 담는 클래스다
    private class ViewHolder{

        TextView name       ;
        TextView number     ;
        TextView department ;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = LayoutInflater.from( context )
                .inflate( R.layout.view_student, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();
        if (holder == null){

            holder = new ViewHolder();

            holder.name       = itemLayout.findViewById( R.id.text_name );
            holder.number     = itemLayout.findViewById( R.id.text_number );
            holder.department = itemLayout.findViewById( R.id.text_department );

            itemLayout.setTag( holder );

        }

        holder.name      .setText( getItem( position ).getText_name() );
        holder.number    .setText( getItem( position ).getText_number() );
        holder.department.setText( getItem( position ).getText_department() );

        return itemLayout;
    }
}
