package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    private EditText idNumber, password;
    private Button loginClient;
    private Button loginAdmin;

    String flag;
    public static String myUser;
    public static String s_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        idNumber = findViewById(R.id.login_idNumber);
        password = findViewById(R.id.login_password);
        loginAdmin = findViewById(R.id.login_loginAdmin);
        loginClient = findViewById(R.id.login_loginClient);

        loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tex_email = idNumber.getText().toString();
                String tex_password = password.getText().toString();
                if (TextUtils.isEmpty(tex_email) || TextUtils.isEmpty(tex_password)){
                    Toast.makeText(login.this, "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }
                else{
                    login(tex_email,tex_password);
                }
            }


        });

       loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,home_page.class));
                myUser=null;
                finish();
            }
        });
    }



    public void login(final String id, final String password) {
        String uRl = url_serverName.serverName +"login1.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, uRl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("login");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject reader = jsonArray.getJSONObject(i);
                        s_id = reader.getString("s_id");
                        startActivity(new Intent(login.this, home_page.class));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("userId", id);
                param.put("pass", password);
                return param;

            }
        };

        my_singleton.getInstance(login.this).addToRequestQueue(myStringRequest);
    }
}







