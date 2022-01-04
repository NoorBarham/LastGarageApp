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

import java.util.ArrayList;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.myViewHolder> {

    private ArrayList<messageItem> myChatItem ;
    private LayoutInflater mInflater;
    private int flag;
    Context con;

    public messageAdapter(Context context, ArrayList<messageItem> myChatItem, int flag) {
        this.myChatItem = myChatItem;
        this.flag=flag;
        this.mInflater = LayoutInflater.from(context);
        this.con=context;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
        if(flag==1){
            holder.sendMessageText.setText(c.getMessageText());
            holder.sendHoureText.setText(c.getHoure());
        } else{
            holder.receivedMessageText.setText(c.getMessageText());
            holder.receivedHoureText.setText(c.getHoure());
        }
    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return myChatItem.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView sendMessageText, sendHoureText, receivedMessageText, receivedHoureText;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            sendMessageText=itemView.findViewById(R.id.sendMessageItem_messageText);
            sendHoureText=itemView.findViewById(R.id.sendMessageItem_houre);
            receivedMessageText=itemView.findViewById(R.id.receivedMessageItem_messageText);
            receivedHoureText=itemView.findViewById(R.id.receivedMessageItem_houre);
        }

    }
}

//package com.example.lastgarageapp.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.lastgarageapp.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class messageAdapter extends RecyclerView.Adapter<messageAdapter.myViewHolder> {
//
//    private List<String> mMessagesTexts ;
//    private ArrayList<String> mHoureTexts ;
//    private LayoutInflater mInflater;
//
//    public messageAdapter(Context context, ArrayList<String> mMessagesTexts, ArrayList<String> mHoureTexts) {
//        this.mMessagesTexts = mMessagesTexts;
//        this.mHoureTexts = mHoureTexts;
//        this.mInflater = LayoutInflater.from(context);
//    }
//
//    @NonNull
//    @Override
//    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= mInflater.inflate(R.layout.send_massage_item,parent,false);
//        myViewHolder holder =new myViewHolder(view);
//        return holder;    }
//
//    @Override
//    public void onBindViewHolder(myViewHolder holder, int position) {
//        String message = mMessagesTexts.get(position);
//        holder.sendMessageText.setText(message);
//
//        String houre = mHoureTexts.get(position);
//        holder.sendHoureText.setText(houre);
//    }
//
//    @Override
//    public int getItemCount() {
//        //how many items in my list
//        return mMessagesTexts.size();
//    }
//
//    public class myViewHolder extends RecyclerView.ViewHolder{
//
//        TextView sendMessageText, sendHoureText;
//        RelativeLayout sendMessageLayout;
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//            sendMessageText=itemView.findViewById(R.id.sendMessageItem_messageText);
//            sendHoureText=itemView.findViewById(R.id.sendMessageItem_houre);
//            sendMessageLayout=itemView.findViewById(R.id.send_message_layout);
//        }
//
//    }
//}
