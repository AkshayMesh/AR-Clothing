// Generated by data binding compiler. Do not edit!
package me.akshay.arclothing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.Deprecated;
import java.lang.Object;
import me.akshay.arclothing.R;

public abstract class LayoutLoaderBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout pbarContainer;

  @NonNull
  public final LottieAnimationView startProgress;

  protected LayoutLoaderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout pbarContainer, LottieAnimationView startProgress) {
    super(_bindingComponent, _root, _localFieldCount);
    this.pbarContainer = pbarContainer;
    this.startProgress = startProgress;
  }

  @NonNull
  public static LayoutLoaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_loader, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutLoaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutLoaderBinding>inflateInternal(inflater, R.layout.layout_loader, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutLoaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_loader, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutLoaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutLoaderBinding>inflateInternal(inflater, R.layout.layout_loader, null, false, component);
  }

  public static LayoutLoaderBinding bind(@NonNull View view) {
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
  public static LayoutLoaderBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutLoaderBinding)bind(component, view, R.layout.layout_loader);
  }
}
