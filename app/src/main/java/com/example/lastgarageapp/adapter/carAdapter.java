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
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class carAdapter extends RecyclerView.Adapter<carAdapter.carViewHolder> {
    ArrayList<String> textName,textAvailability,textnoOfPassenger,textTime;
    Context con;

    public carAdapter(Context context, ArrayList<String> textName, ArrayList<String> textAvailability, ArrayList<String> textnoOfPassenger, ArrayList<String> textTime) {
        this.textName = textName;
        this.textAvailability = textAvailability;
        this.textnoOfPassenger = textnoOfPassenger;
        this.textTime = textTime;
        this.con=context;

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
        String Name = textName.get(position);
        holder.nameDriver.setText(Name);

        String availability = textAvailability.get(position);
        holder.carAvailability.setText(availability);

        String noofpassenger = textnoOfPassenger.get(position);
        holder.numberofpassengers.setText(noofpassenger);

        String timeexpected = textTime.get(position);
        holder.carexpectedTime.setText(timeexpected);

        holder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xffff6f00));
                Intent intent=new Intent(con, edit_car_data.class);
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
        return textName.size();
    }

    public class carViewHolder extends RecyclerView.ViewHolder {
        TextView  nameDriver, carAvailability,numberofpassengers, carexpectedTime;
        TextView iconEdit, iconDelet;



        public carViewHolder(@NonNull View itemView) {
            super(itemView);
            nameDriver=itemView.findViewById(R.id.carItem_driverName);
            carAvailability=itemView.findViewById(R.id.carItem_availabilty);
            numberofpassengers=itemView.findViewById(R.id.carItem_noOfPassenger);
            carexpectedTime=itemView.findViewById(R.id.carItem_arrivalTime);

            iconEdit=itemView.findViewById(R.id.garageItem_editIcon);
            iconDelet=itemView.findViewById(R.id.garageItem_deleteIcon);



        }

        }
    }

