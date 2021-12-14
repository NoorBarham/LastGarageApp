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


        lineItem_editIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditLine_page();
            }
        });

        lineItem_deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(line_status_list_item.this);
                alert.setTitle("تأكيد الحذف");
                alert.setMessage("هل تريد تأكيد الحذف؟");
                alert.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(line_status_list_item.this, "تم الحذف",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setPositiveButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(line_status_list_item.this, "تم التراجع",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();

            }
        });
    }
    public void openEditLine_page(){
        Intent intent = new Intent(this,edit_line.class);
        startActivity(intent);


    }

}
