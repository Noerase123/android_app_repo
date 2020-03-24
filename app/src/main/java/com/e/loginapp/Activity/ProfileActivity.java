package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.ApiServer.ApiLoader;
import com.e.loginapp.Model.Tenant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    private ApiLoader apiLoader;
    private JsonHolderApi jsonHolderApi;
    TextView emailres;
    TextView unitres;
    TextView contactNo;
    TextView landlineNo;
    TextView location;
    TextView emergencyName;
    TextView emergencyNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        emailres = (TextView) findViewById(R.id.emailres);
        unitres = (TextView) findViewById(R.id.unitres);
        contactNo = (TextView) findViewById(R.id.bedrateres);
        landlineNo = (TextView) findViewById(R.id.startdatetxtres);
        location = (TextView) findViewById(R.id.enddatetxtres);
        emergencyName = (TextView) findViewById(R.id.emNameRes);
        emergencyNum = (TextView) findViewById(R.id.emNumberRes);

        emailres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Email", Toast.LENGTH_LONG).show();
            }
        });

        profileInfo();

    }

    private void profileInfo() {
        Retrofit retrofit = apiLoader.fetchApi();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<Tenant> call = jsonHolderApi.getTenant(3304);

        call.enqueue(new Callback<Tenant>() {
            @Override
            public void onResponse(Call<Tenant> call, Response<Tenant> response) {
                if (response.isSuccessful()) {
                    emailres.setText(response.body().getEmail());
                    unitres.setText(response.body().getBldg_num() + response.body().getRoom_id());
                    contactNo.setText(response.body().getPhone());
                    landlineNo.setText(response.body().getLandline());
                    location.setText(response.body().getCity());
                    emergencyName.setText(response.body().getEmergencyName());
                    emergencyNum.setText(response.body().getEmergencyNum());
//                    Log.d("WORKING...", "FirstName : " + response.body().getFirstname());
                }
            }

            @Override
            public void onFailure(Call<Tenant> call, Throwable t) {
//                nametxt.setText(t.getMessage());
            }
        });
    }
}
