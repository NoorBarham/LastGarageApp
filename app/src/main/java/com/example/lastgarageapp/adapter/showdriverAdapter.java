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
import com.example.lastgarageapp.conversation;
import com.example.lastgarageapp.itemClasses.showDriversItem;
import com.example.lastgarageapp.personal_page;

import java.util.ArrayList;

public class showdriverAdapter extends RecyclerView.Adapter<showdriverAdapter.showDriversViewHolder>{
    private ArrayList<showDriversItem> myshowDriversItems;

    private Context con;

    public showdriverAdapter(Context context, ArrayList<showDriversItem> showDriversItems) {
        this.myshowDriversItems= showDriversItems;
        this.con = context;
    }

    @NonNull
    @Override
    public showdriverAdapter.showDriversViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show_drivers_list_item, parent, false);
        showdriverAdapter.showDriversViewHolder holder = new showdriverAdapter.showDriversViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(showdriverAdapter.showDriversViewHolder holder, int position) {
        showDriversItem l = myshowDriversItems.get(position);
        holder.NameText.setText(l.getnameText());
        holder.sour.setText(l.getsourText());
        holder.dest.setText(l.getdestText());

        holder.iconMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(con, conversation.class);
                con.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return myshowDriversItems.size();
    }

    public class showDriversViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView NameText, sour,dest;
        RelativeLayout show;
        TextView iconMessage;

        public showDriversViewHolder(@NonNull View itemView) {
            super(itemView);

            NameText = itemView.findViewById(R.id.showDriversItem_driverName);
            sour = itemView.findViewById(R.id.ShowDriversItem_garage1);
            dest = itemView.findViewById(R.id.showDriversItem_garage2);

            show=itemView.findViewById(R.id.showdriver_listitems);

            iconMessage =itemView.findViewById(R.id.showDriversItem_messageIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(con, personal_page.class);
                    con.startActivity(intent);
                }
            });

        }


        @Override
        public void onClick(View v) {

        }
    }
}
