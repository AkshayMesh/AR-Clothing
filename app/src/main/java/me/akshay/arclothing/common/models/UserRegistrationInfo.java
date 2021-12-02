package me.akshay.arclothing.common.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegistrationInfo {

    public String dateLogin;

    public String status;

    @SerializedName("login_type")
    @Expose
    public String loginType;

    @SerializedName("date_created")
    @Expose
    public String dateCreated;

    public UserRegistrationInfo() {}

    @SerializedName("prk_id")
    @Expose
    public String id;

    @SerializedName("username")
    @Expose
    public String username;

    @SerializedName("profile_url")
    @Expose
    public String profile_url;

    @SerializedName("mobile_no")
    @Expose
    public String mobile_no;

    @SerializedName("email")
    @Expose
    public String email;

}
