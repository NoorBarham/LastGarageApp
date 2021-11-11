package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class edit_line extends AppCompatActivity {


    private Button editLine_cancelButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_line);
        editLine_cancelButt = (Button) findViewById(R.id.editLine_cancelButt);

        editLine_cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              finish();

            }
        });
    }



    }


