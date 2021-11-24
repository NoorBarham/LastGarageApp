package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.adapter.carAdapter;
import com.example.lastgarageapp.adapter.garageAdapter;
import com.example.lastgarageapp.adapter.lineAdapter;
import com.example.lastgarageapp.adapter.newsAdapter;
import com.example.lastgarageapp.adapter.notificationAdapter;
import com.example.lastgarageapp.itemClasses.carItem;
import com.example.lastgarageapp.itemClasses.garageItem;
import com.example.lastgarageapp.itemClasses.lineItem;
import com.example.lastgarageapp.itemClasses.newsItem;
import com.example.lastgarageapp.itemClasses.notificationItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class home_page extends AppCompatActivity {

    //homeIcon
    Button newsButt, statusButt, addNewsButt;
    Spinner dest, sour;
    LinearLayout newsLayout, carStatusLayout, garageLineStatusLayout, myRecycleLayout;
    TextView iconAddgarage, iconAddcar, iconFilter;
    EditText addNewstext;
    RecyclerView recyclerView;

    //my actionbar
    ImageView homeIcon, notificationIcon, personalIcon, messagesIcon, menuIcon;

    //news
    ArrayList<newsItem> myNews = new ArrayList<>();
    newsAdapter myNewsAdapter;

    //garages
    ArrayList<garageItem> myGarages = new ArrayList<>();
    garageAdapter myGarageAdapter;

    //lines
    ArrayList<lineItem> myLines = new ArrayList<>();
    lineAdapter myLineAdapter;

    //cars
    ArrayList<carItem> myCars = new ArrayList<>();
    carAdapter myCarAdapter;

    //noti
    ArrayList<notificationItem> myNotification = new ArrayList<>();
    notificationAdapter myNotificationAdapter;

    //news=0, garge=1, noti=2, pers=3, mess=4
    static int flage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //my actionbarPage
        homeIcon = findViewById(R.id.myActionBar_homeIcon);
        notificationIcon = findViewById(R.id.myActionBar_notificationsIcon);
        personalIcon = findViewById(R.id.myActionBar_personIcon);
        messagesIcon = findViewById(R.id.myActionBar_messagesIcon);
        menuIcon = findViewById(R.id.myActionBar_menuIcon);

        //recycle
        recyclerView = findViewById(R.id.homePage_recycler);
        myRecycleLayout = findViewById(R.id.homePage_RecycleLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(home_page.this));

        //garage/line Status
        statusButt = findViewById(R.id.homePage_statusButt);
        dest = findViewById(R.id.homePage_destination);
        sour = findViewById(R.id.homePage_source);
        iconAddgarage = findViewById(R.id.homePage_addGarageLineIcon);
        garageLineStatusLayout = findViewById(R.id.homePage_garageLineStatusLayout);

        //car Statuse
        carStatusLayout = findViewById(R.id.homePage_carStatusLayout);
        iconFilter = findViewById(R.id.homePage_filterCar);
        iconAddcar = findViewById(R.id.homePage_addCarIcon);

        //news layout
        addNewstext = findViewById(R.id.homePage_addnewstext);
        addNewsButt = findViewById(R.id.homePage_addNewsButt);
        newsButt = findViewById(R.id.homePage_newsButt);
        newsLayout = findViewById(R.id.homePage_newsLayout);

        //default  View
        homeIcon.setBackgroundColor(Color.WHITE);
        statusButt.setBackgroundColor(0xFFFF6F00);
        statusButt.setTextColor(Color.WHITE);
        newsButt.setBackgroundColor(Color.WHITE);
        newsButt.setTextColor(0xFFFF6F00);

        garageLineStatusLayout.setVisibility(View.GONE);
        carStatusLayout.setVisibility(View.GONE);

        dest.setEnabled(false);
        selectNews();

        //car هدول القديمات ما بنستخدمهم
        ArrayList<carItem> carArray = new ArrayList<>();
        carAdapter C_adapter = new carAdapter(home_page.this, carArray);

        dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                //هاد شغل مؤقت لحد م نعرف كيف نعمل السبينر
                if (!selectedItem.equals("الوجهة")) {
                    if(flage==1){
                        garageLineStatusLayout.setVisibility(View.GONE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.VISIBLE);
                        selectCar();
                    }
                    else if(flage==0)
                        selectNews();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                //هاد شغل مؤقت لحد م نعرف كيف نعمل السبينر
                if (!selectedItem.equals("المكان الحالي")) {
                    dest.setEnabled(true);
                    iconAddgarage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(home_page.this, add_line.class);
                            startActivity(intent);
                        }
                    });
                    if(flage==1){
                        garageLineStatusLayout.setVisibility(View.VISIBLE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.GONE);

                        selectLine();
                    }
                    else if(flage==0)
                        selectNews();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        newsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusButt.setBackgroundColor(0xFFFF6F00);
                statusButt.setTextColor(Color.WHITE);
                newsButt.setBackgroundColor(Color.WHITE);
                newsButt.setTextColor(0xFFFF6F00);

                newsLayout.setVisibility(View.VISIBLE);
                garageLineStatusLayout.setVisibility(View.GONE);
                carStatusLayout.setVisibility(View.GONE);
                addNewstext.setText("");

                flage=0;
                selectNews();
            }
        });

        addNewsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNew();
                selectNews();
            }
        });

        statusButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flage=1;

                newsButt.setBackgroundColor(0xFFFF6F00);
                newsButt.setTextColor(Color.WHITE);
                statusButt.setBackgroundColor(Color.WHITE);
                statusButt.setTextColor(0xFFFF6F00);

                if (!sour.getSelectedItem().equals("المكان الحالي")) {
                    if (!dest.getSelectedItem().equals("الوجهة")) {
                        garageLineStatusLayout.setVisibility(View.GONE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.VISIBLE);
                        selectCar();
                    } else {
                        garageLineStatusLayout.setVisibility(View.VISIBLE);
                        newsLayout.setVisibility(View.GONE);
                        carStatusLayout.setVisibility(View.GONE);

                        selectLine();
                    }
                } else {
                    //garage
                    garageLineStatusLayout.setVisibility(View.VISIBLE);
                    newsLayout.setVisibility(View.GONE);
                    carStatusLayout.setVisibility(View.GONE);
                    iconAddgarage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(home_page.this, add_garage.class);
                            startActivity(intent);
                        }
                    });

                    selectGarage();
                }
            }
        });

        iconAddcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, add_car.class);
                startActivity(intent);

            }
        });

    //actionBar_onClickListener
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, notifications.class);
                startActivity(intent);
            }
        });
        personalIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, personal_page.class);
                startActivity(intent);
            }
        });
        messagesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, messages.class);
                startActivity(intent);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, menu.class);
                startActivity(intent);
            }
        });

    }

    public String getData(EditText t) {
        String myString = t.getText().toString();
        return myString;
    }

    public void selectNews() {
        myNews.clear();
        myGarages.clear();
        myLines.clear();
        myCars.clear();
        String url = url_serverName.serverName + "showNews.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("news");
                    newsItem myItem;
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String textName, String textNews, String textHour
                        String name = reader.getString("name");
                        String text = reader.getString("text");
                        String time = reader.getString("time");
                        myItem = new newsItem(name, text, time);

                        myNews.add(myItem);
                    }
                    myNewsAdapter = new newsAdapter(home_page.this, myNews);
                    recyclerView.setAdapter(myNewsAdapter);
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
        });
        my_singleton.getInstance(home_page.this).addToRequestQueue(myStringRequest);
    }

    public void addNew(){
        if (addNewstext.getText().length() == 0) {
            Toast.makeText(getBaseContext(), "لا يمكنك نشر خبر فارغ", Toast.LENGTH_SHORT).show();
        } else {
            String url = url_serverName.serverName + "addNew.php";
            StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
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
                    TimeZone.setDefault(TimeZone.getTimeZone("GMT" + "04:00"));
                    Date currentTime = Calendar.getInstance().getTime();
                    String timeStamp = new SimpleDateFormat("HH:mm").format(currentTime);

                    Map<String, String> myMap = new HashMap<>();
                    myMap.put("text", getData(addNewstext));
                    myMap.put("date_time", timeStamp);
                    return myMap;
                }
            };
            my_singleton.getInstance(home_page.this).addToRequestQueue(myStringRequest);
        }
    }

    public void selectGarage() {
        myNews.clear();
        myGarages.clear();
        myLines.clear();
        myCars.clear();

        String url = url_serverName.serverName + "showGarages.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("garages");
                    garageItem myItem;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String cityName, String fromHoure, String toHoure, String location
                        String cityName = reader.getString("garage_name");
                        String adminName = reader.getString("admin_name");
                        String fromHoure = reader.getString("open_h");
                        String toHoure = reader.getString("close_h");
                        String location = reader.getString("location");
                        myItem = new garageItem(cityName,adminName, fromHoure, toHoure,location);

                        myGarages.add(myItem);
                    }
                    myGarageAdapter = new garageAdapter(home_page.this, myGarages);
                    recyclerView.setAdapter(myGarageAdapter);
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
        });
        my_singleton.getInstance(home_page.this).addToRequestQueue(myStringRequest);
    }
    public void selectLine() {
        myNews.clear();
        myGarages.clear();
        myLines.clear();
        myCars.clear();
        String url = url_serverName.serverName + "showLines.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("lines");
                    lineItem myItem;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String garage1, String garage2, String lineFare, String noOfCar
                        String garage1 = reader.getString("garage_name1");
                        String garage2 = reader.getString("garage_name2");
                        String lineFare = reader.getString("fare");
                        String noOfCar = reader.getString("no_of_cars");
                        myItem = new lineItem(garage1,garage2, lineFare, noOfCar);

                        myLines.add(myItem);
                    }
                    myLineAdapter = new lineAdapter(home_page.this, myLines);
                    recyclerView.setAdapter(myLineAdapter);
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
        });
        my_singleton.getInstance(home_page.this).addToRequestQueue(myStringRequest);
    }
    public void selectCar() {
        myNews.clear();
        myGarages.clear();
        myLines.clear();
        myCars.clear();
        String url = url_serverName.serverName + "showCars.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("cars");
                    carItem myItem;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //                        String carNumber,String driverName, String availability, String noOfPassenger, String arrivalTime
                        String carNumber = reader.getString("car_id");
                        String driverName = reader.getString("driver_name");
                        String availability = reader.getString("is_available");
                        String noOfPassenger = reader.getString("capacity");
//                        String arrivalTime = reader.getString("arrivalTime");
                        String arrivalTime = "no";
                        myItem = new carItem(carNumber,driverName, availability, noOfPassenger, arrivalTime);

                        myCars.add(myItem);
                    }
                    myCarAdapter = new carAdapter(home_page.this, myCars);
                    recyclerView.setAdapter(myCarAdapter);
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
        });
        my_singleton.getInstance(home_page.this).addToRequestQueue(myStringRequest);
    }

}