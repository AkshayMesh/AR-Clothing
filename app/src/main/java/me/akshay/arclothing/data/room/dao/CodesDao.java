package me.akshay.arclothing.data.room.dao;

import java.util.List;

//@Dao
public interface CodesDao {
//todo complete the dao

//    @Query("SELECT * FROM " + TableNames.CODES)
    List<String> getScrollableCodes();

//    @Query("DELETE FROM " + TableNames.CODES)
    void nukeTable();

//    @Query("DELETE FROM " + TableNames.CODES + " WHERE video_Category =:cat")
    void killCat(String cat);

//    @Query("SELECT COUNT(id) FROM " + TableNames.CODES)
    int getRowCount();

//    @Query("SELECT * FROM " + TableNames.CODES + " WHERE video_Category =:prodCat" )
    List<String> getCodeByCategory(String prodCat);

//    @Insert
    void insertAll(String... codes);

}
