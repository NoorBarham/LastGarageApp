package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_garage extends AppCompatActivity {

    private Button addGarage_cancelButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_garage);
        addGarage_cancelButt = (Button) findViewById(R.id.addGarage_cancelButt);

        addGarage_cancelButt.setOnClickListener(new View.OnClickListener() {
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
