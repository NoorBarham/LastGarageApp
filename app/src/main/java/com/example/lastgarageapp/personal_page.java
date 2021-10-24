package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class personal_page extends AppCompatActivity {

    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;
    TextView editData,changePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);

        //views in personalPage
        editData = findViewById(R.id.personalPage_editData);
        changePass = findViewById(R.id.personalPage_changePass);

        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(personal_page.this ,edit_personal_data.class);
                startActivity(intent);
            }
        });

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(personal_page.this ,change_password.class);
                startActivity(intent);
            }
        });


        //views in my actionbarPage
        homeIcon=findViewById(R.id.myActionBar_homeIcon);
        notificationIcon=findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon=findViewById(R.id.myActionBar_personIcon);
        messagesIcon=findViewById(R.id.myActionBar_messagesIcon);
        menuIcon=findViewById(R.id.myActionBar_menuIcon);

        personalIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(personal_page.this ,home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationIcon.setBackgroundColor(Color.WHITE);

                homeIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent= new Intent(personal_page.this ,notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalIcon.setBackgroundColor(Color.WHITE);

                notificationIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);
                Intent intent= new Intent(personal_page.this ,personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messagesIcon.setBackgroundColor(Color.WHITE);

                //reset the color of the other icons
                notificationIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent= new Intent(personal_page.this ,messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuIcon.setBackgroundColor(Color.WHITE);

                notificationIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent= new Intent(personal_page.this ,menu.class);
                startActivity(intent);
            }
        });
    }
}