package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.Model.Issue;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueActivity extends AppCompatActivity {

    private static final String TAG = "IssueActivity";
    private String BASE_URL = "https://mytown-app.com/api/";
    private JsonHolderApi jsonHolderApi;

    private EditText issueDetails;
    private Spinner dropdown;

    private ImageView cameraBtn;
    private ImageView cameraView;

    private TextView FromDate;
    private TextView ToDate;
    private TextView FromToDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    private DatePickerDialog.OnDateSetListener mDateSetListener3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        issueDetails = (EditText) findViewById(R.id.edit_text);
        FromDate = (TextView) findViewById(R.id.from_date);
        ToDate = (TextView) findViewById(R.id.to_date);
        FromToDate = (TextView) findViewById(R.id.fromto_date);

        Button submitbtn = (Button) findViewById(R.id.submitbtn);

        cameraBtn = (ImageView) findViewById(R.id.cameraBtn);
        cameraView = (ImageView) findViewById(R.id.cameraView);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });

        FromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        IssueActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
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
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        FromToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        IssueActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener3,
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

        mDateSetListener3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + year + "/" + month + "/" + dayOfMonth);

                String date = month + "/" + dayOfMonth + "/" + year;
                FromToDate.setText(date);
            }
        };

        dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items = new String[]{"Select Category", "Billing", "Personnel", "Repair", "Internet", "Housekeeping", "App Concerns"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addIssue();
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        cameraView.setImageBitmap(bitmap);
    }

    private void addIssue() {

        Call<Issue> call = jsonHolderApi.addIssues(issueDetails.getText().toString(), "App Concern", 0, FromDate.getText().toString(), ToDate.getText().toString(), FromToDate.getText().toString());

        call.enqueue(new Callback<Issue>() {
            @Override
            public void onResponse(Call<Issue> call, Response<Issue> response) {

                Toast.makeText(IssueActivity.this, "Issue Submitted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Issue> call, Throwable t) {
                Toast.makeText(IssueActivity.this, "Issue Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
