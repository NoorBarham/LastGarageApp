package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class add_garage extends AppCompatActivity {

    private EditText cityName,openHoure,closeHoure,location;
    private TextView counter;
    private Button cancelButt,addButt;
    TimePickerDialog timePickerDialog;
    String amPm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_garage);

        cityName= findViewById(R.id.addGarage_cityValue);
        openHoure= findViewById(R.id.addGarage_openHoureValue);
        closeHoure= findViewById(R.id.addGarage_closeHoureValue);
        location= findViewById(R.id.addGarage_locationValue);

        cancelButt = findViewById(R.id.addGarage_cancelButt);
        addButt= findViewById(R.id.addGarage_addButt);
        addButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cityName.getText().length()==0||openHoure.getText().length()==0||closeHoure.getText().length()==0||location.getText().length()==0){
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }else{
                    String url = url_serverName.serverName+"addGarage.php";
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

                            myMap.put("garage_name", getData(cityName));
                            myMap.put("open_hour", removeSpaces(getData(openHoure)));
                            myMap.put("close_hour", removeSpaces(getData(closeHoure)));
                            myMap.put("location", getData(location));
                            return myMap;
                        }
                    };
                    my_singleton.getInstance(add_garage.this).addToRequestQueue(myStringRequest);
                }
            }
        });


        cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        openHoure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(add_garage.this,R.style.Theme1_LastGarageApp, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        openHoure.setText(String.format("%02d : %02d " , hourOfDay, minute) );
                    }
                },00, 00, true );
                timePickerDialog.show();

            }
        });

        closeHoure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(add_garage.this,R.style.Theme1_LastGarageApp, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        closeHoure.setText(String.format("%02d : %02d " , hourOfDay, minute) );

                    }
                }, 00 ,00,true);
                timePickerDialog.show();
            } });
    }
    public String getData(EditText t){
        String myString =t.getText().toString();
        return myString;
    }

    static String removeSpaces(String myString) {
        char []str=myString.toCharArray();
        int count = 0;
        for (int i = 0; i<str.length; i++)
            if (str[i] != ' ')
                str[count++] = str[i];
       return (String) String.valueOf(str).subSequence(0, count);
    }
}


