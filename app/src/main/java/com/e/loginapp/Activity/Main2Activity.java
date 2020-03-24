package com.e.loginapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.Model.Tenant;
import com.e.loginapp.R;
import com.google.gson.Gson;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.e.loginapp.ApiServer.ApiLoader;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity {

    private ApiLoader apiLoader;
    private JsonHolderApi jsonHolderApi;
    private RecyclerView mRecyclerView;
    private TextView balanceResult;
    private TextView nametxt;
    private TextView unitnores;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5, R.drawable.banner6, R.drawable.banner7, R.drawable.banner8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        balanceResult = (TextView) findViewById(R.id.balanceResult);
        unitnores = (TextView) findViewById(R.id.unitnores);
        nametxt = (TextView) findViewById(R.id.nametxt);
        carouselView = findViewById(R.id.carouselView);

//        getTenant();
        getOneTenant();

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

    private void getOneTenant() {

//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://mytown-app.com/api/GetTenant/3304")
//                .build();
//
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//
//            if (response.isSuccessful()) {
//                String mMessage = response.body().string();
//                Gson gson = new Gson();
//
//                Tenant tenant = gson.fromJson(mMessage, Tenant.class);
//                nametxt.setText(tenant.getFirstname() + ' ' + tenant.getMiddlename().substring(0,1) + ' ' + tenant.getLastname());
//                unitnores.setText(tenant.getBldg_num().toUpperCase() + tenant.getRoom_id());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        Retrofit retrofit = apiLoader.fetchApi();

         jsonHolderApi = retrofit.create(JsonHolderApi.class);
//        loader.fetchUrl();

        Call<Tenant> call = jsonHolderApi.getTenant(3304);

        call.enqueue(new Callback<Tenant>() {
            @Override
            public void onResponse(Call<Tenant> call, Response<Tenant> response) {
                if (response.isSuccessful()) {
                    nametxt.setText(response.body().getFirstname() + ' ' + response.body().getMiddlename().substring(0,1) + ' ' + response.body().getLastname());
                    unitnores.setText(response.body().getBldg_num().toUpperCase() + response.body().getRoom_id());
//                    Log.d("WORKING...", "FirstName : " + response.body().getFirstname());
                }
            }

            @Override
            public void onFailure(Call<Tenant> call, Throwable t) {
                nametxt.setText(t.getMessage());
                unitnores.setText(t.getMessage());
            }
        });
    }

//    private void getTenant() {
//
//        Call<List<Tenant>> call = jsonHolderApi.getTenant();
//
//        call.enqueue(new Callback<List<Tenant>>() {
//            @Override
//            public void onResponse(Call<List<Tenant>> call, Response<List<Tenant>> response) {
//
//                if (!response.isSuccessful()) {
//                    balanceResult.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<Tenant> posts = response.body();
//
//                for (Tenant post : posts) {
//                    String content = "";
//                    content += "ID : " + post.getFirstname() + "\n";
//                    content += "User ID : " + post.getMiddlename() + "\n";
//                    content += "Title : " + post.getLastname() + "\n\n";
//
//                    balanceResult.append(content);
//                    Log.d("Main2Activity", "" + content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Tenant>> call, Throwable t) {
//                balanceResult.setText(t.getMessage());
//            }
//        });
//    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
