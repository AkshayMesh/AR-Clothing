package me.akshay.arclothing.common.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductModel {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("product_code")
    @Expose
    public String productCode;

    @SerializedName("category")
    @Expose
    public int category;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("image_name")
    @Expose
    public String imageUri;

    @SerializedName("image_resolution")
    @Expose
    public String imageResolution;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("prev_price")
    @Expose
    public float previousPrice;

    @SerializedName("current_price")
    @Expose
    public float currentPrice;

    @SerializedName("product_gst")
    @Expose
    public float prodGst;

    @SerializedName("product_delivery_price")
    @Expose
    public float delivery_price;

    @SerializedName("featured")
    @Expose
    public int featured;

    @SerializedName("created")
    @Expose
    public String created;

    public int isFavourite;

}
