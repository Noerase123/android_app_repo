package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.Model.Invoice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BillListActivity extends AppCompatActivity {

    LinearLayout billingmet;
    LinearLayout billingmet2;
    private String BASE_URL = "https://mytown-app.com/api/";
    private JsonHolderApi jsonHolderApi;

    private TextView invoiceRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);

        invoiceRes = (TextView) findViewById(R.id.textbill4);

        invoiceCollection();

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

    private void invoiceCollection() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);

        Call<List<Invoice>> call = jsonHolderApi.getInvoices();

        call.enqueue(new Callback<List<Invoice>>() {
            @Override
            public void onResponse(Call<List<Invoice>> call, Response<List<Invoice>> response) {

                if (!response.isSuccessful()) {
                    invoiceRes.setText("Code: " + response.code());
                    return;
                }

                List<Invoice> invoices = response.body();

                for (Invoice invoice : invoices) {
                    String content = "";
                    content += "ID : " + invoice.getInvoice_id() + "\n";
                    content += "Invoice Reference : " + invoice.getInvoice_ref() + "\n";
                    content += "Invoice Remaining : " + invoice.getInvoice_remaining() + "\n\n";

                    invoiceRes.append(content);
                    Log.d("BillListActivity", "" + content);

                }
            }

            @Override
            public void onFailure(Call<List<Invoice>> call, Throwable t) {
                invoiceRes.setText(t.getMessage());
            }
        });

    }
}
