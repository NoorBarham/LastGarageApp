package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;
import com.example.lastgarageapp.edit_line;

import java.util.ArrayList;

public class lineAdapter extends RecyclerView.Adapter<lineAdapter.lineViewHolder> {
    private ArrayList<String> alineFare, aNoOfCars,alineName;
    private LayoutInflater mInflater;
    Context con;


    public lineAdapter(Context context, ArrayList<String> lineFare, ArrayList<String> noOfCars, ArrayList<String> lineName) {
        this.alineFare = lineFare;
        this.aNoOfCars = noOfCars;
        this.alineName= lineName;
        this.con = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public lineAdapter.lineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_line_status_list_item, parent, false);
        lineAdapter.lineViewHolder holder = new lineAdapter.lineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(lineAdapter.lineViewHolder holder, int position) {
        String lineFare = alineFare.get(position);
        holder.lineFare.setText(lineFare);

        String noOfCars = aNoOfCars.get(position);
        holder.noOfCars.setText(noOfCars);

        String lineName = alineName.get(position);
        holder.lineName.setText(lineName);

        holder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, edit_line.class);
                con.startActivity(intent);


            }
        });

        holder.iconDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = getItemCount();
        return count;
    }


    public class lineViewHolder extends RecyclerView.ViewHolder {
        TextView lineFare, noOfCars, lineName;
        TextView iconEdit, iconDelete;


        public lineViewHolder(@NonNull View itemView) {
            super(itemView);
            lineFare = itemView.findViewById(R.id.lineItem_lineFare);
            noOfCars = itemView.findViewById(R.id.lineItem_noOfCar);
            lineName = itemView.findViewById(R.id.lineItem_lineName);



            iconEdit = itemView.findViewById(R.id.lineItem_editIcon);
            iconDelete = itemView.findViewById(R.id.lineItem_deleteIcon);

            iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xff000000));

        }

    }

}
