package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    private EditText login_idNumber, login_password;
    private Button login_loginClient;
    private Button login_loginAdmin;
    private static String url_Login =  url_serverName.serverName + "login.php";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);

        login_loginClient = (Button) findViewById(R.id.login_loginClient);
        login_loginAdmin = (Button) findViewById(R.id.login_loginAdmin);
        login_idNumber = (EditText) findViewById(R.id.login_idNumber);
        login_password = (EditText) findViewById(R.id.login_password);


        login_loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();

                String url = url_serverName.serverName + "login.php";
                String mID = login_idNumber.getText().toString().trim();
                String mPass = login_password.getText().toString().trim();

                if (!mID.isEmpty() || !mPass.isEmpty()) {
                    login(mID, mPass);

                } else {
                    login_idNumber.setError("أدخل رقم الهوية");
                    login_password.setError("أدخل الرقم السري");

                }
            }
        });
        login_loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome_page();
            }
        });

    }
    public void openhome_page() {
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }

    private void login(String login_idNumber, String login_password) {
        login_loginAdmin.setVisibility(View.GONE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_Login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                              String user_name = object.getString("الاسم").trim();
                            String user_id = object.getString("رقم الهوية").trim();
                            sessionManager.createSession(user_name);

                            Intent intent = new Intent(login.this, home_page.class);
                            intent.putExtra("الاسم" , user_name );
                          //  intent.putExtra("الهوية" , user_id );

                            startActivity(intent);
                            finish();
                            Toast.makeText(login.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();


                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(login.this, "خطأ" + e.toString(), Toast.LENGTH_SHORT).show();
                    login_loginAdmin.setVisibility(View.VISIBLE);
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this, "خطأ" + error.toString(), Toast.LENGTH_SHORT).show();
                        login_loginAdmin.setVisibility(View.GONE);



                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("رقم الهوية", login_idNumber);
                params.put("الرقم السري", login_password);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }}





