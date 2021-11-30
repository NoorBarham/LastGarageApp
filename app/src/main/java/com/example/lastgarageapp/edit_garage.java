package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class edit_garage extends AppCompatActivity {
    private EditText editGarage_editStartWork,editGarage_editEndWork;
    TimePickerDialog timePickerDialog;
private Button editGarage_cancel;
String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_garage);
        editGarage_cancel = (Button) findViewById(R.id.editCarData_cancel);

        editGarage_editStartWork = findViewById(R.id.editGarage_editStartWork);
        editGarage_editEndWork = findViewById(R.id.editGarage_editEndWork);

        editGarage_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        editGarage_editStartWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(edit_garage.this,R.style.Theme1_LastGarageApp, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay>=12){
                            amPm= "PM";
                        }
                        else {
                            amPm="AM";
                        }
                        editGarage_editStartWork.setText(String.format("%02d : %02d " , hourOfDay, minute) + amPm);
                    }
                },00, 00, false );
                timePickerDialog.show();

            }
        });

        editGarage_editEndWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(edit_garage.this,R.style.Theme1_LastGarageApp, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (hourOfDay>=12){
                            amPm= "PM";
                        }
                        else {
                            amPm="AM";
                        }
                        editGarage_editEndWork.setText(String.format("%02d : %02d " , hourOfDay, minute) + amPm);

            }
        }, 00 ,00,false);
                timePickerDialog.show();
    } });


}}
