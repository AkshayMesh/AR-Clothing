package me.akshay.arclothing.data.util;

import static me.akshay.arclothing.common.index.Constants.StringConstants.IND_CODE;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import me.akshay.arclothing.R;

/**
 * Highly classified class
 * not to be deleted or updated
 */
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

    /**
     * checking mobile number validation
     */
    public static boolean mobileValidity(String mobNo){
        final String regexStr = "\\d{10}";
        return mobNo.matches(regexStr);
    }

    /**
     * Builds Google Sign In Options
     * @param context to access the resources
     * @return Object of GoogleSignInOptions
     */
    @NonNull
    public static GoogleSignInOptions getBuild(Context context) {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
    }

    public static void commitFragment(FragmentActivity a, int parentId, Fragment baseFragment) {
        a.getSupportFragmentManager()
                .beginTransaction()
                .replace(parentId, baseFragment, baseFragment.getClass().getName())
                .commit();
    }

    /**
     * Builds Phone Authentication Options
     * @param mAuth Firebase auth
     * @param a Android Activity
     * @param s String Format Phone Number
     * @param callBack Call Back for handling response
     * @return Object of PhoneAuthOptions
     */
    @NonNull
    public static PhoneAuthOptions getBuild(FirebaseAuth mAuth, Activity a,@NonNull String s, PhoneAuthProvider.OnVerificationStateChangedCallbacks callBack) {
        return PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(IND_CODE+s)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(a)                 // Activity (for callback binding)
                .setCallbacks(callBack)          // OnVerificationStateChangedCallbacks
                .build();
    }
}
