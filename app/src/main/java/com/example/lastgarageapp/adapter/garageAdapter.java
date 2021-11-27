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
import com.example.lastgarageapp.edit_garage;
import com.example.lastgarageapp.itemClasses.garageItem;

import java.util.ArrayList;

public class garageAdapter extends RecyclerView.Adapter<garageAdapter.garageViewHolder> {

    private ArrayList<garageItem> myGarageItem;
    private LayoutInflater mInflater;
    Context con;

    public garageAdapter(Context context, ArrayList<garageItem> myGarageItem) {
        this.myGarageItem = myGarageItem;
        this.con=context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public garageAdapter.garageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.activity_garage_status_list_item,parent,false);
        garageAdapter.garageViewHolder holder =new garageAdapter.garageViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(garageAdapter.garageViewHolder holder, int position) {
        garageItem g = myGarageItem.get(position);
        holder.cityName.setText(g.getCityName());
        holder.adminName.setText(g.getAdminName());
        holder.location.setText(g.getLocation());
        holder.fromHoure.setText(g.getFromHoure());
        holder.toHoure.setText(g.getToHoure());

        holder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xffff6f00));
                Intent intent=new Intent(con, edit_garage.class);
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
        //how many items in my list
        return myGarageItem.size();
    }

    public class garageViewHolder extends RecyclerView.ViewHolder{
        TextView cityName, adminName, location, toHoure, fromHoure;
        TextView iconEdit, iconDelet;


        public garageViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName=itemView.findViewById(R.id.garageItem_cityName);
            adminName=itemView.findViewById(R.id.garageItem_adminName);
            location=itemView.findViewById(R.id.garageItem_locationValue);
            toHoure=itemView.findViewById(R.id.garageItem_toHoure);
            fromHoure=itemView.findViewById(R.id.garageItem_FromHoure);
            iconEdit=itemView.findViewById(R.id.garageItem_editIcon);
            iconDelet=itemView.findViewById(R.id.garageItem_deleteIcon);

            iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xff000000));

        }

    }
}
