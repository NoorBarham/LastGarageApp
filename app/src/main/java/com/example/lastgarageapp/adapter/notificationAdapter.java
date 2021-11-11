package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.itemClasses.notificationItem;
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.notificationViewHolder> {
    private ArrayList<notificationItem> myNotificationItem;

    private Context con;


    public notificationAdapter(Context context,ArrayList<notificationItem> myNotificationItem) {

        this.con = context;
        this.myNotificationItem=myNotificationItem;
    }

    @NonNull
    @Override
    public notificationAdapter.notificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notification_list_item, parent, false);
        notificationViewHolder holder = new notificationViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull notificationAdapter.notificationViewHolder holder, int position) {

        notificationItem n= myNotificationItem.get(position);
        holder.mmTextname.setText(n.getTextName());
        holder.mmHour.setText(n.getTextHour());

        holder.mmTextname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(con, view_notification.class);
                intent.putExtra("waed", "test value");
                con.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myNotificationItem.size();
    }

    public class notificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mmTextname, mmHour;
        //  ImageView mmImage;
        LinearLayout notificationslayout;

        public notificationViewHolder(@NonNull View itemView) {
            super(itemView);
            mmTextname = itemView.findViewById(R.id.notificationItem_name);
            mmHour = itemView.findViewById(R.id.notificationItem_clock);
            //    mmImage=itemView.findViewById(R.id.notificationsItem_image);
            notificationslayout = itemView.findViewById(R.id.notificationsListItem_layout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(con, view_notification.class);
                    intent.putExtra("waed", "test value");
                    con.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {
            // Intent intent=new Intent(con, view_notification.class);
            //   con.startActivity(intent);
        }
    }
}
