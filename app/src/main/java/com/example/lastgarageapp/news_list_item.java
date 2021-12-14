package com.example.lastgarageapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class news_list_item extends AppCompatActivity {
    private TextView newsItem_delet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list_item);
        newsItem_delet= (TextView) findViewById(R.id.newsItem_delet);


        newsItem_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(news_list_item.this);
                alert.setTitle("تأكيد الحذف");
                alert.setMessage("هل تريد تأكيد الحذف؟");
                alert.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(news_list_item.this, "تم الحذف",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setPositiveButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(news_list_item.this, "تم التراجع",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();

            }
        });

    }
}