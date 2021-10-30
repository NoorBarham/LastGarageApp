package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;

import java.util.ArrayList;
import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.myViewHolder>{
    private List<String> textNames ;
    private ArrayList<String> textNews;
    private ArrayList<String> textHours;
    private LayoutInflater nInflater;
    //private LayoutInflater imageDeletes;

    public newsAdapter(Context context,ArrayList<String> textNames, ArrayList<String> textNews, ArrayList<String> textHours) {
        this.textNames = textNames;
        this.textNews = textNews;
        this.textHours = textHours;
        this.nInflater = LayoutInflater.from(context);
       // this.imageDeletes = imageDeletes;
    }


    @NonNull
    @Override
    public newsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= nInflater.inflate(R.layout.activity_news_list_item,parent,false);
        myViewHolder holder =new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull newsAdapter.myViewHolder holder, int position) {
            String Name= textNames.get(position);
            holder.textName.setText(Name);

            String News=textNews.get(position);
            holder.textNews.setText(News);


            String Hour=textHours.get(position);
            holder.textHour.setText(Hour);



    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class myViewHolder extends RecyclerView.ViewHolder {
           TextView textName,textNews,textHour;
           ImageView imageDelete;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.newsItem_name);
            textHour=itemView.findViewById(R.id.newsItem_clock);
            textNews=itemView.findViewById(R.id.newsItem_description);
          //  imageDelete=itemView.findViewById(R.id.newsItem_delet);
        }

    }
    }

