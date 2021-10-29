package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lastgarageapp.adapter.messageAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class conversation extends AppCompatActivity {

    private ArrayList<String> MessagesTexts = new ArrayList<>();
    private ArrayList<String> HoureTexts = new ArrayList<>();

    ImageView conversation_send_icon;
    TextView conversation_addText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        conversation_addText=findViewById(R.id.conversation_addText);
        conversation_send_icon = findViewById(R.id.conversation_send_icon);
        conversation_send_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringBuilder sb = new StringBuilder(conversation_addText.getText().length());
                sb.append(conversation_addText.getText());
                String s= sb.toString();

                Date currentTime = Calendar.getInstance().getTime();


                MessagesTexts.add(s);
                HoureTexts.add(currentTime.toString());

                messageAdapter adapter;
                RecyclerView myRecyclerView = findViewById(R.id.converRecyView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(conversation.this));
                adapter = new messageAdapter(conversation.this,MessagesTexts,HoureTexts);
                myRecyclerView.setAdapter(adapter);
                conversation_addText.setText("");
            }
        });

//        MessagesTexts.add("مرحبا");
//        HoureTexts.add("12:12");
//        AM_PM_Texts.add("AM");
//
//        messageAdapter adapter;
//
//        RecyclerView myRecyclerView = findViewById(R.id.converRecyView);
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new messageAdapter(this,MessagesTexts,HoureTexts, AM_PM_Texts);
//        myRecyclerView.setAdapter(adapter);
    }


}