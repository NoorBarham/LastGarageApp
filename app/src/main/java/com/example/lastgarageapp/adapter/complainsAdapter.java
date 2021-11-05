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

public class complainsAdapter extends RecyclerView.Adapter<complainsAdapter.complainsViewHolder> {

    private ArrayList<String> complainText;
    private LayoutInflater mInflater;
    Context con;

    public complainsAdapter(Context context, ArrayList<String> complain) {
        this.complainText=complain;
        this.con=context;
        this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public complainsAdapter.complainsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.activity_read_complaints_list_item,parent,false);
        complainsViewHolder holder =new complainsViewHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull complainsViewHolder holder, int position) {
        String complain= complainText.get(position);
        holder.Complain.setText(complain);

    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return complainText.size();
    }

    public class complainsViewHolder extends RecyclerView.ViewHolder{
        TextView Complain;


        public complainsViewHolder(@NonNull View itemView) {
            super(itemView);
            Complain=itemView.findViewById(R.id.readComplaints_Text);


        }

    }
}
