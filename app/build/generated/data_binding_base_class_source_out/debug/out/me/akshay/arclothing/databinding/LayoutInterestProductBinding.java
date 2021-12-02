// Generated by data binding compiler. Do not edit!
package me.akshay.arclothing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.Deprecated;
import java.lang.Object;
import me.akshay.arclothing.R;

public abstract class LayoutInterestProductBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout layoutInterestedProduct;

  @NonNull
  public final RecyclerView recyclerViewInterest;

  @NonNull
  public final TextView textViewTitle;

  protected LayoutInterestProductBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout layoutInterestedProduct, RecyclerView recyclerViewInterest,
      TextView textViewTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.layoutInterestedProduct = layoutInterestedProduct;
    this.recyclerViewInterest = recyclerViewInterest;
    this.textViewTitle = textViewTitle;
  }

  @NonNull
  public static LayoutInterestProductBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_interest_product, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutInterestProductBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutInterestProductBinding>inflateInternal(inflater, R.layout.layout_interest_product, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutInterestProductBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_interest_product, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutInterestProductBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutInterestProductBinding>inflateInternal(inflater, R.layout.layout_interest_product, null, false, component);
  }

  public static LayoutInterestProductBinding bind(@NonNull View view) {
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
  public static LayoutInterestProductBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutInterestProductBinding)bind(component, view, R.layout.layout_interest_product);
  }
}