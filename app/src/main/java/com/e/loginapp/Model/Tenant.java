package com.e.loginapp.Model;

import com.google.gson.annotations.SerializedName;

public class Tenant {

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("middlename")
    private String middlename;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("bldg_num")
    private String bldg_num;

    @SerializedName("room_id")
    private String room_id;

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBldgNum() {
        return bldg_num;
    }

    public String getRoomID() {
        return room_id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
