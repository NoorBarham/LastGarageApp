package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class add_garage extends AppCompatActivity {

    private EditText cityName,openHoure,closeHoure,location;
    private Button cancelButt,addButt;

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
                String url = url_serverName.serverName+"login.php";
//                StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject reader = new JSONObject(response);
////                            reader
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                });


            }
        });

        cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
