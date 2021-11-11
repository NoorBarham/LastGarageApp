package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_garage extends AppCompatActivity {

    private Button addGarage_cancelButt,addGarage_addButt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_garage);

        addGarage_cancelButt = (Button) findViewById(R.id.addGarage_cancelButt);
        addGarage_addButt= (Button) findViewById(R.id.addGarage_addButt);

        addGarage_addButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = url_serverName.serverName+"login.php";


            }
        });

        addGarage_cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
