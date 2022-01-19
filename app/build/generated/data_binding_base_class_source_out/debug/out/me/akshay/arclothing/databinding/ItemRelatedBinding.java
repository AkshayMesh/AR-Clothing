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
import me.akshay.arclothing.ui.product.details.ProductViewModel;

public abstract class ItemRelatedBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textViewPrice;

  @Bindable
  protected ProductViewModel mModel;

  protected ItemRelatedBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imageView, TextView textViewPrice) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textViewPrice = textViewPrice;
  }

  public abstract void setModel(@Nullable ProductViewModel model);

  @Nullable
  public ProductViewModel getModel() {
    return mModel;
  }

  @NonNull
  public static ItemRelatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_related, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemRelatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemRelatedBinding>inflateInternal(inflater, R.layout.item_related, root, attachToRoot, component);
  }

  @NonNull
  public static ItemRelatedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_related, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemRelatedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemRelatedBinding>inflateInternal(inflater, R.layout.item_related, null, false, component);
  }

  public static ItemRelatedBinding bind(@NonNull View view) {
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
  public static ItemRelatedBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemRelatedBinding)bind(component, view, R.layout.item_related);
  }
}
