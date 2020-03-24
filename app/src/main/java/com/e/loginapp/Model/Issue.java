package com.e.loginapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Issue
 */
public class Issue {

    @SerializedName("issueDetails")
    private String details;

    @SerializedName("category")
    private String category;

    @SerializedName("anytime")
    private String anytime;

    @SerializedName("date1")
    private Date date1;

    @SerializedName("date2")
    private Date date2;

    @SerializedName("date3")
    private Date date3;

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAnytime(String anytime) {
        this.anytime = anytime;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public String getDetails() {
        return details;
    }

    public String getCategory() {
        return category;
    }

    public String getAnytime() {
        return anytime;
    }

    public Date getDate1() {
        return date1;
    }

    public Date getDate2() {
        return date2;
    }

    public Date getDate3() {
        return date3;
    }
}