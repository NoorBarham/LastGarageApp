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
import com.example.lastgarageapp.itemClasses.complainsItem;

import com.example.lastgarageapp.edit_garage;
import com.example.lastgarageapp.itemClasses.lineItem;
import com.example.lastgarageapp.view_notification;

import java.text.BreakIterator;
import java.util.ArrayList;

public class complainsAdapter extends RecyclerView.Adapter<complainsAdapter.complainsViewHolder> {

    private ArrayList<complainsItem> complainText;
   // private LayoutInflater mInflater;
    Context con;

    public complainsAdapter(Context context, ArrayList<complainsItem> complainText) {
        this.con=context;
        this.complainText=complainText;

       // this.mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public complainsAdapter.complainsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_read_complaints_list_item, parent, false);

       // View view= mInflater.inflate(R.layout.activity_read_complaints_list_item,parent,false);
      //  complainsViewHolder holder =new complainsViewHolder(view);

        complainsAdapter.complainsViewHolder holder = new complainsAdapter.complainsViewHolder(view);
        return holder;
          }

    @Override
    public void onBindViewHolder(@NonNull complainsViewHolder holder, int position) {
        complainsItem l = complainText.get(position);

       // String complain= complainText.get(position);
        holder.complainText.setText(l.getcomplainText());

    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return complainText.size();
    }

    public class complainsViewHolder extends RecyclerView.ViewHolder{
        TextView complainText;


        public complainsViewHolder(@NonNull View itemView) {
            super(itemView);
            complainText=itemView.findViewById(R.id.readComplaints_Text);


        }

    }
}
