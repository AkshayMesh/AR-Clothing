package me.akshay.arclothing.common.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.akshay.arclothing.data.room.dao.TableNames;

@Entity(tableName = TableNames.CODES)
public class ProductInventory {


    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("product")
    @Expose
    public int product_id;
    public int available_qty;
    public String productName;
    public String productCode;
    public float prodGST;

    @SerializedName("price")
    @Expose
    public float price;
    public String imageUri;
    public float newPrice;

    @SerializedName("quantity")
    @Expose
    public int currentQuantity;
    public String userID;

    @SerializedName("vto")
    public int isTriable;

}
