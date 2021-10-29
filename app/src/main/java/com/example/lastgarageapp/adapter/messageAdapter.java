package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.conversation;

import java.util.ArrayList;
import java.util.List;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.myViewHolder> {

    private List<String> mMessagesTexts ;
    private ArrayList<String> mHoureTexts;
    private LayoutInflater mInflater;

    public messageAdapter(Context context,ArrayList<String> mMessagesTexts, ArrayList<String> mHoureTexts) {
        this.mMessagesTexts = mMessagesTexts;
        this.mHoureTexts = mHoureTexts;
        this.mInflater = LayoutInflater.from(context);
    }
//// one to
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.send_massage_item,parent,false);
        myViewHolder holder =new myViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        String message = mMessagesTexts.get(position);
        holder.sendMessageText.setText(message);

        holder.sendMessageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add action here for press on the text message
            }
        });
        String houre = mHoureTexts.get(position);
        holder.sendHoureText.setText(houre);

    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return mMessagesTexts.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView sendMessageText, sendHoureText, send_am_pmText;
//                , receivedMessageText, receivedHoureText, received_am_pmText;
        RelativeLayout sendMessageLayout;
//        , receiveMessageLayout;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sendMessageText=itemView.findViewById(R.id.sendMessageItem_messageText);
            sendHoureText=itemView.findViewById(R.id.sendMessageItem_houre);
            sendMessageLayout=itemView.findViewById(R.id.send_message_layout);
//            receivedMessageText=itemView.findViewById(R.id.receivedMessageItem_messageText);
//            receivedHoureText=itemView.findViewById(R.id.receivedMessageItem_houre);
//            received_am_pmText=itemView.findViewById(R.id.receivedMessageItem_AMPM);
//            receiveMessageLayout=itemView.findViewById(R.id.received_message_layout);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // add action here for press on the item
                }
            });
        }

    }
}
