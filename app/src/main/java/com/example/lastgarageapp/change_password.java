package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class change_password extends AppCompatActivity {
    Button changePass_cancel,changePass_save;
    EditText current_pass,new_pass,conform_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        changePass_cancel = (Button) findViewById(R.id.changePass_cancel);
        changePass_save=(Button) findViewById(R.id.changePass_saveChange);
        current_pass= findViewById(R.id.changPass_currentPassVal);
        new_pass=findViewById(R.id.changePass_newPassVal);
        conform_pass=findViewById(R.id.changePass_conformPassVal);

        changePass_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_pass.getText().length() == 0 || new_pass.getText().length() == 0 || conform_pass.getText().length() == 0) {
                    Toast.makeText(getBaseContext(), "قم بإدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                } else {
                   if(!new_pass.getText().toString().equals(conform_pass.getText().toString())) {
                       Toast.makeText(getBaseContext(), "كلمة السر غير متطابقة", Toast.LENGTH_SHORT).show();
                   }
                   else {

                       String url = url_serverName.serverName + "changePassword.php";
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
                               params.put("currentPass", current_pass.getText().toString());
                               params.put("new_Pass", new_pass.getText().toString());
                               params.put("conform_Pass", conform_pass.getText().toString());
                               return params;
                           }
                       };

                       my_singleton.getInstance(change_password.this).addToRequestQueue(stringRequest2);
                   }
                    }
                }



        });


        changePass_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();            }
        });

    }

    }
