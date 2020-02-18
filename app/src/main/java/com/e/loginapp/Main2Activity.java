package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.Gravity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private JsonHolderApi jsonHolderApi;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);

        

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        LinearLayout paymentbtn = (LinearLayout) findViewById(R.id.paymentbtn);
        LinearLayout billbtn = (LinearLayout) findViewById(R.id.billbtn);
        LinearLayout issuebtn = (LinearLayout) findViewById(R.id.issuebtn);
        LinearLayout profilebtn = (LinearLayout) findViewById(R.id.profilebtn);
        LinearLayout leaseBtn = (LinearLayout) findViewById(R.id.leaseBtn);
        LinearLayout clubbtn = (LinearLayout) findViewById(R.id.clubbtn);
        LinearLayout rulesbtn = (LinearLayout) findViewById(R.id.rulesbtn);
        LinearLayout cleaningbtn = (LinearLayout) findViewById(R.id.cleaningbtn);
        CardView accountbtn = (CardView) findViewById(R.id.accountbtn);
        LinearLayout eventsbtn = (LinearLayout) findViewById(R.id.eventsbtn);

        TextView nametxt = (TextView) findViewById(R.id.nametxt);

        accountbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, AccountActivity.class);
                startActivity(i);
            }
        });

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

        leaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,LeaseActivity.class);
                startActivity(i);
            }
        });

        clubbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,ClubActivity.class);
                startActivity(i);
            }
        });

        eventsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,EventsActivity.class);
                startActivity(i);
            }
        });

        rulesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Rules View", Toast.LENGTH_LONG).show();
            }
        });

        cleaningbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,BookCleaningActivity.class);
                startActivity(i);
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
