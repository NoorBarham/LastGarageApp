package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.itemClasses.messageItem;
import com.example.lastgarageapp.login;

import java.util.ArrayList;


public class messageAdapter extends RecyclerView.Adapter<messageAdapter.myViewHolder> {

    private ArrayList<messageItem> myChatItem ;
    private LayoutInflater mInflater;
    private int flag=0;
    Context con;

    public messageAdapter(Context context, ArrayList<messageItem> myChatItem) {
        this.myChatItem = myChatItem;
        this.mInflater = LayoutInflater.from(context);
        this.con=context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(flag==1){
            view= mInflater.inflate(R.layout.send_massage_item,parent,false);
        }else{
            view= mInflater.inflate(R.layout.received_message_item,parent,false);
        }
        myViewHolder holder =new myViewHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        messageItem c = myChatItem.get(position);
        if(myChatItem.get(position).getSender_id().equals(login.myUser_id)){
            holder.sendMessageText.setText(c.getMessageText());
            holder.sendHourText.setText(c.getHour());
            flag=1;
        } else{
            holder.receivedMessageText.setText(c.getMessageText());
            holder.receivedHourText.setText(c.getHour());
            flag=0;
        }
    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return myChatItem.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView sendMessageText, sendHourText, receivedMessageText, receivedHourText;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sendMessageText=itemView.findViewById(R.id.sendMessageItem_messageText);
            sendHourText =itemView.findViewById(R.id.sendMessageItem_houre);
            receivedMessageText=itemView.findViewById(R.id.receivedMessageItem_messageText);
            receivedHourText =itemView.findViewById(R.id.receivedMessageItem_houre);
        }

    }
}