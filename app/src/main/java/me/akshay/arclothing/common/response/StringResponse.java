package me.akshay.arclothing.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StringResponse {
    @SerializedName("status_code")
    @Expose
    public int statusCode;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("data")
    @Expose
    public String data;
}
