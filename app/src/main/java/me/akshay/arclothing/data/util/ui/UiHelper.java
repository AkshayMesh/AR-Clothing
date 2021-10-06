package me.akshay.arclothing.data.util.ui;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class UiHelper {
    /**
     * setting image url to view
     *
     * @param imageView
     * @param resourceId
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
     */
    @BindingAdapter("imageBitmap")
    public static void setImageFromUri(ImageView imageView, String bitmap) {
        Glide.with(imageView.getContext())
                .load(bitmap)
                .apply(new RequestOptions())
                .into(imageView);
    }
}
