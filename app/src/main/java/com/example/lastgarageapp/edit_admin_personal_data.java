package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class edit_admin_personal_data extends AppCompatActivity {
    private Button editAdminPersonalData_cancel, editPersonalData_save;
    TextView name,city,phone;
    Spinner garagename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin_personal_data);
        editPersonalData_save = (Button) findViewById(R.id.editPersonalData_savechange);
        name=findViewById(R.id.editPersonalData_nameVal);
        city=findViewById(R.id.editPersonalData_cityVal);
        phone=findViewById(R.id.editPersonalData_phoneNumVal);
        garagename=(Spinner)findViewById(R.id.editAdminPersonalData_garageVal);

        editAdminPersonalData_cancel = (Button) findViewById(R.id.editAdminPersonalData_cancel);

        editAdminPersonalData_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}