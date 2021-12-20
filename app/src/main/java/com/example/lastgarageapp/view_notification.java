package com.example.lastgarageapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.adapter.notificationAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class view_notification extends AppCompatActivity {

    ImageView homeIcon, notificationIcon, personalIcon, messagesIcon, menuIcon;

    TextView name, delet_icon, text, hour, news_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notification);

        name =findViewById(R.id.notiItems_newsItem_name);
        delet_icon =findViewById(R.id.notiItems_newsItem_delet);
        text =findViewById(R.id.notiItems_newsItem_text);
        hour=findViewById(R.id.notiItems_newsItem_hour);
        news_id=findViewById(R.id.notificationItem_newsId);

//        String value=getIntent().getExtras().getString("value");
//        //views in my actionbarPage
//        TextView  name=findViewById(R.id.newsItem_name);
//        name.setText(value);

        showNoti_News(notificationAdapter.myNewsId);
        delet_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //هون شغل حذف الخبر فقط بيظهر لكاتب الخبر
            }
        });
        //actionbar
        homeIcon = findViewById(R.id.myActionBar_homeIcon);
        notificationIcon = findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon = findViewById(R.id.myActionBar_personIcon);
        messagesIcon = findViewById(R.id.myActionBar_messagesIcon);
        menuIcon = findViewById(R.id.myActionBar_menuIcon);
        notificationIcon.setBackgroundColor(Color.WHITE);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_notification.this, home_page.class);
                startActivity(intent);
            }
        });
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_notification.this, notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_notification.this, personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_notification.this, messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view_notification.this, menu.class);
                startActivity(intent);
            }
        });
    }
    private void showNoti_News(String news_id){
        String url = url_serverName.serverName + "showNewsNotification.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("news");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject reader = jsonArray.getJSONObject(i);

                        name.setText(reader.getString("name"));
                        text.setText(reader.getString("text"));
                        hour.setText(reader.getString("time"));

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
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> myMap = new HashMap<>();
                myMap.put("news_id", news_id);
                return myMap;
            }
        };
        my_singleton.getInstance(view_notification.this).addToRequestQueue(myStringRequest);
    }
}
