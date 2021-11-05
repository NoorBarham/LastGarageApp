package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lastgarageapp.adapter.messengerAdapter;
import com.example.lastgarageapp.adapter.notificationAdapter;

import java.util.ArrayList;

public class messages extends AppCompatActivity {

    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        //views in my actionbarPage
        homeIcon=findViewById(R.id.myActionBar_homeIcon);
        notificationIcon=findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon=findViewById(R.id.myActionBar_personIcon);
        messagesIcon=findViewById(R.id.myActionBar_messagesIcon);
        menuIcon=findViewById(R.id.myActionBar_menuIcon);

        messagesIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,menu.class);
                startActivity(intent);
            }
        });
        //recyclerView
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        ArrayList<String> animalNames2 = new ArrayList<>();
        animalNames2.add("Horse");
        animalNames2.add("Cow");
        animalNames2.add("Camel");
        animalNames2.add("Sheep");
        animalNames2.add("Goat");

        ArrayList<String> animalNames3 = new ArrayList<>();
        animalNames3.add("Horse");
        animalNames3.add("Cow");
        animalNames3.add("Camel");
        animalNames3.add("Sheep");
        animalNames3.add("Goat");

        messengerAdapter adapter;


        RecyclerView messengerRecyclerView = findViewById(R.id.message_recyview);
        messengerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new messengerAdapter(this, animalNames, animalNames2, animalNames3);
        messengerRecyclerView.setAdapter(adapter);
    }
}