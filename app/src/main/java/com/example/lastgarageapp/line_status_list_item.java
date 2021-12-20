package com.example.lastgarageapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class line_status_list_item extends AppCompatActivity {


    private TextView lineItem_editIcon;
    private TextView lineItem_deleteIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_status_list_item);
//        lineItem_editIcon = (TextView) findViewById(R.id.lineItem_editIcon);
        lineItem_deleteIcon = (TextView) findViewById(R.id.lineItem_deleteIcon);

        lineItem_deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
    public void openEditLine_page(){
        Intent intent = new Intent(this,edit_line.class);
        startActivity(intent);


    }

}
