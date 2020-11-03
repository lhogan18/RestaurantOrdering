package com.example.restaurantordering.ViewHolder;

import android.content.ClipData;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantordering.Interface.ItemClickListener;
import com.example.restaurantordering.R;

public class FoodView extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_name;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public FoodView(View itemView){
        super(itemView);

        food_name = (TextView)itemView.findViewById(R.id.food_name);
        itemView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
