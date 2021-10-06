package me.akshay.arclothing.data.room;

import android.content.Context;
import java.util.ArrayList;

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

    public void insertItem(String... items){
        getCodeDao().insertAll(items);
    }

    public void killCatCode(String cat){
        getCodeDao().killCat(cat);
    }

    public ArrayList<String> getAllCodes(){
        return new ArrayList<>(getCodeDao().getScrollableCodes());
    }

    public void deleteAllCodes(){
        getCodeDao().nukeTable();
    }

    public ArrayList<String> getSelectedCodes(String opt){
        return new ArrayList<>(getCodeDao().getCodeByCategory(opt));
    }

}
