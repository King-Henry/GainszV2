package com.gainsz.gainsz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import java.util.ArrayList;

public class RestaurantList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new ViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    public static class ViewAdapter extends RecyclerView.Adapter<MyViewHolder> {


        ArrayList<Restaurant> restaurants;

        public ViewAdapter(){

            restaurants = new ArrayList<Restaurant>();
            String[] strings = {"McDonald's", "Chick-Fil-a"};
            int[] icons = {R.mipmap.mcdonalds,R.mipmap.chickfila};
            for(int i = 0; i < icons.length; i++){

                Restaurant restaurant = new Restaurant();
                restaurant.title = strings[i];
                restaurant.iconID = icons[i];
                restaurants.add(restaurant);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_view,parent,false);

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            Restaurant restaurant = restaurants.get(position);
            holder.restaurantTitle.setText(restaurant.title);
            holder.restaurantLogo.setImageResource(restaurant.iconID);

        }

        @Override
        public int getItemCount() {
            return restaurants.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView restaurantTitle;
        ImageView restaurantLogo;

        public MyViewHolder(View myView){

            super(myView);
            cardView = (CardView)myView.findViewById(R.id.card_view);
            restaurantTitle = (TextView)myView.findViewById(R.id.text_view);
            restaurantLogo = (ImageView)myView.findViewById(R.id.image_view);
        }

    }
}



