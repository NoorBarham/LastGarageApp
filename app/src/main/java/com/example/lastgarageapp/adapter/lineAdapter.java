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
import com.example.lastgarageapp.edit_line;
import com.example.lastgarageapp.itemClasses.lineItem;

import java.util.ArrayList;

public class lineAdapter extends RecyclerView.Adapter<lineAdapter.lineViewHolder> {
    private ArrayList<lineItem> myLineItem;
    Context con;


    public lineAdapter(Context context, ArrayList<lineItem> myLineItem) {
        this.myLineItem = myLineItem;
        this.con = context;

    }

    @NonNull
    @Override
    public lineAdapter.lineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_line_status_list_item, parent, false);
        lineAdapter.lineViewHolder holder = new lineAdapter.lineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(lineAdapter.lineViewHolder holder, int position) {
        lineItem l = myLineItem.get(position);
        holder.lineFare.setText(l.getLineFare());
        holder.noOfCars.setText(l.getNoOfCar());
        holder.garage1.setText(l.getGarage1());
        holder.garage2.setText(l.getGarage2());

        holder.iconDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
     return myLineItem.size();
    }


    public class lineViewHolder extends RecyclerView.ViewHolder {
        TextView lineFare, noOfCars, garage1,garage2;
        TextView iconDelete;


        public lineViewHolder(@NonNull View itemView) {
            super(itemView);
            lineFare = itemView.findViewById(R.id.lineItem_lineFare);
            noOfCars = itemView.findViewById(R.id.lineItem_noOfCar);
            garage1= itemView.findViewById(R.id.lineItem_garage1);
            garage2= itemView.findViewById(R.id.lineItem_garage2);
            iconDelete = itemView.findViewById(R.id.lineItem_deleteIcon);


        }

    }

}
