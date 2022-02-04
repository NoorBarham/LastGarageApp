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

public class boss_personal_page extends AppCompatActivity {
    ImageView homeIcon, notificationIcon, personalIcon, messagesIcon, menuIcon;
    TextView editData, changePass, u_id,u_name, u_city, u_phone, u_garage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_personal_page);

        //views in bossPersonalPage
        editData = findViewById(R.id.bossPersonalPage_editData);
        changePass = findViewById(R.id.bossPersonalPage_changePass);
        u_id = (TextView) findViewById(R.id.bossPersonalPage_idVal);
        u_name = (TextView) findViewById(R.id.bossPersonalPage_name);
        u_city = findViewById(R.id.bossPersonalPage_placeVal);
        u_phone = findViewById(R.id.bossPersonalPage_phoneNumVal);


        selectBossData();
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(boss_personal_page.this, edit_boss_personal_data.class);
                startActivity(intent);
            }
        });

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(boss_personal_page.this, change_password.class);
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
                Intent intent = new Intent(boss_personal_page.this, home_page.class);
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

                Intent intent = new Intent(boss_personal_page.this, notifications.class);
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

                Intent intent = new Intent(boss_personal_page.this, chats.class);
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

                Intent intent = new Intent(boss_personal_page.this, menu.class);
                startActivity(intent);
            }
        });    }

    private void selectBossData() {
        String url = url_serverName.serverName + "bossPersonalPage.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("personal_boss");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        String id = reader.getString("id");
                        String name = reader.getString("name");
                        String phone = reader.getString("phone");
                        String city = reader.getString("city");

                        u_id.setText(id);
                        u_name.setText(name);
                        u_phone.setText(phone);
                        u_city.setText(city);
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
                myMap.put("s_id", login.s_id);
                return myMap;
            }
        };
        my_singleton.getInstance(boss_personal_page.this).addToRequestQueue(myStringRequest);

    }
}