package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lastgarageapp.adapter.notificationAdapter;
import com.example.lastgarageapp.itemClasses.notificationItem;

import java.util.ArrayList;

public class notifications extends AppCompatActivity {

    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        //views in my actionbarPage
        homeIcon=findViewById(R.id.myActionBar_homeIcon);
        notificationIcon=findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon=findViewById(R.id.myActionBar_personIcon);
        messagesIcon=findViewById(R.id.myActionBar_messagesIcon);
        menuIcon=findViewById(R.id.myActionBar_menuIcon);

        notificationIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(notifications.this ,home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(notifications.this ,notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(notifications.this ,personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(notifications.this ,messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(notifications.this ,menu.class);
                startActivity(intent);
            }
        });
/// recycleview
        notificationItem n=new notificationItem("waed","10:30");
        ArrayList<notificationItem>myNotificationItem=new ArrayList<>();
        myNotificationItem.add(n);
        myNotificationItem.add(n);


        notificationAdapter adapter;


        RecyclerView myRecyclerView = findViewById(R.id.notoRecyView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new notificationAdapter(this, myNotificationItem);
        myRecyclerView.setAdapter(adapter);
    }
}