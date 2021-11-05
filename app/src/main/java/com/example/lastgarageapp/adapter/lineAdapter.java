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
    private ArrayList<String> alineFare, aNoOfCars;
    Context con;


    public lineAdapter(Context context, ArrayList<String> lineFare, ArrayList<String> noOfCars) {
        this.alineFare = lineFare;
        this.aNoOfCars = noOfCars;
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
        String lineFare = alineFare.get(position);
        holder.lineFare.setText(lineFare);

        String noOfCars = aNoOfCars.get(position);
        holder.noOfCars.setText(noOfCars);

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
     return alineFare.size();
    }


    public class lineViewHolder extends RecyclerView.ViewHolder {
        TextView lineFare, noOfCars;
        TextView iconEdit, iconDelete;


        public lineViewHolder(@NonNull View itemView) {
            super(itemView);
            lineFare = itemView.findViewById(R.id.lineItem_lineFare);
            noOfCars = itemView.findViewById(R.id.lineItem_noOfCar);


            iconEdit = itemView.findViewById(R.id.lineItem_editIcon);
            iconDelete = itemView.findViewById(R.id.lineItem_deleteIcon);

            iconEdit.setBackgroundTintList(ColorStateList.valueOf(0xff000000));

        }

    }

}
