package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lastgarageapp.adapter.complainsAdapter;
import com.example.lastgarageapp.adapter.lineAdapter;
import com.example.lastgarageapp.adapter.messengerAdapter;
import com.example.lastgarageapp.itemClasses.complainsItem;
import com.example.lastgarageapp.itemClasses.garageItem;
import com.example.lastgarageapp.itemClasses.lineItem;

import java.util.ArrayList;

public class read_complaints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_complaints);

        //recyclerView
        ArrayList<complainsItem> complainsArray= new ArrayList<>();

        complainsAdapter comp_adapter=new complainsAdapter(read_complaints.this,complainsArray);
        complainsItem l=new complainsItem("Horse");
        complainsArray.add(l);

        //animalNames.add("Horse");
        //animalNames.add("Cow");
        //animalNames.add("Camel");
        //animalNames.add("Sheep");
        //animalNames.add("Goat");


        complainsAdapter adapter;


        RecyclerView complainRecyclerView = findViewById(R.id.complains_recyview);
        complainRecyclerView.setLayoutManager(new LinearLayoutManager(read_complaints.this));
        adapter = new complainsAdapter(this, complainsArray);
       complainRecyclerView.setAdapter(adapter);
    }
}