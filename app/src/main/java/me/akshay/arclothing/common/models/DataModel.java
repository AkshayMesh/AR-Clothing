package me.akshay.arclothing.common.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataModel {
    @SerializedName("slider")
    @Expose
    public ArrayList<SliderModel> mSliderModels;

    @SerializedName("category")
    @Expose
    public ArrayList<CategoryModel> categoryModel;

    @SerializedName("featured")
    @Expose
    public ArrayList<ProductModel> featureProduct;

    @SerializedName("popular")
    @Expose
    public ArrayList<ProductModel> popularProduct;

    @SerializedName("recent")
    @Expose
    public ArrayList<ProductModel> recentProduct;

    @SerializedName("existing")
    @Expose
    public List<String> existing;
}
