package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class car_status_list_item extends AppCompatActivity {

    private TextView carItem_editIcon;
    private TextView car_no;
    public static String carNomber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_status_list_item);
//        carItem_editIcon = (TextView) findViewById(R.id.carItem_editIcon);
        car_no=(TextView) findViewById(R.id.carItem_carNumber);
        carNomber=car_no.getText().toString();
        carItem_editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditCarData_page();
            }
        });
    }
    public void openEditCarData_page(){
        Intent intent = new Intent(this,edit_car_data.class);
        startActivity(intent);


    }

}
