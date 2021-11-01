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
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.myViewHolder> {
    private ArrayList<String> mTextname = new ArrayList<>();
    private ArrayList<String> mHourtext = new ArrayList<>();
    // private ArrayList<String> mImage=new ArrayList<>();
    private Context con;


    public notificationAdapter(Context context, ArrayList<String> mTextnoto, ArrayList<String> mTextname, ArrayList<String> mHourtext) {

        this.mTextname = mTextname;
        this.mHourtext = mHourtext;
        //   this.mImage = mImage;
        this.con = context;
    }

    @NonNull
    @Override
    public notificationAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notification_list_item, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull notificationAdapter.myViewHolder holder, int position) {

        String name = mTextname.get(position);
        holder.mmTextname.setText(name);

        String hour = mHourtext.get(position);
        holder.mmHour.setText(hour);
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
        return mTextname.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mmTextname, mmHour;
        //  ImageView mmImage;
        RelativeLayout notificationslayout;

        public myViewHolder(@NonNull View itemView) {
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
            Intent intent=new Intent(con, view_notification.class);
            con.startActivity(intent);
        }
    }
}
