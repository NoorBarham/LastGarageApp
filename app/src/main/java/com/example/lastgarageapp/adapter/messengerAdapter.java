package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.conversation;
import com.example.lastgarageapp.itemClasses.messengerItem;
import com.example.lastgarageapp.personal_page;
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class messengerAdapter extends RecyclerView.Adapter<messengerAdapter.messengerViewHolder> {
    ArrayList<messengerItem> myMessengerItem;
    Context con;

    public messengerAdapter(Context context, ArrayList<messengerItem> myMessengerItem) {
        this.con=context;
        this.myMessengerItem=myMessengerItem;

    }

    @NonNull
    @Override
    public messengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_message_list_item, parent, false);
        messengerViewHolder holder = new  messengerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull messengerViewHolder holder, int position) {
        messengerItem m= myMessengerItem.get(position);
        holder.textName.setText(m.getTextName());
        holder.textMessage.setText(m.getTextMessage());
        holder.textHour.setText(m.getTextHour());

    }

    @Override
    public int getItemCount() {
        return myMessengerItem.size();
    }


    public class messengerViewHolder extends RecyclerView.ViewHolder {
        TextView textName,textMessage,textHour;
        ImageView imageDelete;
        public messengerViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.messageItem_name);
            textHour=itemView.findViewById(R.id.messageItem_clock);
            textMessage=itemView.findViewById(R.id.messageItem_message);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(con, conversation.class);
                    con.startActivity(intent);
                }
            });

        }

    }

    }

