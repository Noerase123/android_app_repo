package com.e.loginapp.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.e.loginapp.R;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private int REQUEST_CODE_SOME_FEATURES_PERMISSIONS = 123;
    Button logoutbtn;
    TextView websitebtn;
    TextView bedrateres;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        int hasLocationPermission = checkSelfPermission( Manifest.permission.ACCESS_FINE_LOCATION );
        int hasSMSPermission = checkSelfPermission( Manifest.permission.SEND_SMS );
        List<String> permissions = new ArrayList<String>();
        if( hasLocationPermission != PackageManager.PERMISSION_GRANTED ) {
            permissions.add( Manifest.permission.ACCESS_FINE_LOCATION );
        }

        if( hasSMSPermission != PackageManager.PERMISSION_GRANTED ) {
            permissions.add( Manifest.permission.SEND_SMS );
        }

        if( !permissions.isEmpty() ) {
            requestPermissions( permissions.toArray( new String[permissions.size()] ), REQUEST_CODE_SOME_FEATURES_PERMISSIONS );
        }

        logoutbtn = (Button) findViewById(R.id.logoutbtn);
        websitebtn = (TextView) findViewById(R.id.websitebtn);
        bedrateres = (TextView) findViewById(R.id.bedrateres);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccountActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        websitebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inURL = "https://www.mytown.ph/";
                Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

                startActivity( browse );
            }
        });

        bedrateres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String number="56789855";
//                Intent intent4=new Intent(Intent.ACTION_CALL);
//                intent4.setData(Uri.parse("tel:"+number));
//                startActivity(intent4);
            }
        });



    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        switch ( requestCode ) {
//            case REQUEST_CODE_SOME_FEATURES_PERMISSIONS: {
//                for( int i = 0; i < permissions.length; i++ ) {
//                    if( grantResults[i] == PackageManager.PERMISSION_GRANTED ) {
//                        Log.d( "Permissions", "Permission Granted: " + permissions[i] );
//                    } else if( grantResults[i] == PackageManager.PERMISSION_DENIED ) {
//                        Log.d( "Permissions", "Permission Denied: " + permissions[i] );
//                    }
//                }
//            }
//            break;
//            default: {
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            }
//        }
//    }
}
