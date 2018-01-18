package com.example.administrator.paginglistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<ModelItem>{
    private final Context context;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private class ViewHolder{

        TextView  dataItem01;
        TextView  dataItem02;
        TextView  dataItem03;
        ImageView iconItem  ;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemLayout = LayoutInflater.from( context )
                                        .inflate( R.layout.customview_item, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();
        if (holder == null){

            holder = new ViewHolder();

            holder.dataItem01       = itemLayout.findViewById( R.id.dataItem01  );
            holder.dataItem02       = itemLayout.findViewById( R.id.dataItem02  );
            holder.dataItem03       = itemLayout.findViewById( R.id.dataItem03  );
            holder.iconItem         = itemLayout.findViewById( R.id.iconItem    );

            itemLayout.setTag( holder );

        }

        holder.dataItem01     .setText         ( getItem( position ).getDataItem01() );
        holder.dataItem02     .setText         ( getItem( position ).getDataItem02() );
        holder.dataItem03     .setText         ( getItem( position ).getDataItem03() );
        holder.iconItem       .setImageDrawable( getItem( position ).getIconItem  () );

        return itemLayout;
    }
}
