package me.akshay.arclothing.ui.helper.common;

import static me.akshay.arclothing.common.index.Constants.ServerUrl.FULL_IMAGE_URL;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.sql.Date;

import me.akshay.arclothing.R;
import me.akshay.arclothing.ui.home.HomeActivity;
import me.akshay.arclothing.ui.login.LoginActivity;

public class UiHelper {

    /**
     * setting image Resource to view
     *
     * @param imageView View
     * @param resourceId Resource
     */
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, String resourceId) {

        Glide.with(imageView.getContext())
                .load(resourceId)
                .into(imageView);
    }


    /**
     * setting image bitmap to view
     *
     * @param imageView View
     * @param bitmap Bitmap
     *
     */
    @BindingAdapter("imageBitmap")
    public static void setImageFromBmp(ImageView imageView, String bitmap) {
        Glide.with(imageView.getContext())
                .load(bitmap)
                .apply(new RequestOptions())
                .into(imageView);
    }

    /**
     * Getting current date
     * @return String
     */
    public static String getCurrentDate() {
        return (new Date(System.currentTimeMillis())).toString();
    }

    /**
     * Hiding views from ui
     *
     * @param views View
     */
    public static void hideViews(View... views){
        for (View view :
                views) {
            view.setVisibility(View.GONE);
        }
    }

    /**
     * if user is not register than this signin pop up will show
     */
    public static void openSignInPopUp(Activity activity) {
        new AlertDialog.Builder(activity)
                .setMessage(activity.getString(R.string.need_sign_in))
                .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                    Intent intentLogin = new Intent(activity, LoginActivity.class);
                    activity.startActivity(intentLogin);
                })
                .setNegativeButton(android.R.string.no, null).show();
    }

    /**
     * abstract class for Launch Activity for some results
     */
    public static abstract class LaunchActivityForResult{
        public abstract void onResult(ActivityResult result);
        public ActivityResultLauncher<Intent> setLauncher(AppCompatActivity activity){
            return activity.registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(), this::onResult);
        }
    }

    public static void setUrlToImageView(Context context, ImageView view, String url){
        Glide.with(context).load(FULL_IMAGE_URL+url).placeholder(R.mipmap.ic_launcher_foreground).into(view);
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * Show views hidden from ui
     *
     * @param views View
     */
    public static void showViews(View... views){
        for (View view :
                views) {
            view.setVisibility(View.VISIBLE);
        }
    }
}
