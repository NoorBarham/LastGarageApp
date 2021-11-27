package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class add_line extends AppCompatActivity {

    private Button cancleButton,addButton;
    Spinner sour, des;
    EditText fare;
    ArrayList source_array =new ArrayList();
    ArrayList destination_array =new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_line);

        sour = findViewById(R.id.addLine_sour);
        des = findViewById(R.id.addLine_dest);
        fare = findViewById(R.id.addLine_fare);
        addButton= findViewById(R.id.addline_addButt);
        cancleButton = findViewById(R.id.addLine_cancle);

        //default
        sourceSpinner();

        sour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                destinationSpinner();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        des.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myFare=getData(fare);
                if(fare.getText().length()==0){
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }else{
                    String url = url_serverName.serverName+"addLine.php";
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

                            myMap.put("garage1_name", sour.getSelectedItem().toString());
                            myMap.put("garage2_name", des.getSelectedItem().toString());
                            myMap.put("fare", myFare);
                            return myMap;
                        }
                    };
                    my_singleton.getInstance(add_line.this).addToRequestQueue(myStringRequest);
                }
                fare.setText("");
            }
        });

        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public String getData(EditText t){
        String myString =t.getText().toString();
        return myString;
    }
    public void sourceSpinner() {
        source_array.clear();
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
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(add_line.this,android.R.layout.simple_spinner_item, source_array);
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
        my_singleton.getInstance(add_line.this).addToRequestQueue(myStringRequest);
    }
    public void destinationSpinner() {
        destination_array.clear();
        String url = url_serverName.serverName + "destinationSpinner.php";
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
                        if(!cityName.equals(sour.getSelectedItem()))
                            destination_array.add(cityName);

                    }
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(add_line.this,android.R.layout.simple_spinner_item, destination_array);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    des.setAdapter(adapter);
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
                myMap.put("garage_name", sour.getSelectedItem().toString());
                return myMap;
            }
        };
        my_singleton.getInstance(add_line.this).addToRequestQueue(myStringRequest);
    }
}
