package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lastgarageapp.adapter.newsAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class news extends AppCompatActivity {
    private ArrayList<String> textName = new ArrayList<>();
    private ArrayList<String> textHour = new ArrayList<>();
    private ArrayList<String> textNews = new ArrayList<>();
    Button add;
    TextView add_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        add=findViewById(R.id.Add_news);
        add_news = findViewById(R.id.news_addNew);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringBuilder sb = new StringBuilder(add_news.getText().length());
                sb.append(add_news.getText());
                String s= sb.toString();

                Date currentTime = Calendar.getInstance().getTime();


                textNews.add(s);
                textHour.add(currentTime.toString());


                newsAdapter adapter;
                RecyclerView myRecyclerView = findViewById(R.id.news_recyview);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(news.this));
                adapter = new newsAdapter(news.this,textName,textNews,textHour);
                myRecyclerView.setAdapter(adapter);
                add_news.setText("");
            }
        });
    }
}