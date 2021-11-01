package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.edit_garage;
import com.example.lastgarageapp.view_notification;

import java.util.ArrayList;

public class garageAdapter extends RecyclerView.Adapter<garageAdapter.garageViewHolder> {

    private ArrayList<String> aToHoure,aFromHoure, aNoOfCars, aAdminName, aCityName;
    private LayoutInflater mInflater;
    Context con;

    public garageAdapter(Context context, ArrayList<String> cityName, ArrayList<String> adminName, ArrayList<String> noOfCars, ArrayList<String> fromHoure, ArrayList<String> toHoure) {
        this.aCityName = cityName;
        this.aAdminName = adminName;
        this.aNoOfCars = noOfCars;
        this.aFromHoure = fromHoure;
        this.aToHoure = toHoure;
        this.con=context;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public garageAdapter.garageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.activity_garage_status_list_item,parent,false);
        garageAdapter.garageViewHolder holder =new garageAdapter.garageViewHolder(view);
        return holder;    }


    @Override
    public void onBindViewHolder(garageAdapter.garageViewHolder holder, int position) {
        String cityName = aCityName.get(position);
        holder.cityName.setText(cityName);

        String adminName = aAdminName.get(position);
        holder.adminName.setText(adminName);

        String noOfCars = aNoOfCars.get(position);
        holder.noOfCars.setText(noOfCars);

        String fromHoure = aFromHoure.get(position);
        holder.fromHoure.setText(fromHoure);

        String toHoure = aToHoure.get(position);
        holder.toHoure.setText(toHoure);

        holder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xffff6f00));
                Intent intent=new Intent(con, edit_garage.class);
                con.startActivity(intent);

//                CharSequence s="gg";
//                EditText t =view.findViewById(R.id.garageItem_FromHoure);
//                t.setText(s);
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
        //how many items in my list
        return aCityName.size();
    }

    public class garageViewHolder extends RecyclerView.ViewHolder{
        TextView cityName, adminName, noOfCars, toHoure, fromHoure;
        TextView iconEdit, iconDelet;


        public garageViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName=itemView.findViewById(R.id.garageItem_cityName);
            adminName=itemView.findViewById(R.id.garageItem_adminName);
            noOfCars=itemView.findViewById(R.id.garageItem_noOfCars);
            toHoure=itemView.findViewById(R.id.garageItem_toHoure);
            fromHoure=itemView.findViewById(R.id.garageItem_FromHoure);
            iconEdit=itemView.findViewById(R.id.garageItem_editIcon);
            iconDelet=itemView.findViewById(R.id.garageItem_deleteIcon);

            iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xff000000));

        }

    }
}
