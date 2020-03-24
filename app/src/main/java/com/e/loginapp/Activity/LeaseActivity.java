package com.e.loginapp.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.ApiServer.ApiLoader;
import com.e.loginapp.Model.Tenant;
import com.e.loginapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LeaseActivity extends AppCompatActivity {

    private ApiLoader apiLoader;
    private JsonHolderApi jsonHolderApi;
    final Context context = this;
    private Button extendbtn;

    private TextView unitno;
    private TextView bedRate;
    private TextView startDate;
    private TextView endDate;
    private TextView mytownClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease);

        extendbtn = (Button) findViewById(R.id.extendbtn);

        unitno = (TextView) findViewById(R.id.unitres);
        bedRate = (TextView) findViewById(R.id.bedrateres);
        startDate = (TextView) findViewById(R.id.startdatetxtres);
        endDate = (TextView) findViewById(R.id.enddatetxtres);
        mytownClub = (TextView) findViewById(R.id.subscribe);

        getLeasePlans();

        extendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Message");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Do you want to Extend Contract")
                        .setCancelable(false)
                        .setPositiveButton("YES",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                LeaseActivity.this.finish();
                            }
                        })
                        .setNegativeButton("NO",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });
    }

    private void getLeasePlans() {
        Retrofit retrofit = apiLoader.fetchApi();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);
        Call<Tenant> call = jsonHolderApi.getTenant(3304);

        call.enqueue(new Callback<Tenant>() {
            @Override
            public void onResponse(Call<Tenant> call, Response<Tenant> response) {
                if (response.isSuccessful()) {
                    unitno.setText(response.body().getBldg_num() + ' ' + response.body().getRoom_id() + ' ' + response.body().getBed_type());
                    bedRate.setText("PHP " + response.body().getPrice());
                    startDate.setText(response.body().getMoveIn());
                    endDate.setText(response.body().getMoveOut());
                    if (response.body().getClubMember().equals("1")) {
                        mytownClub.setText("Subscribed");
                    } else {
                        mytownClub.setText("Unsubscribed");
                    }
                }
            }

            @Override
            public void onFailure(Call<Tenant> call, Throwable t) {

            }
        });
    }
}
