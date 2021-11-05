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
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class messengerAdapter extends RecyclerView.Adapter<messengerAdapter.messengerViewHolder> {

    private ArrayList<String> textNames ;
    private ArrayList<String> textmesages;
    private ArrayList<String> textHours;
    Context con;

    public messengerAdapter(Context context, ArrayList<String> textNames, ArrayList<String> textmesages, ArrayList<String> textHours) {
        this.textNames = textNames;
        this.textmesages = textmesages;
        this.textHours = textHours;
        this.con=context;

    }

    @NonNull
    @Override
    public messengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_message_list_item, parent, false);
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

        holder.iconDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return textNames.size();
    }


    public class messengerViewHolder extends RecyclerView.ViewHolder {
        TextView textName,textMessage,textHour;
        TextView  iconDelet;

        public messengerViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.messageItem_name);
            textHour=itemView.findViewById(R.id.messageItem_clock);
            textMessage=itemView.findViewById(R.id.messageItem_message);
            iconDelet=itemView.findViewById(R.id.messageItem_deletIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(con, conversation.class);
                    intent.putExtra("waed", "test value");
                    con.startActivity(intent);
                }
            });

        }

        }

    }

