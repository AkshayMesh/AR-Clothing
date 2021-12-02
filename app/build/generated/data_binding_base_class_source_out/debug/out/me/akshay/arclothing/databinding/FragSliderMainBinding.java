// Generated by data binding compiler. Do not edit!
package me.akshay.arclothing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;
import me.akshay.arclothing.R;
import me.akshay.arclothing.common.models.SliderMain;

public abstract class FragSliderMainBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivSliderImage;

  @NonNull
  public final TextView tvSliderHeading;

  @NonNull
  public final TextView tvSliderPreheading;

  @Bindable
  protected SliderMain mModel;

  protected FragSliderMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivSliderImage, TextView tvSliderHeading, TextView tvSliderPreheading) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivSliderImage = ivSliderImage;
    this.tvSliderHeading = tvSliderHeading;
    this.tvSliderPreheading = tvSliderPreheading;
  }

  public abstract void setModel(@Nullable SliderMain model);

  @Nullable
  public SliderMain getModel() {
    return mModel;
  }

  @NonNull
  public static FragSliderMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag_slider_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragSliderMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragSliderMainBinding>inflateInternal(inflater, R.layout.frag_slider_main, root, attachToRoot, component);
  }

  @NonNull
  public static FragSliderMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag_slider_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragSliderMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragSliderMainBinding>inflateInternal(inflater, R.layout.frag_slider_main, null, false, component);
  }

  public static FragSliderMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragSliderMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragSliderMainBinding)bind(component, view, R.layout.frag_slider_main);
  }
}
