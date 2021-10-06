package me.akshay.arclothing.data.util;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

public class StatusBarHelper {
    public static void getStatusBarTransparent(Activity activity, int colorId){
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN);
        window.setStatusBarColor(ContextCompat.getColor(activity, colorId));
    }
}
