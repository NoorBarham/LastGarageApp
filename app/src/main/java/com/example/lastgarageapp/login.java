package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Authenticator;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lastgarageapp.adapter.newsAdapter;
import com.example.lastgarageapp.itemClasses.newsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {
    private EditText login_idNumber, login_password;
    private Button login_loginClient;
    private Button login_loginAdmin;

    SharedPreferences sharedPreferences;
    String flag;

    // SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        login_idNumber = (EditText) findViewById(R.id.login_idNumber);
        login_password = (EditText) findViewById(R.id.login_password);
        login_loginAdmin = (Button) findViewById(R.id.login_loginAdmin);
        login_loginClient= (Button) findViewById(R.id.login_loginClient);
         sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);


        login_loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tex_email = login_idNumber.getText().toString();
                String tex_password = login_password.getText().toString();
                if (TextUtils.isEmpty(tex_email) || TextUtils.isEmpty(tex_password)){
                    Toast.makeText(login.this, "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                }
                else{
                    login(tex_email,tex_password);
                }
            }


        });

       login_loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,home_page.class));
                finish();
            }
        });
    }



    public void login(final String email, final String password) {
        String uRl = url_serverName.serverName +"login.php";
        StringRequest myStringRequest = new StringRequest(Request.Method.POST, uRl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
//                    Log.d("sss",response);
                    JSONObject object = new JSONObject(response);
                    JSONArray jsonArray = object.getJSONArray("login");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject reader = jsonArray.getJSONObject(i);
                        flag = reader.getString("flag");
                    }
                    if(flag.equals("1")){
                      //  SharedPreferences.Editor editor = sharedPreferences.edit();
                     //   editor.putString("user_name",login_idNumber.getText().toString());
                       // editor.putString("password",login_password.getText().toString());
                     //   editor.commit();
                        startActivity(new Intent(login.this, home_page.class));
                    } else{
                       Toast.makeText(getApplicationContext(),"خطأ في التسجيل",Toast.LENGTH_SHORT).show();
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
                param.put("email", email);
                param.put("pass", password);
                return param;

            }
        };

        my_singleton.getInstance(login.this).addToRequestQueue(myStringRequest);
    }
}







