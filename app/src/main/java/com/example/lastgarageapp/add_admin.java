package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
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

public class add_admin extends AppCompatActivity {
  private TextView name,city,identity_no,phone_no,pass;
  private  Spinner garageName;
  private Button addAdmin_add,addAdmin_cancel;

    ArrayList garage_name_array =new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        addAdmin_add=(Button) findViewById(R.id.addAdmin_addButton);
        addAdmin_cancel = (Button) findViewById(R.id.addAdmin_cancelButton);

        name = findViewById(R.id.addAdmin_nameValue);
        pass = findViewById(R.id.addAdmin_passwordValue);
        city = findViewById(R.id.addAdmin__cityValue);
        identity_no= findViewById(R.id.addAdmin_idValue);
        phone_no=findViewById(R.id.addAdmin_phoneValue);

        garageName=(Spinner) findViewById(R.id.addAdmin_garageNameValue);

        garagenameSpinner();

        garageName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        addAdmin_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().length()==0||identity_no.getText().length()==0||city.getText().length()==0||phone_no.getText().length()==0||pass.getText().length()==0){
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }else{
                    String url = url_serverName.serverName + "addAdmin.php";
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
                            params.put("user_id", identity_no.getText().toString());
                            params.put("user_name", name.getText().toString());
                            params.put("password", pass.getText().toString());
                            params.put("city", city.getText().toString());
                            params.put("phone_no", phone_no.getText().toString());
                            params.put("garage_name",garageName.getSelectedItem().toString());

                            return params;
                        }
                    };
                    my_singleton.getInstance(add_admin.this).addToRequestQueue(stringRequest2);

                }
            }

        });
        addAdmin_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void garagenameSpinner() {
        garage_name_array.clear();
        garage_name_array.add(0,"لم يحدد");

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
                        garage_name_array.add(cityName);

                    }
                    ArrayAdapter<CharSequence> adapter = new ArrayAdapter(add_admin.this,android.R.layout.simple_spinner_item, garage_name_array);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    garageName.setAdapter(adapter);
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
        my_singleton.getInstance(add_admin.this).addToRequestQueue(myStringRequest);
    }

    }
