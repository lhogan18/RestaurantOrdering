package com.example.restaurantordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.restaurantordering.Interface.ItemClickListener;
import com.example.restaurantordering.Model.Category;
import com.example.restaurantordering.Model.Food;
import com.example.restaurantordering.ViewHolder.FoodView;
import com.example.restaurantordering.ViewHolder.MenuView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodList;

    FirebaseRecyclerOptions<Food> options;
    FirebaseRecyclerAdapter<Food, FoodView> adapter;

    String categoryID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Food");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null) {
            categoryID = getIntent().getStringExtra("CategoryId");
            //Log.d("TAG", "Check category" + categoryID); for checking if categoryID returns correct value
        }
        if(!categoryID.isEmpty() && categoryID != null){
            loadFoodList(categoryID);
        }
    }

    private void loadFoodList(final String categoryID){
        options = new FirebaseRecyclerOptions.Builder<Food>()
                .setQuery(foodList.orderByChild("MenuID").equalTo(categoryID), Food.class).build();
        adapter = new FirebaseRecyclerAdapter<Food, FoodView>(options) {

            @Override
            protected void onBindViewHolder(@NonNull FoodView holder, int position, @NonNull Food model) {
                holder.food_name.setText(model.getName());

                final Food local = model;
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodList.this, ""+local.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @NonNull
            @Override
            public FoodView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_item, parent, false);
                return new FoodView(view);
            }

        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}