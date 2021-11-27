package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    private EditText login_idNumber, login_password;
    private Button login_loginClient;
    private Button login_loginAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        login_loginClient = (Button) findViewById(R.id.login_loginClient);
        login_loginAdmin = (Button) findViewById(R.id.login_loginAdmin);
        login_idNumber = (EditText)findViewById(R.id.login_idNumber);
        login_password = (EditText)findViewById(R.id.login_password);


        login_loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();

                String url = url_serverName.serverName+"login.php";
                StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Login : ", response);

                        try {
                            JSONObject reader = new JSONObject(response);
                            String type = reader.getString("type");
                            if (type.equals("1")) {
                                openhome_page();

                            } else if (type.equals("2")) {
                                openhome_page();

                            } else {
                                Toast.makeText(getBaseContext(), "المستخدم غير موجود", Toast.LENGTH_SHORT).show();
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
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("idNumber", login_idNumber.getText().toString());
                        params.put("password", login_password.getText().toString());
                        return params;
                    }
                };
                my_singleton.getInstance(com.example.lastgarageapp.login.this).addToRequestQueue(stringRequest2);


            }
        });


        login_loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();
            }
        });
    }

    public void openhome_page(){
        Intent intent = new Intent(this,home_page.class);
        startActivity(intent);


    }
        }