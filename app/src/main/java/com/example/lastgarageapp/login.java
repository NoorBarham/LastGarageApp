package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    private Button login_loginClient;
    private Button login_loginAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_loginClient = (Button) findViewById(R.id.login_loginClient);
        login_loginAdmin = (Button) findViewById(R.id.login_loginClient);

        login_loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();
            }
        });
        login_loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();
            }
        });
    }

    public void openhome_page(){
        Intent intent = new Intent(this,home_page.class);
        startActivity(intent);


    }
}