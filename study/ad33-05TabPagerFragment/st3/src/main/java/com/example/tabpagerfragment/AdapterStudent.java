package com.example.tabpagerfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterStudent extends ArrayAdapter<Modelstudent> {

    private Context        context;
    private LayoutInflater inflate;
    private View inflateView;

    public AdapterStudent(@NonNull Context context, int resource, ArrayList<Modelstudent> data) {
        super(context, resource, data);
        this.context = context;
    }

    private class ViewHolder {
        TextView name       ;
        TextView number     ;
        TextView department ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        inflate     = LayoutInflater.from( context );
        inflateView = inflate.inflate( R.layout.tab3_student_view , parent , false);

        ViewHolder holder = ( ViewHolder ) inflateView.getTag();
        if ( holder == null ){
            holder = new ViewHolder();

            holder.name       = inflateView.findViewById(R.id.text_name      );
            holder.number     = inflateView.findViewById(R.id.text_number    );
            holder.department = inflateView.findViewById(R.id.text_department);

        }
        holder.name      .setText( getItem( position ).getTextName()      );
        holder.number    .setText( getItem( position ).getTextNumber()    );
        holder.department.setText( getItem( position ).getTextDepartment());

        return inflateView;
    }
}
