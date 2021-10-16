package me.akshay.arclothing.data.room.dao;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import me.akshay.arclothing.common.models.ProductInventory;

//@Dao
public interface CodesDao {

    @Query("SELECT * FROM " + TableNames.CODES)
    List<String> getScrollableCodes();

    @Query("DELETE FROM " + TableNames.CODES)
    void nukeTable();

    @Query("DELETE FROM " + TableNames.CODES + " WHERE id = :id and productCode =:code")
    void killProduct(int id, String code);

    @Query("SELECT COUNT(id) FROM " + TableNames.CODES)
    int getRowCount();

    @Query("UPDATE " + TableNames.CODES + " SET currentQuantity = :quantity WHERE id =:id")
    void change(int quantity, int id);

    @Insert
    void insertAll(ProductInventory... codes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertBulk(List<ProductInventory> entity);

}
