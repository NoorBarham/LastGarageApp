package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class change_password extends AppCompatActivity {
    Button changePass_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        changePass_cancel = (Button) findViewById(R.id.changePass_cancel);

        changePass_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPersonal_page();
            }
        });

    }
    public void openPersonal_page(){
        Intent intent = new Intent(this,personal_page.class);
        startActivity(intent);
    }
    }
