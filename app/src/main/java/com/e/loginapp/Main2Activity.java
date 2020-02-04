package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout paymentbtn = (LinearLayout) findViewById(R.id.paymentbtn);
        LinearLayout billbtn = (LinearLayout) findViewById(R.id.billbtn);
        LinearLayout issuebtn = (LinearLayout) findViewById(R.id.issuebtn);
        LinearLayout profilebtn = (LinearLayout) findViewById(R.id.profilebtn);
        LinearLayout event1btn = (LinearLayout) findViewById(R.id.event1btn);
        LinearLayout event2btn = (LinearLayout) findViewById(R.id.event2btn);
        LinearLayout event3btn = (LinearLayout) findViewById(R.id.event3btn);

        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, paymentActivity.class);
                startActivity(i);
            }
        });

        billbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, BillListActivity.class);
                startActivity(i);
            }
        });

        issuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, IssueActivity.class);
                startActivity(i);
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,ProfileActivity.class);
                startActivity(i);
            }
        });

        event1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Event # 1", Toast.LENGTH_LONG).show();
            }
        });

        event2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Event # 2", Toast.LENGTH_LONG).show();
            }
        });

        event3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Event # 3", Toast.LENGTH_LONG).show();
            }
        });


    }
}
