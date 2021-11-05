package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lastgarageapp.adapter.complainsAdapter;
import com.example.lastgarageapp.adapter.messengerAdapter;

import java.util.ArrayList;

public class read_complaints extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_complaints);

        //recyclerView
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");


        complainsAdapter adapter;


        RecyclerView complainRecyclerView = findViewById(R.id.complains_recyview);
        complainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new complainsAdapter(this, animalNames);
        complainRecyclerView.setAdapter(adapter);
    }
}