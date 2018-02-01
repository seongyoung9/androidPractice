package com.example.tabpagerfragment;

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

public class Tab4_Adapter_Image extends ArrayAdapter<Tab4_Model_Image>{

    private Context        context;
    private LayoutInflater inflate;
    private View       inflateView;

    public Tab4_Adapter_Image(@NonNull Context context, int resource, @NonNull List<Tab4_Model_Image> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private class ViewHolder {
        ImageView firstImage  ;
        ImageView secondImage ;
        TextView  firstText   ;
        TextView  secondText  ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        inflate     = LayoutInflater.from( context );
        inflateView = inflate.inflate(R.layout.fragment_tab4_custom , parent , false);

        ViewHolder holder = ( ViewHolder ) inflateView.getTag();
        if ( holder == null ) {
            holder = new ViewHolder();

            holder.firstImage  = inflateView.findViewById(R.id.first_image );
            holder.secondImage = inflateView.findViewById(R.id.second_image);
            holder.firstText   = inflateView.findViewById(R.id.first_text  );
            holder.secondText  = inflateView.findViewById(R.id.second_text );

            inflateView.setTag( holder );
        }
        Tab4_Model_Image item = getItem(position);
        holder.firstImage   .setImageDrawable( item.getFirstImage()  );
        holder.secondImage  .setImageDrawable( item.getSecondImage() );
        holder.firstText    .setText         ( item.getFirstText()   );
        holder.secondText   .setText         ( item.getSecondText()  );

        return inflateView;
    }
}
