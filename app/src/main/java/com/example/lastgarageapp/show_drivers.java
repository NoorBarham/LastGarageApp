package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lastgarageapp.adapter.complainsAdapter;
import com.example.lastgarageapp.adapter.showdriverAdapter;
import com.example.lastgarageapp.itemClasses.complainsItem;
import com.example.lastgarageapp.itemClasses.showDriversItem;

import java.util.ArrayList;

public class show_drivers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_drivers);

        ArrayList<showDriversItem> showArray = new ArrayList<>();

        showdriverAdapter show_adapter=new showdriverAdapter(show_drivers.this, showArray);
        showDriversItem l=new showDriversItem("Horse","hh");
        showArray.add(l);


        showdriverAdapter adapter;


        RecyclerView showRecyclerView = findViewById(R.id.showdriver_recycler);
        showRecyclerView.setLayoutManager(new LinearLayoutManager(show_drivers.this));
        adapter = new showdriverAdapter(this, showArray);
        showRecyclerView.setAdapter(adapter);

       // ArrayList<String> animalNames = new ArrayList<>();
       // animalNames.add("Horse");
        //animalNames.add("Cow");
        //animalNames.add("Camel");
        //animalNames.add("Sheep");
        //animalNames.add("Goat");

       // ArrayList<String> animalNames2 = new ArrayList<>();
        //animalNames2.add("Horse");
        //animalNames2.add("Cow");
        //animalNames2.add("Camel");
        //animalNames2.add("Sheep");
        //animalNames2.add("Goat");

      //  ArrayList<String> animalNames3 = new ArrayList<>();
        //animalNames3.add("Horse");
        //animalNames3.add("Cow");
        //animalNames3.add("Camel");
        //animalNames3.add("Sheep");
        //animalNames3.add("Goat");

    }
}