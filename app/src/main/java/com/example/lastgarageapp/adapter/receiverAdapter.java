package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.home_page;
import com.example.lastgarageapp.personal_page;
import com.example.lastgarageapp.received_message_item;

import java.util.ArrayList;
import java.util.List;

public class receiverAdapter extends RecyclerView.Adapter<receiverAdapter.receiverViewHolder> {

    static class b extends RecyclerView.ViewHolder{
        received_message_item noor;

        public b(@NonNull View itemView, received_message_item noor) {
            super(itemView);
            this.noor = noor;
        }
        void setData(received_message_item i){

        }
    }
    private List<String> mMessagesTexts ;
    private ArrayList<String> mHoureTexts;
    private LayoutInflater mInflater;

    public receiverAdapter(Context context, ArrayList<String> mMessagesTexts, ArrayList<String> mHoureTexts) {
        this.mMessagesTexts = mMessagesTexts;
        this.mHoureTexts = mHoureTexts;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public receiverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.received_message_item,parent,false);
        receiverViewHolder holder =new receiverViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(receiverViewHolder holder, int position) {
        String message = mMessagesTexts.get(position);
        holder.receivedMessageText.setText(message);

        holder.receivedMessageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add action here for press on the text message
            }
        });
        String houre = mHoureTexts.get(position);
        holder.receivedHoureText.setText(houre);

    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return mMessagesTexts.size();
    }

    public class receiverViewHolder extends RecyclerView.ViewHolder{

        TextView  receivedMessageText, receivedHoureText;
        RelativeLayout receiveMessageLayout;
        public receiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receivedMessageText=itemView.findViewById(R.id.receivedMessageItem_messageText);
            receivedHoureText=itemView.findViewById(R.id.receivedMessageItem_houre);
            receiveMessageLayout=itemView.findViewById(R.id.received_message_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // add action here for press on the item

                }
            });
        }

    }
}