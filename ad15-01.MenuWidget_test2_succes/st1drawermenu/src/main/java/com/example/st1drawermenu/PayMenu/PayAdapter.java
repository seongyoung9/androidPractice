package com.example.st1drawermenu.PayMenu;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.st1drawermenu.Fragment.Tab2.Tab2_Model_Card;
import com.example.st1drawermenu.R;

import java.util.List;

public class PayAdapter extends ArrayAdapter<Tab2_Model_Card>{

    public  Context context            = null;
    private ViewHolder holder         = null;
    private LayoutInflater inflater  = null;
    private View inflaterView;

    public PayAdapter(@NonNull Context context, int resource, @NonNull List<Tab2_Model_Card> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private class ViewHolder {

        private TextView  textPayName;
        private TextView  textPayPrice;
        private TextView  textPayCount;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        inflater = LayoutInflater.from( context );
        inflaterView = inflater.inflate( R.layout.pay_custom, parent , false );

        holder = ( ViewHolder ) inflaterView.getTag();

        if ( holder == null ) {

            holder = new ViewHolder();

            holder.textPayName = inflaterView.findViewById( R.id.pay_name );
            holder.textPayPrice = inflaterView.findViewById( R.id.pay_price );
            holder.textPayCount = inflaterView.findViewById( R.id.pay_count );

        }

        holder.textPayName    .setText         (this.getItem(position).getTextCoffee()     );
        holder.textPayPrice   .setText         (this.getItem(position).getPayCoffee()      );
        holder.textPayCount   .setText         (this.getItem(position).getPositionCoffee() );

        return inflaterView;
    }
}
