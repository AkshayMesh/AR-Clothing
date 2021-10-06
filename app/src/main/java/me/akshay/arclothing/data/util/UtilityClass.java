package me.akshay.arclothing.data.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class UtilityClass {
    public static String objectToString(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
    public static <T> Object stringToObject(String jsonProduct, Class<T> obj) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<T>(){}.getType();
        return gson.fromJson(jsonProduct, collectionType);
    }
    /**
     * Hide keyboard
     * @param activity activity
     */
    public static void hideSoftInput(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view == null) view = new View(activity);
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
