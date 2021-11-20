package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class add_car extends AppCompatActivity {
    private TextView car_no;
    private Spinner driverName,capacity,sour,dest;
    private Button addCar_add,addCar_cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        car_no = findViewById(R.id.addCar_carNumVal);
        driverName=(Spinner) findViewById(R.id.addCar_namedriverval);
        capacity=(Spinner) findViewById(R.id.addCar_sizeVal);
        sour=(Spinner) findViewById(R.id.addCar_source);
        dest=(Spinner) findViewById(R.id.addCar_destination);
        addCar_cancel = (Button) findViewById(R.id.addCar_cancel);
        addCar_add= (Button) findViewById(R.id.addCar_add);

        addCar_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(car_no.getText().length()==0){
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }else{
                    String url = url_serverName.serverName + "addCar.php";
                    StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
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
                            Map<String, String> params = new HashMap<>();
                            params.put("car_id", car_no.getText().toString());
                            params.put("driver_name", driverName.getSelectedItem().toString());
                            params.put("car_size", capacity.getSelectedItem().toString());
                            params.put("source", sour.getSelectedItem().toString());
                            params.put("destination", dest.getSelectedItem().toString());

                            return params;
                        }
                    };
                    my_singleton.getInstance(add_car.this).addToRequestQueue(stringRequest2);

                }
            }

        });

        addCar_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();            }
        });
    }





}
