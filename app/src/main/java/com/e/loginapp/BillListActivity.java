package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BillListActivity extends AppCompatActivity {

    LinearLayout billingmet;
    LinearLayout billingmet2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);

        billingmet = (LinearLayout) findViewById(R.id.billingmet);
        billingmet2 = (LinearLayout) findViewById(R.id.billingmet2);

        billingmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BillListActivity.this, "Paid", Toast.LENGTH_LONG).show();
            }
        });

        billingmet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BillListActivity.this, "Pending", Toast.LENGTH_LONG).show();
            }
        });

    }
}
