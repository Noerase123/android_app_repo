package com.e.loginapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.ApiServer.KeyPoints;
import com.e.loginapp.Model.Issue;
import com.e.loginapp.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class IssueActivity extends AppCompatActivity {

    private static final String TAG = "IssueActivity";
    private JsonHolderApi jsonHolderApi;

    private ProgressDialog progressDialog;

    private EditText issueDetails;
    private Spinner dropdown;

    private ImageView cameraBtn;
    private ImageView cameraView;

    private CheckBox simpleCheckBox;

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

        simpleCheckBox = (CheckBox) findViewById(R.id.simpleCheckBox);

        FromDate = (TextView) findViewById(R.id.from_date);
        ToDate = (TextView) findViewById(R.id.to_date);
        FromToDate = (TextView) findViewById(R.id.fromto_date);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

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
                progressDialog.show();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");


                String details = issueDetails.getText().toString().trim();
                String category = dropdown.getSelectedItem().toString();
                String date1 = FromDate.getText().toString();
                String date2 = ToDate.getText().toString();
                String date3 = "03/15/2020";

                Date dateOne = null;
                Date dateTwo = null;
                Date dateThree = null;

                try {
                    dateOne = dateFormat.parse(date1);
                    dateTwo = dateFormat.parse(date2);
                    dateThree = dateFormat.parse(date3);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String check = "0";

                if (simpleCheckBox.isChecked()) {
                    check = "1";
                } else {
                    check = "0";
                }

                addIssue(details,category,check,dateOne,dateTwo,dateThree);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        cameraView.setImageBitmap(bitmap);
    }

    private void addIssue(String issueDetails, String category, String anytime, Date date1, Date date2, Date date3) {

        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("issueDetails", issueDetails)
                .addFormDataPart("category", category)
                .addFormDataPart("anytime", anytime)
                .addFormDataPart("date1", String.valueOf(date1))
                .addFormDataPart("date2", String.valueOf(date2))
                .addFormDataPart("date3", String.valueOf(date3))
                .build();

        Request request = new Request.Builder()
                .url(KeyPoints.ISSUE_URL)
                .post(requestBody)
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    Log.d("Report An Issue",response.body().string());
                    progressDialog.dismiss();
                    finish();

                }
            });

        new android.os.Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(IssueActivity.this,"Issue Reported successfully",Toast.LENGTH_LONG).show();
                    }
                },1000
        );

    }
}
