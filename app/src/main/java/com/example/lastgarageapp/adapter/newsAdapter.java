package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.itemClasses.newsItem;

import java.util.ArrayList;
import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newViewHolder>{
    private ArrayList<newsItem> myNewsItem;

    private Context con;

    public newsAdapter(Context context,ArrayList<newsItem> myNewsItem) {
        this.con=context;
        this.myNewsItem=myNewsItem;

    }


    @NonNull
    @Override
    public newsAdapter.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_news_list_item, parent, false);
        newViewHolder holder = new newViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull newsAdapter.newViewHolder holder, int position) {
        newsItem ne= myNewsItem.get(position);
        holder.textName.setText(ne.getTextName());
        holder.textNews.setText(ne.getTextNews());
        holder.textHour.setText(ne.getTextHour());


    }

    @Override
    public int getItemCount() {
        return myNewsItem.size();
    }

    public class newViewHolder extends RecyclerView.ViewHolder {
        TextView textName,textNews,textHour;
        TextView  iconDelete;

        public newViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.newsItem_name);
            textHour=itemView.findViewById(R.id.newsItem_clock);
            textNews=itemView.findViewById(R.id.newsItem_description);

        }

    }
    }

