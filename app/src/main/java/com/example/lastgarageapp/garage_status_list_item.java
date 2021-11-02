package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class garage_status_list_item extends AppCompatActivity {


    private TextView garageItem_editIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_status_list_item);
        garageItem_editIcon = (TextView) findViewById(R.id.garageItemSwap_editIcon);

        garageItem_editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditGarage_page();
            }
        });
    }
    public void openEditGarage_page(){
        Intent intent = new Intent(this,edit_garage.class);
        startActivity(intent);


    }

}
