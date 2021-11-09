package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_car extends AppCompatActivity {
    private Button addCar_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        addCar_cancel = (Button) findViewById(R.id.addCar_cancel);

        addCar_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();
            }
        });
    }
    public void openhome_page(){
        Intent intent = new Intent(this,car_status.class);
        startActivity(intent);


    }

}
