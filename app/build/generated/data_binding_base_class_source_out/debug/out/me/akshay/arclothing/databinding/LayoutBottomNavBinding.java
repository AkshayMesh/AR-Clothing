// Generated by view binder compiler. Do not edit!
package me.akshay.arclothing.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import me.akshay.arclothing.R;

public final class LayoutBottomNavBinding implements ViewBinding {
  @NonNull
  private final BottomNavigationView rootView;

  @NonNull
  public final BottomNavigationView bottomNav;

  private LayoutBottomNavBinding(@NonNull BottomNavigationView rootView,
      @NonNull BottomNavigationView bottomNav) {
    this.rootView = rootView;
    this.bottomNav = bottomNav;
  }

  @Override
  @NonNull
  public BottomNavigationView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutBottomNavBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutBottomNavBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_bottom_nav, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutBottomNavBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    BottomNavigationView bottomNav = (BottomNavigationView) rootView;

    return new LayoutBottomNavBinding((BottomNavigationView) rootView, bottomNav);
  }
}
