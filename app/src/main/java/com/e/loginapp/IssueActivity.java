package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class IssueActivity extends AppCompatActivity {

    private static final String TAG = "IssueActivity";

    private TextView FromDate;
    private  TextView ToDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        FromDate = (TextView) findViewById(R.id.from_date);
        ToDate = (TextView) findViewById(R.id.to_date);
        Button submitbtn = (Button) findViewById(R.id.submitbtn);

        FromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        IssueActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        ToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        IssueActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + year + "/" + month + "/" + dayOfMonth);

                String date = month + "/" + dayOfMonth + "/" + year;
                FromDate.setText(date);
            }
        };

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + year + "/" + month + "/" + dayOfMonth);

                String date = month + "/" + dayOfMonth + "/" + year;
                ToDate.setText(date);
            }
        };

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IssueActivity.this, "Payment Submitted", Toast.LENGTH_LONG).show();
            }
        });

        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items = new String[]{"Select Category", "Billing", "Personnel", "Repair", "Internet", "Housekeeping", "App Concerns"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        ImageView captureBtn = (ImageView) findViewById(R.id.camerabtn);

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IssueActivity.this, "Open Camera", Toast.LENGTH_LONG).show();
            }
        });
    }
}
