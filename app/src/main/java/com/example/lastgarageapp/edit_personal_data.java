package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class  edit_personal_data extends AppCompatActivity {

    private Button editPersonalData_cancel;
    private TextView name,city,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_data);
        editPersonalData_cancel = (Button) findViewById(R.id.editPersonalData_cancel);
        name=findViewById(R.id.editPersonalData_nameVal);
        city=findViewById(R.id.editPersonalData_cityVal);
        phone=findViewById(R.id.editPersonalData_phoneNumVal);

        selectPersonaldata("1");

        editPersonalData_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    public void selectPersonaldata(String Id) {

        String url = url_serverName.serverName + "selectPersonaldata.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("edit_personal");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject reader = jsonArray.getJSONObject(i);

                        String Name = reader.getString("driver_name");
                        String City = reader.getString("city");
                        String Phone = reader.getString("phone");

                        name.setText(Name);
                        city.setText(City);
                        phone.setText(Phone);

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
                myMap.put("driver_id", Id);
                return myMap;
            }
        };
        my_singleton.getInstance(edit_personal_data.this).addToRequestQueue(myStringRequest);
    }


}
