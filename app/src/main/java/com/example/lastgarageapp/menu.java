package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    TextView personalpage,adminPersonalpage,
            addDriver,addManager, addnewcar, addnewline, addnewgarage,
            editlinedata,editgaragedata,editcardata,
            showDrivers, readComplains,writecomplains,
            aboutapp, settings,logout;
    TextView other;
    LinearLayout personalLayout, addLayout, editLayout;

    ImageView homeIcon,notificationIcon,personalIcon,messagesIcon,menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        personalpage=findViewById(R.id.driver_personal_page);
        adminPersonalpage=findViewById(R.id.admin_personal_page);

        addDriver=findViewById(R.id.add_new_driver);
        addManager=findViewById(R.id.add_new_manager);
        addnewcar=findViewById(R.id.add_new_car);
        addnewline=findViewById(R.id.add_new_line);
        addnewgarage=findViewById(R.id.add_new_garage);

        editlinedata=findViewById(R.id.edit_data_line);
        editgaragedata=findViewById(R.id.edit_data_garage);
        editcardata=findViewById(R.id.edit_data_car);

        personalLayout=findViewById(R.id.personalLayout);
        addLayout =findViewById(R.id.addLayout);
        editLayout =findViewById(R.id.editLayout);
        personalLayout=findViewById(R.id.personalLayout);
        other=findViewById(R.id.other);
        showDrivers =findViewById(R.id.show_driver_list);
        readComplains =findViewById(R.id.read_complain);
        writecomplains=findViewById(R.id.add_complain);
        aboutapp=findViewById(R.id.about);
        settings = findViewById(R.id.settings);
        logout = findViewById(R.id.logout);

        personalpage.setBackgroundColor(Color.WHITE);
        addDriver.setBackgroundColor(Color.WHITE);
        addManager.setBackgroundColor(Color.WHITE);
        addnewcar.setBackgroundColor(Color.WHITE);
        addnewline.setBackgroundColor(Color.WHITE);
        addnewgarage.setBackgroundColor(Color.WHITE);
        editlinedata.setBackgroundColor(Color.WHITE);
        editgaragedata.setBackgroundColor(Color.WHITE);
        editcardata.setBackgroundColor(Color.WHITE);
        showDrivers.setBackgroundColor(Color.WHITE);
        readComplains.setBackgroundColor(Color.WHITE);
        writecomplains.setBackgroundColor(Color.WHITE);
        aboutapp.setBackgroundColor(Color.WHITE);
        settings.setBackgroundColor(Color.WHITE);
        logout.setBackgroundColor(Color.WHITE);


        adminPersonalpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminPersonalpage.setBackgroundColor(0xFFFF6F00);
                //editpersonaldata.setBackgroundColor(Color.WHITE);
                //changepass.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,admin_personal_page.class);
                startActivity(intent);
            }
        });
        personalpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalpage.setBackgroundColor(0xFFFF6F00);
                //editpersonaldata.setBackgroundColor(Color.WHITE);
                //changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,personal_page.class);
                startActivity(intent);
            }
        });

        addDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDriver.setBackgroundColor(0xFFFF6F00);
                //editpersonaldata.setBackgroundColor(Color.WHITE);
                //changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,add_driver.class);
                startActivity(intent);
            }
        });




        addManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addManager.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);



                Intent intent= new Intent(menu.this ,add_admin.class);
                startActivity(intent);
            }
        });
        addnewline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewline.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,add_line.class);
                startActivity(intent);
            }
        });
        addnewgarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewgarage.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,add_garage.class);
                startActivity(intent);
            }
        });
        addnewcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnewcar.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
           //     editpersonaldata.setBackgroundColor(Color.WHITE);
             //   changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,add_car.class);
                startActivity(intent);

            }
        });
        editgaragedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editgaragedata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
               // editpersonaldata.setBackgroundColor(Color.WHITE);
                //changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,edit_garage.class);
                startActivity(intent);
            }
        });
        editlinedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editlinedata.setBackgroundColor(0xFFFF6F00);
                //personalpage.setBackgroundColor(Color.WHITE);
                //editpersonaldata.setBackgroundColor(Color.WHITE);
               // changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,edit_line.class);
                startActivity(intent);

            }
        });
        editcardata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editcardata.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                //editpersonaldata.setBackgroundColor(Color.WHITE);
                //changepass.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,edit_car_data.class);
                startActivity(intent);
            }
        });
        showDrivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDrivers.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,show_drivers.class);
                startActivity(intent);
            }
        });
        readComplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readComplains.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


                Intent intent= new Intent(menu.this ,read_complaints.class);
                startActivity(intent);
            }
        });
        writecomplains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writecomplains.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);



                Intent intent= new Intent(menu.this ,write_complaints.class);
                startActivity(intent);
            }
        });
        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutapp.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);


            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setBackgroundColor(0xFFFF6F00);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                personalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                logout.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,settings.class);
                startActivity(intent);
            }
        });
        //4

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logout.setBackgroundColor(0xFFFF6F00);
                personalpage.setBackgroundColor(Color.WHITE);
                adminPersonalpage.setBackgroundColor(Color.WHITE);
                addDriver.setBackgroundColor(Color.WHITE);
                addManager.setBackgroundColor(Color.WHITE);
                addnewcar.setBackgroundColor(Color.WHITE);
                addnewline.setBackgroundColor(Color.WHITE);
                addnewgarage.setBackgroundColor(Color.WHITE);
                editlinedata.setBackgroundColor(Color.WHITE);
                editgaragedata.setBackgroundColor(Color.WHITE);
                editcardata.setBackgroundColor(Color.WHITE);
                showDrivers.setBackgroundColor(Color.WHITE);
                readComplains.setBackgroundColor(Color.WHITE);
                writecomplains.setBackgroundColor(Color.WHITE);
                aboutapp.setBackgroundColor(Color.WHITE);
                settings.setBackgroundColor(Color.WHITE);

                Intent intent= new Intent(menu.this ,login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
//    private void getLogin(){
//        if (login.myUser!=null){
//
//        }else{
////            notificationIcon.setVisibility(View.GONE);
////            personalIcon.setVisibility(View.GONE);
////            messagesIcon.setVisibility(View.GONE);
//            personalLayout.setVisibility(View.GONE);
//            addLayout.setVisibility(View.GONE);
//            editLayout.setVisibility(View.GONE);
//            other.setVisibility(View.GONE);
//            settings.setVisibility(View.GONE);
//            showDrivers.setVisibility(View.GONE);
//            readComplains.setVisibility(View.GONE);
//            logout.setVisibility(View.GONE);
//
//        }
//    }
}
