package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.conversation;
import com.example.lastgarageapp.itemClasses.chatItem;

import java.util.ArrayList;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.messengerViewHolder> {
    ArrayList<chatItem> myMessengerItem;
    Context con;

    public chatAdapter(Context context, ArrayList<chatItem> myMessengerItem) {
        this.con=context;
        this.myMessengerItem=myMessengerItem;

    }

    @NonNull
    @Override
    public messengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chats_list_item, parent, false);
        messengerViewHolder holder = new  messengerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull messengerViewHolder holder, int position) {
        chatItem m= myMessengerItem.get(position);
        holder.chat_id.setText(m.getChatId());
        holder.name.setText(m.getTextName());
        holder.textMessage.setText(m.getTextMessage());
        holder.hour.setText(m.getTextHour());

    }

    @Override
    public int getItemCount() {
        return myMessengerItem.size();
    }


    public class messengerViewHolder extends RecyclerView.ViewHolder {
        TextView name,textMessage, hour,chat_id;
        public messengerViewHolder(@NonNull View itemView) {
            super(itemView);
            chat_id =itemView.findViewById(R.id.messageItem_chatId);
            name =itemView.findViewById(R.id.messageItem_name);
            hour =itemView.findViewById(R.id.messageItem_clock);
            textMessage=itemView.findViewById(R.id.messageItem_message);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    conversation.chat_id= chat_id.getText().toString();
                    conversation.static_receiver_name= name.getText().toString();
                    Intent intent = new Intent(con, conversation.class);
                    con.startActivity(intent);
                }
            });

        }

    }

    }

