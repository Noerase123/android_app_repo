package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.e.loginapp.Model.Tenant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;

    private int email;

    EditText username;
    EditText password;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run(){
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000);

        Button login = (Button) findViewById(R.id.btn_login);

        username = (EditText) findViewById(R.id.username_et);
        password = (EditText) findViewById(R.id.password_et);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               if (username.getText().toString().equals("test123") && password.getText().toString().equals("123456")) {
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);

                    username.setText("");
                    password.setText("");
//               }
//               else {
//                   Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG).show();
//               }
            }
        });
    }
}
