package com.e.loginapp.Model;

import com.google.gson.annotations.SerializedName;

public class Invoice {

    @SerializedName("invoice_id")
    private String invoice_id;

    @SerializedName("invoice_ref")
    private String invoice_ref;

    @SerializedName("billing_date")
    private String billing_date;

    @SerializedName("due_date")
    private String due_date;

    @SerializedName("payment_status")
    private String payment_status;

    @SerializedName("invoice_total")
    private String invoice_total;

    @SerializedName("invoice_remaining")
    private String invoice_remaining;


    public String getInvoice_id() {
        return invoice_id;
    }

    public String getInvoice_ref() {
        return invoice_ref;
    }

    public String getBilling_date() {
        return billing_date;
    }

    public String getDue_date() {
        return due_date;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public String getInvoice_total() {
        return invoice_total;
    }

    public String getInvoice_remaining() {
        return invoice_remaining;
    }
}
