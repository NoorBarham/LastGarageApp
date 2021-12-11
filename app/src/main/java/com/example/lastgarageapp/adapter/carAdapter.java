package com.example.lastgarageapp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.itemClasses.carItem;

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
        holder.carNumber.setText(c.getCarNumber());
        holder.nameDriver.setText(c.getDriverName());

        if(c.getAvailability().equals("0")){
            holder.availability.setText("غير متاحة");
            holder.arrivalLayout.setVisibility(View.VISIBLE);
        }else if(c.getAvailability().equals("1")){
            holder.availability.setText("متاحة");
            holder.arrivalLayout.setVisibility(View.GONE);
        }

        holder.noOfPassenger.setText(c.getNoOfPassenger());
        holder.capacity.setText(c.getCapacity());
        holder.arrivalTime.setText(c.getArrivalTime());

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
        TextView carNumber,nameDriver, availability, noOfPassenger, capacity, arrivalTime;
        TextView iconDelet;
        LinearLayout arrivalLayout;

        public carViewHolder(@NonNull View itemView) {
            super(itemView);
            carNumber=itemView.findViewById(R.id.carItem_carNumber);
            nameDriver = itemView.findViewById(R.id.carItem_driverName);
            availability = itemView.findViewById(R.id.carItem_availabilty);
            noOfPassenger = itemView.findViewById(R.id.carItem_noOfPassenger);
            capacity = itemView.findViewById(R.id.carItem_capacity);
            arrivalTime = itemView.findViewById(R.id.carItem_arrivalTime);
            iconDelet = itemView.findViewById(R.id.carItem_deleteIcon);
            arrivalLayout = itemView.findViewById(R.id.carItem_arrivalLayout);


        }

    }
}