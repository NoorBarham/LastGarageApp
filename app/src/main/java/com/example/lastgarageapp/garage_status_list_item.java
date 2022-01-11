package com.example.lastgarageapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class garage_status_list_item extends AppCompatActivity {

    private TextView garageItem_deleteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_status_list_item);
        garageItem_deleteIcon = (TextView) findViewById(R.id.garageItem_deleteIcon);



        garageItem_deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(garage_status_list_item.this);
                alert.setTitle("تأكيد الحذف");
                alert.setMessage("هل تريد تأكيد الحذف؟");
                alert.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(garage_status_list_item.this, "تم الحذف",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setPositiveButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(garage_status_list_item.this, "تم التراجع",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();

            }
        });


    }

}


