package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_driver extends AppCompatActivity {

    private Button addDriver_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        addDriver_cancel = (Button) findViewById(R.id.addDriver_cancel);

        addDriver_cancel.setOnClickListener(new View.OnClickListener() {
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
