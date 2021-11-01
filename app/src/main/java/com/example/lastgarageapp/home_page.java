package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lastgarageapp.adapter.newsAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class home_page extends AppCompatActivity {
    private ArrayList<String> textNames =new ArrayList<>();
    private ArrayList<String> textNews=new ArrayList<>();
    private ArrayList<String> textHours=new ArrayList<>();
    Button newsButt, statusButt;
    Spinner dest,sour;
    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;
//    LinearLayout l;
//    ListView myList;
    TextView addNewstext;
    Button add;
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    LinearLayout l4;
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
        addNewstext=findViewById(R.id.homePage_addnewstext);
        add=findViewById(R.id.homePage_addButt);
        l1=findViewById(R.id.linear1);
        l2=findViewById(R.id.linear2);
        l3=findViewById(R.id.linear3);
        l4=findViewById(R.id.linear4);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusButt.setBackgroundColor(0xFFFF6F00);
                statusButt.setTextColor(Color.WHITE);
                newsButt.setBackgroundColor(Color.WHITE);
                newsButt.setTextColor(0xFFFF6F00);



                final StringBuilder sb = new StringBuilder(addNewstext.getText().length());
                sb.append(addNewstext.getText());
                String s= sb.toString();
                textNews.add(addNewstext.getText().toString());

                TimeZone.setDefault(TimeZone.getTimeZone("GMT" + "02:00"));
                Date currentTime = Calendar.getInstance().getTime();
                String timeStamp = new SimpleDateFormat("HH:mm").format(currentTime);
                textHours.add(timeStamp);

                textNames.add("Alice");

                newsAdapter adapter;
                RecyclerView myRecyclerView = findViewById(R.id.homePage_recycler);
                adapter = new newsAdapter(home_page.this,textNames,textNews,textHours);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(home_page.this));
                myRecyclerView.setAdapter(adapter);
                addNewstext.setText("");


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