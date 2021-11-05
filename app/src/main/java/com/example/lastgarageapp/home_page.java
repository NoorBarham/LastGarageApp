package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.lastgarageapp.adapter.carAdapter;
import com.example.lastgarageapp.adapter.garageAdapter;
import com.example.lastgarageapp.adapter.newsAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class home_page extends AppCompatActivity {

    Button newsButt, statusButt;
    Spinner dest,sour;
    TextView addNewstext;
    Button addNewsButt;
    LinearLayout newsLayout, carStatusLayout, garageLineStatusLayout, myRecycleLayout;
    TextView iconAddgarage;
    TextView iconAddcar;
    TextView iconFilter;

    //my actionbar
    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //views in homePage
        newsButt=findViewById(R.id.homePage_newsButt);
        statusButt=findViewById(R.id.homePage_statusButt);
        dest =findViewById(R.id.homePage_destination);
        sour =findViewById(R.id.homePage_source);

        newsLayout=findViewById(R.id.homePage_newsLayout);
        carStatusLayout=findViewById(R.id.homePage_carStatusLayout);
        garageLineStatusLayout=findViewById(R.id.homePage_garageLineStatusLayout);
        myRecycleLayout=findViewById(R.id.homePage_RecycleLayout);

        //news layout
        addNewstext=findViewById(R.id.homePage_addnewstext);
        addNewsButt=findViewById(R.id.homePage_addNewsButt);

        //garageLine layout
        iconAddgarage=findViewById(R.id.homePage_addGarageLineIcon);
        iconAddcar=findViewById(R.id.homePage_addCarIcon);
        iconFilter=findViewById(R.id.homePage_filterCar);

        //default
        statusButt.setBackgroundColor(0xFFFF6F00);
        statusButt.setTextColor(Color.WHITE);
        newsButt.setBackgroundColor(Color.WHITE);
        newsButt.setTextColor(0xFFFF6F00);

        newsLayout.setVisibility(View.VISIBLE);
        garageLineStatusLayout.setVisibility(View.GONE);
        carStatusLayout.setVisibility(View.GONE);
        //

        //for recycleView
        //news
        ArrayList<String> textNames =new ArrayList<>();
        ArrayList<String> textNews=new ArrayList<>();
        ArrayList<String> textHours=new ArrayList<>();
        //garage
        ArrayList<String> toHoure= new ArrayList<>();
        ArrayList<String> fromHoure= new ArrayList<>();
        ArrayList<String> noOfCars= new ArrayList<>();
        ArrayList<String> adminName= new ArrayList<>();
        ArrayList<String> cityName = new ArrayList<>();
        //car
        ArrayList<String> timeExpected= new ArrayList<>();
        ArrayList<String> nameDriver= new ArrayList<>();
        ArrayList<String> noOfpassedngers= new ArrayList<>();
        ArrayList<String> carAvailability= new ArrayList<>();


        ArrayList<String> LineName= new ArrayList<>();
        ArrayList<String> LineFare= new ArrayList<>();


        newsAdapter adapter1 = new newsAdapter(home_page.this,textNames,textNews,textHours);
        garageAdapter adapter2= new garageAdapter(home_page.this, cityName,adminName ,noOfCars,fromHoure, toHoure );
        carAdapter adapter3= new carAdapter(home_page.this, nameDriver,carAvailability ,noOfpassedngers,timeExpected);
        RecyclerView recyclerView = findViewById(R.id.homePage_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(home_page.this));

        //default Adapter
        recyclerView.setAdapter(adapter1);

        newsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusButt.setBackgroundColor(0xFFFF6F00);
                statusButt.setTextColor(Color.WHITE);
                newsButt.setBackgroundColor(Color.WHITE);
                newsButt.setTextColor(0xFFFF6F00);

                newsLayout.setVisibility(View.VISIBLE);
                garageLineStatusLayout.setVisibility(View.GONE);
                carStatusLayout.setVisibility(View.GONE);

                recyclerView.setAdapter(adapter1);

            }
        });
        addNewsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringBuilder sb = new StringBuilder(addNewstext.getText().length());
                sb.append(addNewstext.getText());
                String s= sb.toString();
                textNews.add(addNewstext.getText().toString());

                TimeZone.setDefault(TimeZone.getTimeZone("GMT" + "02:00"));
                Date currentTime = Calendar.getInstance().getTime();
                String timeStamp = new SimpleDateFormat("HH:mm").format(currentTime);
                textHours.add(timeStamp);

                textNames.add("Alice");
                addNewstext.setText("");

            }
        });

        statusButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newsButt.setBackgroundColor(0xFFFF6F00);
                newsButt.setTextColor(Color.WHITE);
                statusButt.setBackgroundColor(Color.WHITE);
                statusButt.setTextColor(0xFFFF6F00);

                if(!sour.getSelectedItem().equals("المكان الحالي")){
                    if(!dest.getSelectedItem().equals("الوجهة")){
//                        intent= new Intent(home_page.this ,car_status.class);
                        garageLineStatusLayout.setVisibility(View.GONE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.VISIBLE);

                        nameDriver.add("أحمد محمد");
                        timeExpected.add("6:00 AM");
                        noOfpassedngers.add("7");
                        carAvailability.add("متوفرة");

                        recyclerView.setAdapter(adapter3);
                    }else{
//                        intent= new Intent(home_page.this ,line_status.class);
                        garageLineStatusLayout.setVisibility(View.VISIBLE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.GONE);
                        LineName.add("طولكرم- قلقيلية");
                        LineFare.add("5");

                    }

                }else{
//                    intent= new Intent(home_page.this ,garage_status.class);
                    garageLineStatusLayout.setVisibility(View.VISIBLE);
                    newsLayout.setVisibility(View.GONE);
                    carStatusLayout.setVisibility(View.GONE);

                    toHoure.add("6:00 PM");
                    fromHoure.add("6:00 AM");
                    noOfCars.add("15");
                    adminName.add("أحمد محمد");
                    cityName.add("قلقيلية");

                    recyclerView.setAdapter(adapter2);

                }
            }
        });
        //-
        iconAddgarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,add_garage.class);
                startActivity(intent);

            }
        });

        iconAddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this ,add_car.class);
                startActivity(intent);

            }
        });

        //my actionbarPage
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