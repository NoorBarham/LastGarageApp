package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastgarageapp.R;

import java.util.ArrayList;
import java.util.List;

public class showdriverAdapter extends RecyclerView.Adapter<showdriverAdapter.myViewHolder>{

    private ArrayList<String> nameText ;
    private ArrayList<String> lineworkText ;
    private Context con;

    public showdriverAdapter(Context context, ArrayList<String> nameText, ArrayList<String> lineworkText) {
        this.nameText = nameText;
        this.lineworkText = lineworkText;
        this.con = context;
    }

    @NonNull
    @Override
    public showdriverAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_show_drivers_list_item, parent, false);
        myViewHolder holder =new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(showdriverAdapter.myViewHolder holder, int position) {
        String name = nameText.get(position);
        holder.NameText.setText(name);

        String line = lineworkText.get(position);
        holder.LineWorkeText.setText(line);
    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return nameText.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView NameText, LineWorkeText;
        RelativeLayout show;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            NameText=itemView.findViewById(R.id.showDriversItem_driverName);
            LineWorkeText=itemView.findViewById(R.id.showDriversItem_driverWork);
            show=itemView.findViewById(R.id.showdriver_listitems);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
