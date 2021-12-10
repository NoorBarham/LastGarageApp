package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class settings extends AppCompatActivity {
    private Button settings_cancel;
    private TextView editPersonalSettings,editadminPersonalSettings;
    private TextView changePassSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settings_cancel = (Button) findViewById(R.id.settings_cancel);
        editadminPersonalSettings = (TextView) findViewById(R.id.editadminPersonalSettings);
        editPersonalSettings = (TextView) findViewById(R.id.editPersonalSettings);
        changePassSettings = (TextView) findViewById(R.id.changePassSettings);

        settings_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editadminPersonalSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdminEditPersonal_page();
            }
        });
        editPersonalSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditPersonal_page();
            }
        });

        changePassSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChangePass_page();
            }
        });

    }
    public void openAdminEditPersonal_page(){
        Intent intent = new Intent(this,edit_admin_personal_data.class);
        startActivity(intent);

    }
    //5

    public void openEditPersonal_page(){
        Intent intent = new Intent(this,edit_personal_data.class);
        startActivity(intent);

    }
    public void openChangePass_page(){
        Intent intent = new Intent(this,change_password.class);
        startActivity(intent);

}}


