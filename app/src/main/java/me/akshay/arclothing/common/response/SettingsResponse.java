package me.akshay.arclothing.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import me.akshay.arclothing.common.models.SettingsModel;

public class SettingsResponse {
    @SerializedName("status_code")
    @Expose
    public int status;

    @SerializedName("message")
    @Expose
    public String message;

    @SerializedName("data")
    @Expose
    public SettingsModel settingsModel;
}