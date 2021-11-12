package me.akshay.arclothing.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.index.Constants.PreferenceKeys;
import me.akshay.arclothing.common.index.Constants.Credentials;
import me.akshay.arclothing.common.response.UserRegistrationResponse;

public class LocalPreference {

    public static void setLocaleString(Context context, String key, String value){
        SharedPreferences sPref = context.getSharedPreferences(Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        SharedPreferences.Editor sPrefEditor = sPref.edit();
        sPrefEditor.putString(key, value);
        sPrefEditor.apply();
    }

    public static String getLocaleString(Context context, String key){
        SharedPreferences sPref = context.getSharedPreferences(Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        return sPref.getString(key, PreferenceKeys.EMPTY_KEY);
    }

    public static void setLocaleFlag(Context context, String key, boolean value){
        SharedPreferences sPref = context.getSharedPreferences(Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        SharedPreferences.Editor sPrefEditor = sPref.edit();
        sPrefEditor.putBoolean(key, value);
        sPrefEditor.apply();
    }

    public static boolean getLocaleFlag(Context context, String key){
        SharedPreferences sPref = context.getSharedPreferences(Credentials.APP_KEY
                , Context.MODE_PRIVATE);
        return sPref.getBoolean(key, false);
    }

    public static void setUserLog(Context context, UserRegistrationResponse user){
        try{
            if (user!=null){
                FirebaseMessaging.getInstance().subscribeToTopic(user.userRegistrationInfo.id);
                FirebaseMessaging.getInstance().subscribeToTopic(context.getString(R.string.app_name));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = context.getSharedPreferences(Credentials.BASE, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(PreferenceKeys.USER, json);
        editor.apply();
        SharedPreferences.Editor editor1 = context.getSharedPreferences(Credentials.BASE, Context.MODE_PRIVATE).edit();
        editor1.putBoolean(PreferenceKeys.REGISTRATION, true);
        editor1.apply();
    }

    public static UserRegistrationResponse getUserLog(Context context){
        SharedPreferences myPref = context.getSharedPreferences(Credentials.BASE,Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = myPref.getString(PreferenceKeys.USER,"");
        return gson.fromJson(json, UserRegistrationResponse.class);
    }

    public static String getLoggedInUserId(Context context){
        try {
            return getUserLog(context).userRegistrationInfo.id;
        }catch ( NullPointerException e){
            return "";
        }
    }
}
