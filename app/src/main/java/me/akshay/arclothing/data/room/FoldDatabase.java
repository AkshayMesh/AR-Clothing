package me.akshay.arclothing.data.room;


import android.content.Context;

import androidx.room.Database;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.room.dao.CodesDao;

//@Database(entities = {String.class},
//        version = 1, exportSchema = false)
public abstract class FoldDatabase extends AppDatabase {

    private static volatile FoldDatabase sInstance;

    public static synchronized FoldDatabase on(){ return sInstance; }

    public static synchronized void init(Context context){
        if (sInstance == null){
            synchronized (FoldDatabase.class){
                sInstance = createDb(context, context.getString(R.string.app_name), FoldDatabase.class);
            }
        }
    }

    public abstract CodesDao codeDao();

}
