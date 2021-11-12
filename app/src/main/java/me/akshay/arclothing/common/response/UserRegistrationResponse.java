package me.akshay.arclothing.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import me.akshay.arclothing.common.models.UserRegistrationInfo;

public class UserRegistrationResponse {
    @SerializedName("status_code")
    @Expose
    public int statusCode;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("data")
    @Expose
    public UserRegistrationInfo userRegistrationInfo;
}
