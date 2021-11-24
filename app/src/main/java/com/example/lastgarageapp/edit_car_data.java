package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.adapter.carAdapter;
import com.example.lastgarageapp.adapter.newsAdapter;
import com.example.lastgarageapp.itemClasses.carItem;
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
    private Spinner driver_name,source,destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car_data);
        editCarData_cancel = (Button) findViewById(R.id.editCarData_cancel);
        editCarData_save=(Button) findViewById(R.id.editCar_saveChange);
        car_no=findViewById(R.id.editCarData_carNumVal);
        fare=findViewById(R.id.editCarData_fareVal);
        driver_name=(Spinner) findViewById(R.id.editCarData_nameDriverVal);
        source=(Spinner) findViewById(R.id.editCarData_source);
        destination=(Spinner) findViewById(R.id.editCarData_destination);

        editCarData_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String car=car_status_list_item.carNomber;
                car_no.setText(car);

                if(car_no.getText().length()==0||fare.getText().length()==0){
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
                            myMap.put("fare", fare.getText().toString());
                            myMap.put("driver_name",driver_name.getSelectedItem().toString());
                            myMap.put("source",source.getSelectedItem().toString());
                            myMap.put("destination",destination.getSelectedItem().toString());
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

}
