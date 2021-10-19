package me.akshay.arclothing.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.index.Constants;
import me.akshay.arclothing.common.index.Constants.Credentials;
import me.akshay.arclothing.common.index.Constants.PreferenceKeys;
import me.akshay.arclothing.common.models.Slider;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.UserRegistrationResponse;

public class Local {

    public static void setCurrency(Context context, String currency){
        SharedPreferences.Editor editor = context.getSharedPreferences(Credentials.SHARED_PREF_CURRENCY, Context.MODE_PRIVATE).edit();
        editor.putString(Credentials.SHARED_PREF_CURRENCY_IN, currency);
        editor.commit();
    }

    public static void setSlider(Context context, Slider response) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Credentials.BASE,
                Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(response);
        editor.putString(Constants.PreferenceKeys.MAIN_RESPONSE, json);
        editor.commit();
    }

    public static void setMainResponse(Context context, MainProductResponse response){
        SharedPreferences.Editor editor = context.getSharedPreferences(Credentials.BASE, Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(response);
        editor.putString(Constants.PreferenceKeys.MAIN_RESPONSE, json);
        editor.commit();
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
