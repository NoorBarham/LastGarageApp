package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class line_status extends AppCompatActivity {

    TextView addIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_status);

        addIcon=findViewById(R.id.lineStatus_addIcon);

        addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(line_status.this ,add_line.class);
                startActivity(intent);
            }
        });
    }
}