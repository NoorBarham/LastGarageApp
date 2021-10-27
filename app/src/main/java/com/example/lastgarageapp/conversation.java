package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.lastgarageapp.adapter.messageAdapter;

import java.util.ArrayList;

public class conversation extends AppCompatActivity {

//    private ArrayList<String> MessagesTexts = new ArrayList<>();
//    private ArrayList<String> HoureTexts = new ArrayList<>();
//    private ArrayList<String> AM_PM_Texts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        ArrayList<String> animalNames2 = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        ArrayList<String> animalNames3 = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        messageAdapter adapter;

        RecyclerView myRecyclerView = findViewById(R.id.converRecyView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new messageAdapter(this,animalNames,animalNames2, animalNames3);
        myRecyclerView.setAdapter(adapter);
    }


}