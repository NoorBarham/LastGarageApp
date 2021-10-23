package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_line extends AppCompatActivity {

    private Button addLine_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_line);
        addLine_cancle = (Button) findViewById(R.id.addLine_cancle);

        addLine_cancle.setOnClickListener(new View.OnClickListener() {
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
