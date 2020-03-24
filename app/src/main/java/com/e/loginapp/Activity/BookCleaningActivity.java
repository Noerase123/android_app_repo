package com.e.loginapp.Activity;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.R;

import java.util.Calendar;

public class BookCleaningActivity extends AppCompatActivity {

    private static final String TAG = "BookCleaningActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView SelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_cleaning);

        Button bookcleaningbtn = (Button) findViewById(R.id.bookcleaningbtn);

        SelectDate = (TextView) findViewById(R.id.select_date);

        SelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BookCleaningActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Select Category","Scrubbing","Damp Dusting", "Mop Sweeping", "Polishing", "Spot Cleaning"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        bookcleaningbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookCleaningActivity.this, "Book Cleaning Success", Toast.LENGTH_LONG).show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + year + "/" + month + "/" + dayOfMonth);

                String date = month + "/" + dayOfMonth + "/" + year;
                SelectDate.setText(date);
            }
        };
    }
}
