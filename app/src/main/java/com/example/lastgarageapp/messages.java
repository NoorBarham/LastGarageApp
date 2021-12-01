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
import com.example.lastgarageapp.itemClasses.messengerItem;

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
        });///// its okkkkkkkkk hhhhhhhhhhhhhhhh
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(messages.this ,menu.class);
                startActivity(intent);
            }
        });
        //recyclerView
        messengerItem m=new messengerItem("waed","hi","10:30");
        ArrayList<messengerItem> messangerArray= new ArrayList<>();
        messangerArray.add(m);
        messangerArray.add(m);
        messengerAdapter m_adapter;


        RecyclerView messengerRecyclerView = findViewById(R.id.message_recyview);
        messengerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        m_adapter = new messengerAdapter(this, messangerArray);
        messengerRecyclerView.setAdapter(m_adapter);
    }
}