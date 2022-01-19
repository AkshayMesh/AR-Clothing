package me.akshay.arclothing.data.room;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

import me.akshay.arclothing.common.models.ProductInventory;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.data.room.dao.CodesDao;

public class DatabaseUtil {
    /**
     * Fields
     */
    private static DatabaseUtil sInstance;
    private CodesDao mCodeDao;

    private DatabaseUtil() {
        setCodeDao(FoldDatabase.on().codeDao());
        //add more here
    }

    /**
     * This method builds an instance
     */
    public static void init(Context context) {
        FoldDatabase.init(context);

        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }
    }

    public static DatabaseUtil on() {
        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }

        return sInstance;
    }

    public CodesDao getCodeDao() {
        return mCodeDao;
    }

    public void setCodeDao(CodesDao mCodeDao) {
        this.mCodeDao = mCodeDao;
    }

    public void killCatCode(int id, String code){
        getCodeDao().killProduct(id, code);
    }

    public ArrayList<ProductInventory> getAllCodes(){
        return new ArrayList<>(getCodeDao().getScrollableCodes());
    }

    public void deleteAllCodes(){
        getCodeDao().nukeTable();
    }

    public void insertItem(ProductInventory productInventory) {
        getCodeDao().insertAll(productInventory);
    }

    public void insertAll(List<ProductInventory> inventoryList) {
        getCodeDao().insertBulk(inventoryList);
    }

    public static ProductInventory getInventoryFromModel(ProductModel model){
        ProductInventory inventory = new ProductInventory();
        inventory.available_qty = 1;
        inventory.currentQuantity = 1;
        inventory.imageUri = model.imageUri;
        inventory.prodGST = model.prodGst;
        inventory.productName = model.title;
        inventory.newPrice = model.currentPrice;
        inventory.productCode = model.productCode;
        inventory.price = model.previousPrice;
        return inventory;
    }

}
