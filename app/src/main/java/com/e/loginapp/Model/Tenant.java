package com.e.loginapp.Model;

import com.google.gson.annotations.SerializedName;

public class Tenant {

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("middlename")
    private String middlename;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("email")
    private String email;

    @SerializedName("emergencyName")
    private String emergencyName;

    @SerializedName("emergencyNum")
    private String emergencyNum;

    @SerializedName("landline")
    private String landline;

    @SerializedName("city")
    private String city;

    @SerializedName("bldg_num")
    private String bldg_num;

    @SerializedName("room_id")
    private String room_id;

    @SerializedName("bed_type")
    private String bed_type;

    @SerializedName("price")
    private String price;

    @SerializedName("move_in_date")
    private String moveIn;

    @SerializedName("move_out_date")
    private String moveOut;

    @SerializedName("deposit")
    private String deposit;

    @SerializedName("security_deposit")
    private String securityDeposit;

    @SerializedName("club_member")
    private String clubMember;

    @SerializedName("phone")
    private String phone;

    public String getClubMember() {
        return clubMember;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public String getEmergencyNum() {
        return emergencyNum;
    }

    public String getLandline() {
        return landline;
    }

    public String getCity() {
        return city;
    }

    public String getBldg_num() {
        return bldg_num;
    }

    public String getRoom_id() {
        return room_id;
    }

    public String getBed_type() { return  bed_type; }

    public String getPrice() {
        return price;
    }

    public String getMoveIn() {
        return moveIn;
    }

    public String getMoveOut() {
        return moveOut;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getSecurityDeposit() {
        return securityDeposit;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

}
