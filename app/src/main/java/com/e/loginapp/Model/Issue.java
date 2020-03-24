package com.e.loginapp.Model;

import com.google.gson.annotations.SerializedName;
/**
 * Issue
 */
public class Issue {

    @SerializedName("issueDetails")
    private String details;

    @SerializedName("category")
    private String category;

    @SerializedName("anytime")
    private int anytime;

    @SerializedName("date1")
    private String date1;

    @SerializedName("date2")
    private String date2;

    @SerializedName("date3")
    private String date3;

    Issue(String details, String category, int anytime, String date1, String date2, String date3) {
        this.details = details;
        this.category = category;
        this.anytime = anytime;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
    }

    public String getDetails() {
        return details;
    }

    public String getCategory() {
        return category;
    }

    public int getAnytime() {
        return anytime;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }

    public String getDate3() {
        return date3;
    }
}