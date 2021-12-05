package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class edit_admin_personal_data extends AppCompatActivity {
    private Button editAdminPersonalData_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin_personal_data);

        editAdminPersonalData_cancel = (Button) findViewById(R.id.editAdminPersonalData_cancel);

        editAdminPersonalData_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}