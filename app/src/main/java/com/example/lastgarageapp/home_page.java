package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class home_page extends AppCompatActivity {

    Button newsButt, statusButt;
    Spinner dest,sour;
    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;
//    LinearLayout l;
//    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        Toolbar myttt = (Toolbar)findViewById(R.id.myActionbar);
//        getSupportActionBar();
//        l=findViewById(R.id.mylll);
//        l.addView(findViewById(R.id.carStatus_layout));

        //views in homePage
        newsButt=findViewById(R.id.homePage_newsButt);
        statusButt=findViewById(R.id.homePage_statusButt);
        dest =findViewById(R.id.homePage_destination);
        sour =findViewById(R.id.homePage_source);


        newsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusButt.setBackgroundColor(0xFFFF6F00);
                statusButt.setTextColor(Color.WHITE);
                newsButt.setBackgroundColor(Color.WHITE);
                newsButt.setTextColor(0xFFFF6F00);

                Intent intent= new Intent(home_page.this ,news.class);
                startActivity(intent);
            }
        });

        statusButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                newsButt.setBackgroundColor(0xFFFF6F00);
                newsButt.setTextColor(Color.WHITE);
                statusButt.setBackgroundColor(Color.WHITE);
                statusButt.setTextColor(0xFFFF6F00);

                if(!sour.getSelectedItem().equals("المكان الحالي")){
                    if(!dest.getSelectedItem().equals("الوجهة")){
                        intent= new Intent(home_page.this ,car_status.class);
                    }else{
                        intent= new Intent(home_page.this ,line_status.class);
                    }

                }else{
                    intent= new Intent(home_page.this ,garage_status.class);
                }
                startActivity(intent);

            }
        });

        //views in my actionbarPage
        homeIcon=findViewById(R.id.myActionBar_homeIcon);
        notificationIcon=findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon=findViewById(R.id.myActionBar_personIcon);
        messagesIcon=findViewById(R.id.myActionBar_messagesIcon);
        menuIcon=findViewById(R.id.myActionBar_menuIcon);

        homeIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,news.class);
                startActivity(intent);


            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,menu.class);
                startActivity(intent);
            }
        });
//        ArrayList<String> animalNames = new ArrayList<>();
//        animalNames.add("Horse");
//        animalNames.add("Cow");
//        animalNames.add("Camel");
//        animalNames.add("Sheep");
//        animalNames.add("Goat");
//
//
//        driverAdapter adapter;
//
//        RecyclerView recyclerView = findViewById(R.id.recycle_1);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new driverAdapter(this, animalNames);
//        recyclerView.setAdapter(adapter);
    }

}