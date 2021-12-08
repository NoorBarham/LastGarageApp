package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.itemClasses.notificationItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class admin_personal_page extends AppCompatActivity {
    ImageView homeIcon, notificationIcon, personalIcon, messagesIcon, menuIcon;
    TextView editData, changePass, u_name, u_city, u_phone, u_garage;

    ImageView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_personal_page);

        //views in adminPersonalPage
        editData = findViewById(R.id.adminPersonalPage_editData);
        changePass = findViewById(R.id.adminPersonalPage_changePass);
        textMessage = findViewById(R.id.adminPersonalPage_messageIcon);
        u_name = (TextView) findViewById(R.id.adminPersonalPage_name);
        u_city = findViewById(R.id.adminPersonalPage_placeVal);
        u_phone = findViewById(R.id.adminPersonalPage_phoneNumVal);
        u_garage = findViewById(R.id.adminPersonalPage_workplaceVal);

        selectadminPersonaldata("586");


        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_personal_page.this, edit_personal_data.class);
                startActivity(intent);
            }
        });

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_personal_page.this, change_password.class);
                startActivity(intent);
            }
        });

        textMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_personal_page.this, conversation.class);
                startActivity(intent);
            }
        });

        //views in my actionbarPage
        homeIcon = findViewById(R.id.myActionBar_homeIcon);
        notificationIcon = findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon = findViewById(R.id.myActionBar_personIcon);
        messagesIcon = findViewById(R.id.myActionBar_messagesIcon);
        menuIcon = findViewById(R.id.myActionBar_menuIcon);

        personalIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_personal_page.this, home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationIcon.setBackgroundColor(Color.WHITE);

                homeIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent = new Intent(admin_personal_page.this, notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalIcon.setBackgroundColor(Color.WHITE);

                notificationIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);
                Intent intent = new Intent(admin_personal_page.this, admin_personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messagesIcon.setBackgroundColor(Color.WHITE);

                //reset the color of the other icons
                notificationIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);
                menuIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent = new Intent(admin_personal_page.this, messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuIcon.setBackgroundColor(Color.WHITE);

                notificationIcon.setBackgroundColor(0xFFFF6F00);
                personalIcon.setBackgroundColor(0xFFFF6F00);
                messagesIcon.setBackgroundColor(0xFFFF6F00);
                homeIcon.setBackgroundColor(0xFFFF6F00);

                Intent intent = new Intent(admin_personal_page.this, menu.class);
                startActivity(intent);
            }
        });


    }
//2
    public void selectadminPersonaldata(String id) {
        String url = url_serverName.serverName + "adminPersonalpage.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //  Log.d("sss",response);
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("personal_admin");
                    notificationItem myItem;
                    for (int i = 0; i < jsonArray.length(); i++) {
/////////8
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String textName, String textNews, String textHour
                        String name = reader.getString("admin_name");
                        String phone = reader.getString("phone");
                        String city = reader.getString("city");
                        String garage_name = reader.getString("garage_name");

                        u_name.setText(name);
                        u_phone.setText(phone);
                        u_city.setText(city);
                        u_garage.setText(garage_name);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), error.getMessage() + "", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> myMap = new HashMap<>();
                myMap.put("admin_id", id);
                return myMap;
            }
        };
        my_singleton.getInstance(admin_personal_page.this).addToRequestQueue(myStringRequest);

    }

    }
