package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_page extends AppCompatActivity {

    Button newsButt, statusButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        newsButt=findViewById(R.id.homePage_newsButt);
        statusButt=findViewById(R.id.homePage_statusButt);

        newsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsButt.setBackgroundColor(0xFF000000);
                newsButt.setTextColor(0xFFFF6F00);
                Intent intent= new Intent(home_page.this ,news.class);
                startActivity(intent);
            }
        });
    }
}