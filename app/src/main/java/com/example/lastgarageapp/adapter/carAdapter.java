package com.example.lastgarageapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.edit_car_data;
import com.example.lastgarageapp.edit_garage;
import com.example.lastgarageapp.itemClasses.carItem;
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class carAdapter extends RecyclerView.Adapter<carAdapter.carViewHolder> {
    ArrayList<carItem> myCarItem;
    Context con;

    public carAdapter(Context context, ArrayList<carItem> myCarItem) {
        this.myCarItem = myCarItem;
        this.con = context;
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_car_status_list_item, parent, false);
        carViewHolder holder = new carViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, int position) {
        carItem c = myCarItem.get(position);
        holder.nameDriver.setText(c.getDriverName());
        holder.nameDriver.setText(c.getDriverName());
        holder.availability.setText(c.getAvailabilty());
        holder.noOfPassenger.setText(c.getNoOfPassenger());
        holder.arrivalTime.setText(c.getArrivalTime());

        holder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xffff6f00));
                Intent intent = new Intent(con, edit_car_data.class);
                con.startActivity(intent);

            }
        });

        holder.iconDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return myCarItem.size();
    }

    public class carViewHolder extends RecyclerView.ViewHolder {
        TextView carNomber,nameDriver, availability, noOfPassenger, arrivalTime;
        TextView iconEdit, iconDelet;


        public carViewHolder(@NonNull View itemView) {
            super(itemView);
            carNomber=itemView.findViewById(R.id.carItem_carNomber);
            nameDriver = itemView.findViewById(R.id.carItem_driverName);
            availability = itemView.findViewById(R.id.carItem_availabilty);
            noOfPassenger = itemView.findViewById(R.id.carItem_noOfPassenger);
            arrivalTime = itemView.findViewById(R.id.carItem_arrivalTime);

            iconEdit = itemView.findViewById(R.id.carItem_editIcon);
            iconDelet = itemView.findViewById(R.id.carItem_deleteIcon);


        }

    }
}