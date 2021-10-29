package me.akshay.arclothing.common.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegistrationInfo {

    public String dateLogin;
    public String status;
    public String loginType;
    public String dateCreated;

    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("userfullname")
    @Expose
    public String userfullname;

    @SerializedName("userprofilepath")
    @Expose
    public String userprofilepath;

    @SerializedName("usermobileno")
    @Expose
    public String usermobileno;

    @SerializedName("useremail")
    @Expose
    public String useremail;



}
