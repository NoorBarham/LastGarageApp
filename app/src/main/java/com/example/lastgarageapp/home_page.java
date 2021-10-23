package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

public class home_page extends AppCompatActivity {

    Button newsButt, statusButt;
    Spinner dest,sour;
    LinearLayout l;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        newsButt=findViewById(R.id.homePage_newsButt);
        statusButt=findViewById(R.id.homePage_statusButt);
        dest =findViewById(R.id.homePage_destination);
        sour =findViewById(R.id.homePage_source);
//        l=findViewById(R.id.mylll);
//        l.addView(findViewById(R.id.carStatus_layout));
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
    }
}