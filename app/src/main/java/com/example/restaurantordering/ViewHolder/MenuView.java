package com.example.restaurantordering.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantordering.Interface.ItemClickListener;
import com.example.restaurantordering.R;


public class MenuView extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static TextView menuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuView(View itemView){
        super(itemView);

        menuName = (TextView)itemView.findViewById(R.id.MenuName);
        imageView = (ImageView)itemView.findViewById(R.id.menuImg);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view){
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
