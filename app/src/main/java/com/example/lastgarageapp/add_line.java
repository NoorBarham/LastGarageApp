package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class add_line extends AppCompatActivity {

    private Button cancleButton,addButton;
    Spinner sour, des;
    EditText fare;
    ArrayList city_arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_line);

        sour = findViewById(R.id.addLine_sour);
        des = findViewById(R.id.addLine_dest);
        fare = findViewById(R.id.addLine_fare);

//        city_arr.add("جنين");
//        city_arr.add("طوباس");
//        city_arr.add("نابلس");
//        city_arr.add("طولكرم");
//        city_arr.add("قلقيلية");
//        city_arr.add("اريحا");
//        city_arr.add("سلفيت");
//        city_arr.add("رام الله");
//        city_arr.add("البيرة");
//        city_arr.add("القدس");
//        city_arr.add("بيت لحم");
//        city_arr.add("الخليل");
//
//        ArrayAdapter adapter1 = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,city_arr);
//        sour.setAdapter(adapter1);

        addButton= findViewById(R.id.addline_addButt);
        cancleButton = findViewById(R.id.addLine_cancle);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                            myMap.put("fare", getData(fare));
                            return myMap;
                        }
                    };
                    my_singleton.getInstance(add_line.this).addToRequestQueue(myStringRequest);
                }
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
}
