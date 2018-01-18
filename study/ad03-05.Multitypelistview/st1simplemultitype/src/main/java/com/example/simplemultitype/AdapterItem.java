package com.example.simplemultitype;

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

public class AdapterItem extends ArrayAdapter<ModelItem>{

    //ViewType 상수선언
    public static final int ITEM_VIEW_TYPE_TEXT   = 0;
    public static final int ITEM_VIEW_TYPE_IMAGES = 1;

    private final Context context;
    private final List<ModelItem> datas;
    private final LayoutInflater inflater;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datas    = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowview = convertView;

        int viewType = getItemViewType(position);
        ViewHolder holder = null;
        ModelItem item = datas.get(position);

        if (rowview == null){
            //inflate
            holder = new ViewHolder();

            switch ( viewType ){
                case ITEM_VIEW_TYPE_TEXT:
                    rowview = inflater.inflate(R.layout.listview_item1,parent,false);

                    holder.title = rowview.findViewById(R.id.title);
                    holder.desc  = rowview.findViewById(R.id.desc );

                    break;
                case ITEM_VIEW_TYPE_IMAGES:
                    rowview = inflater.inflate(R.layout.listview_item2,parent,false);

                    holder.image = rowview.findViewById(R.id.image);
                    holder.name  = rowview.findViewById(R.id.name );

                    break;
            }
            rowview.setTag( holder );
        }
        else {
            holder = ( ViewHolder ) rowview.getTag();
        }
        switch ( viewType ){
            case ITEM_VIEW_TYPE_TEXT:
                holder.title    .setText         (item.getTitle());
                holder.desc     .setText         (item.getDesc() );
                break;
            case ITEM_VIEW_TYPE_IMAGES:
                holder.image    .setImageDrawable(item.getImage());
                holder.name     .setText         (item.getName() );
                break;
        }
        return rowview;
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
    private class ViewHolder{
        //type 1
        TextView  title;
        TextView  desc ;
        //type 2
        ImageView image;
        TextView  name ;
    }
}
