package com.e.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.e.loginapp.ApiServer.JsonHolderApi;
import com.e.loginapp.ApiServer.ApiLoader;
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
    private ApiLoader apiLoader;
    private JsonHolderApi jsonHolderApi;

    private TextView invoiceRef;
    private TextView invoiceAmount;
    private TextView invoiceBillingDate;

    private TextView invoiceRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_list);

        invoiceRes = (TextView) findViewById(R.id.textbill4);

        invoiceRef = (TextView) findViewById(R.id.invoice_ref);
        invoiceAmount = (TextView) findViewById(R.id.invoice_balance);
        invoiceBillingDate = (TextView) findViewById(R.id.invoice_billing_date);

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

        Retrofit retrofit = apiLoader.fetchApi();

        jsonHolderApi = retrofit.create(JsonHolderApi.class);

        Call<List<Invoice>> call = jsonHolderApi.getInvoices();

        call.enqueue(new Callback<List<Invoice>>() {
            @Override
            public void onResponse(Call<List<Invoice>> call, Response<List<Invoice>> response) {

//                if (!response.isSuccessful()) {
//                    invoiceRes.setText("Code: " + response.code());
//                    return;
//                }

                if (response.isSuccessful()) {
                    List<Invoice> invoices = response.body();

                    for (Invoice invoice : invoices) {
                        invoiceRef.setText(invoice.getInvoice_ref());
                        invoiceAmount.setText(invoice.getInvoice_total());
                        invoiceBillingDate.setText(invoice.getBilling_date());
                    }
                }

//                List<Invoice> invoices = response.body();
//
//                for (Invoice invoice : invoices) {
//                    String content = "";
//                    content += "ID : " + invoice.getInvoice_id() + "\n";
//                    content += "Invoice Reference : " + invoice.getInvoice_ref() + "\n";
//                    content += "Invoice Remaining : " + invoice.getInvoice_remaining() + "\n\n";
//
//                    invoiceRes.append(content);
//                    Log.d("BillListActivity", "" + content);
//
//                }
            }

            @Override
            public void onFailure(Call<List<Invoice>> call, Throwable t) {
                invoiceRes.setText(t.getMessage());
            }
        });

    }
}
