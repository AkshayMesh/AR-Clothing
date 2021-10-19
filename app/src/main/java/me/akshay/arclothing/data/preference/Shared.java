package me.akshay.arclothing.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import me.akshay.arclothing.common.index.Constants;

public class Shared {

    public static void setLocaleString(Context context, String key, String value){
        SharedPreferences sPref = context.getSharedPreferences(Constants.Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        SharedPreferences.Editor sPrefEditor = sPref.edit();
        sPrefEditor.putString(key, value);
        sPrefEditor.apply();
    }

    public static String getLocaleString(Context context, String key){
        SharedPreferences sPref = context.getSharedPreferences(Constants.Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        return sPref.getString(key, Constants.PreferenceKeys.EMPTY_KEY);
    }

    public static void setLocaleFlag(Context context, String key, boolean value){
        SharedPreferences sPref = context.getSharedPreferences(Constants.Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        SharedPreferences.Editor sPrefEditor = sPref.edit();
        sPrefEditor.putBoolean(key, value);
        sPrefEditor.apply();
    }

    public static boolean getLocaleFlag(Context context, String key){
        SharedPreferences sPref = context.getSharedPreferences(Constants.Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        return sPref.getBoolean(key, false);
    }

}
