package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class line_status_list_item extends AppCompatActivity {


    private TextView lineItem_editIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_status_list_item);
//        lineItem_editIcon = (TextView) findViewById(R.id.lineItem_editIcon);

        lineItem_editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditLine_page();
            }
        });
    }
    public void openEditLine_page(){
        Intent intent = new Intent(this,edit_line.class);
        startActivity(intent);


    }

}
