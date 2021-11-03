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

import java.util.ArrayList;

public class messengerAdapter extends RecyclerView.Adapter<messengerAdapter.messengerViewHolder> {

    private ArrayList<String> textNames ;
    private ArrayList<String> textmesages;
    private ArrayList<String> textHours;
    private LayoutInflater nInflater;

    public messengerAdapter(Context context, ArrayList<String> textNames, ArrayList<String> textmesages, ArrayList<String> textHours) {
        this.textNames = textNames;
        this.textmesages = textmesages;
        this.textHours = textHours;
        this.nInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public messengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= nInflater.inflate(R.layout.activity_message_list_item,parent,false);
        messengerViewHolder holder =new messengerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull messengerViewHolder holder, int position) {
        String Name= textNames.get(position);
        holder.textName.setText(Name);

        String Messages=textmesages.get(position);
        holder.textMessage.setText(Messages);


        String Hour=textHours.get(position);
        holder.textHour.setText(Hour);
    }

    @Override
    public int getItemCount() {
        return textNames.size();
    }


    public class messengerViewHolder extends RecyclerView.ViewHolder {
        TextView textName,textMessage,textHour;
        ImageView imageDelete;
        RelativeLayout newsListlayout;
        public messengerViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.messageItem_name);
            textHour=itemView.findViewById(R.id.messageItem_clock);
            textMessage=itemView.findViewById(R.id.messageItem_message);

        }

    }
}
