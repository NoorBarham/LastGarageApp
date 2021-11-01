package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    TextView personalpage,editpersonaldata,changepass,addnewmanager,addnwedriver,addnewcar,
            addnewline,addnewgarage,editlinedata,editgaragedata,editcardata,showdrivers,readcomplains,writecomplains,
            aboutapp;

    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        personalpage=findViewById(R.id.personal_page);
        editpersonaldata= findViewById(R.id.edit_personal_data);
        changepass=findViewById(R.id.change_pass);
        addnewmanager=findViewById(R.id.add_new_manager);
        addnwedriver=findViewById(R.id.add_new_driver);
        addnewcar=findViewById(R.id.add_new_car);
        addnewline=findViewById(R.id.add_new_line);
        addnewgarage=findViewById(R.id.add_new_garage);
        editlinedata=findViewById(R.id.edit_data_line);
        editgaragedata=findViewById(R.id.edit_data_garage);
        editcardata=findViewById(R.id.edit_data_car);
        showdrivers=findViewById(R.id.show_driver_list);
        readcomplains=findViewById(R.id.read_complain);
        writecomplains=findViewById(R.id.add_complain);
        aboutapp=findViewById(R.id.about);

        writecomplains.setBackgroundColor(Color.WHITE);
        personalpage.setBackgroundColor(Color.WHITE);
        editpersonaldata.setBackgroundColor(Color.WHITE);
        changepass.setBackgroundColor(Color.WHITE);
        addnewmanager.setBackgroundColor(Color.WHITE);
        addnwedriver.setBackgroundColor(Color.WHITE);
        addnewcar.setBackgroundColor(Color.WHITE);
        addnewline.setBackgroundColor(Color.WHITE);
        addnewgarage.setBackgroundColor(Color.WHITE);
        editlinedata.setBackgroundColor(Color.WHITE);
        editgaragedata.setBackgroundColor(Color.WHITE);
        editcardata.setBackgroundColor(Color.WHITE);
        showdrivers.setBackgroundColor(Color.WHITE);
        readcomplains.setBackgroundColor(Color.WHITE);
        aboutapp.setBackgroundColor(Color.WHITE);

        personalpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalpage.setBackgroundColor(0xFFFF6F00);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,personal_page.class);
                startActivity(intent);
            }
        });

        editpersonaldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editpersonaldata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,edit_personal_data.class);
                startActivity(intent);
            }
        });

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changepass.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,change_password.class);
                startActivity(intent);
            }
        });

        addnwedriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnwedriver.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,add_driver.class);
                startActivity(intent);
            }
        });
        addnewmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewmanager.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,add_driver.class);
                startActivity(intent);
            }
        });
        addnewline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewline.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,add_line.class);
                startActivity(intent);
            }
        });
        addnewgarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewgarage.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,add_garage.class);
                startActivity(intent);
            }
        });
        addnewcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewcar.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,add_car.class);
                startActivity(intent);
            }
        });
        editgaragedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editgaragedata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,edit_garage.class);
                startActivity(intent);
            }
        });
        editlinedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editlinedata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,edit_line.class);
                startActivity(intent);
            }
        });
        editcardata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editcardata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,edit_car_data.class);
                startActivity(intent);
            }
        });
        showdrivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdrivers.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,show_drivers.class);
                startActivity(intent);
            }
        });
        readcomplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readcomplains.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                Intent intent= new Intent(menu.this ,read_complaints.class);
                startActivity(intent);
            }
        });
        writecomplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writecomplains.setBackgroundColor(0xFFFF6F00);

                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,write_complaints.class);
                startActivity(intent);
            }
        });
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutapp.setBackgroundColor(0xFFFF6F00);

                personalpage.setBackgroundColor(Color.WHITE);
                editpersonaldata.setBackgroundColor(Color.WHITE);
                changepass.setBackgroundColor(Color.WHITE);
                addnewmanager.setBackgroundColor(Color.WHITE);
                addnwedriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showdrivers.setBackgroundColor(Color.WHITE);
                readcomplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);

            }
        });


//views in my actionbarPage
        homeIcon=findViewById(R.id.myActionBar_homeIcon);
        notificationIcon=findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon=findViewById(R.id.myActionBar_personIcon);
        messagesIcon=findViewById(R.id.myActionBar_messagesIcon);
        menuIcon=findViewById(R.id.myActionBar_menuIcon);

        menuIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this ,home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this ,notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this ,personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this ,messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this ,menu.class);
                startActivity(intent);
            }
        });
    }
}