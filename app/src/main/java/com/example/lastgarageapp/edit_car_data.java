package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.adapter.carAdapter;
import com.example.lastgarageapp.adapter.garageAdapter;
import com.example.lastgarageapp.adapter.newsAdapter;
import com.example.lastgarageapp.itemClasses.carItem;
import com.example.lastgarageapp.itemClasses.garageItem;
import com.example.lastgarageapp.itemClasses.newsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class edit_car_data extends AppCompatActivity {

    private Button editCarData_cancel,editCarData_save;
    private TextView car_no;
    private EditText fare;
    private Spinner driver_name,sour,dest;

    // Arrays
    ArrayList source_array =new ArrayList();
    ArrayList destination_array =new ArrayList();
    ArrayList name_array =new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car_data);
        editCarData_cancel = (Button) findViewById(R.id.editCarData_cancel);
        editCarData_save = (Button) findViewById(R.id.editCar_saveChange);
        car_no = findViewById(R.id.editCarData_carNumVal);
        driver_name = (Spinner) findViewById(R.id.editCarData_nameDriverVal);
        sour = (Spinner) findViewById(R.id.editCarData_source);
        dest = (Spinner) findViewById(R.id.editCarData_destination);


        //String car=carAdapter.car_nomb;
        car_no.setText("563");

        nameSpinner();
        sourceSpinner();
        destinationSpinner();
        selectCardata("563");

        driver_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        sour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        dest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        editCarData_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(car_no.getText().length()==0){
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }else{

                    String url = url_serverName.serverName+"editCardata.php";
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
                    }){
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> myMap = new HashMap<>();

                            myMap.put("car_no",car_no.getText().toString());
                            myMap.put("driver_name",driver_name.getSelectedItem().toString());
                            myMap.put("source",sour.getSelectedItem().toString());
                            myMap.put("destination",dest.getSelectedItem().toString());
                            return myMap;
                        }
                    };
                    my_singleton.getInstance(edit_car_data.this).addToRequestQueue(myStringRequest);
                }
            }

        });
        editCarData_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();            }
        });
    }
    public void nameSpinner() {

        name_array.add(0,"لم يحدد");

        String url = url_serverName.serverName + "nameSpinner.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("names");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String cityName
                        String driverName = reader.getString("driver_name");
                        name_array.add(driverName);

                    }
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(edit_car_data.this,android.R.layout.simple_spinner_item, name_array);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    driver_name.setAdapter(adapter);
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
        my_singleton.getInstance(edit_car_data.this).addToRequestQueue(myStringRequest);
    }
    public void sourceSpinner() {
        source_array.clear();
        source_array.add(0,"المكان الحالي");

        String url = url_serverName.serverName + "sourceSpinner.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("garages");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String cityName
                        String cityName = reader.getString("garage_name");
                        source_array.add(cityName);

                    }
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(edit_car_data.this,android.R.layout.simple_spinner_item, source_array);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sour.setAdapter(adapter);
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
        my_singleton.getInstance(edit_car_data.this).addToRequestQueue(myStringRequest);
    }

    public void destinationSpinner() {
        destination_array.clear();
        destination_array.add(0,"الوجهة");

        String url = url_serverName.serverName + "DestSpinner.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("garages");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        //String cityName
                        String cityName = reader.getString("garage_name");
                        destination_array.add(cityName);

                    }
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(edit_car_data.this,android.R.layout.simple_spinner_item, destination_array);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dest.setAdapter(adapter);
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
        my_singleton.getInstance(edit_car_data.this).addToRequestQueue(myStringRequest);
    }
    // to get data from data base to android
    public void selectCardata(String car_nomber) {

        String url = url_serverName.serverName + "selectCardata.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("car");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        String name = reader.getString("driver_name");
                        String source = reader.getString("source");
                        String destination = reader.getString("destination");


                        driver_name.setSelection(getIndexByString(driver_name,name));
                        sour.setSelection(getIndexByString(sour,source));
                        dest.setSelection(getIndexByString(dest,destination));

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
                myMap.put("car_id", car_nomber);
                return myMap;
            }
        };
        my_singleton.getInstance(edit_car_data.this).addToRequestQueue(myStringRequest);
    }

    public int getIndexByString(Spinner spinner, String string) {
        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(string)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
