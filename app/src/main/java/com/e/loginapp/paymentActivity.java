package com.e.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class paymentActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Select Invoice to pay","OFF202000591 - (P 5388.35)","OFF202000569 - (P 5388.35)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        ImageView captureBtn = (ImageView) findViewById(R.id.captureBtn);
        Button submitbtn = (Button) findViewById(R.id.submitbtn);

        captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentActivity.this, "Open Camera", Toast.LENGTH_LONG).show();
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentActivity.this, "Payment Submitted", Toast.LENGTH_LONG).show();
            }
        });

    }

}
