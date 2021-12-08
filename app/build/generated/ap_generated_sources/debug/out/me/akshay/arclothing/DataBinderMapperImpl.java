package me.akshay.arclothing;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.akshay.arclothing.databinding.AboutProductBindingImpl;
import me.akshay.arclothing.databinding.ActivityHomeBindingImpl;
import me.akshay.arclothing.databinding.ActivityLoginBindingImpl;
import me.akshay.arclothing.databinding.ActivityProductDetailsBindingImpl;
import me.akshay.arclothing.databinding.ActivityStartBindingImpl;
import me.akshay.arclothing.databinding.FragDashboardBindingImpl;
import me.akshay.arclothing.databinding.FragOtpBindingImpl;
import me.akshay.arclothing.databinding.FragSliderMainBindingImpl;
import me.akshay.arclothing.databinding.ItemFearureProductBindingImpl;
import me.akshay.arclothing.databinding.ItemOfferProductBindingImpl;
import me.akshay.arclothing.databinding.ItemProductBindingImpl;
import me.akshay.arclothing.databinding.ItemRelatedBindingImpl;
import me.akshay.arclothing.databinding.LayoutInterestProductBindingImpl;
import me.akshay.arclothing.databinding.LayoutLoaderBindingImpl;
import me.akshay.arclothing.databinding.LayoutNoInternetBindingImpl;
import me.akshay.arclothing.databinding.LayoutProductActionsBindingImpl;
import me.akshay.arclothing.databinding.LayoutProductDetailsBindingImpl;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ABOUTPRODUCT = 1;

  private static final int LAYOUT_ACTIVITYHOME = 2;

  private static final int LAYOUT_ACTIVITYLOGIN = 3;

  private static final int LAYOUT_ACTIVITYPRODUCTDETAILS = 4;

  private static final int LAYOUT_ACTIVITYSTART = 5;

  private static final int LAYOUT_FRAGDASHBOARD = 6;

  private static final int LAYOUT_FRAGOTP = 7;

  private static final int LAYOUT_FRAGSLIDERMAIN = 8;

  private static final int LAYOUT_ITEMFEARUREPRODUCT = 9;

  private static final int LAYOUT_ITEMOFFERPRODUCT = 10;

  private static final int LAYOUT_ITEMPRODUCT = 11;

  private static final int LAYOUT_ITEMRELATED = 12;

  private static final int LAYOUT_LAYOUTINTERESTPRODUCT = 13;

  private static final int LAYOUT_LAYOUTLOADER = 14;

  private static final int LAYOUT_LAYOUTNOINTERNET = 15;

  private static final int LAYOUT_LAYOUTPRODUCTACTIONS = 16;

  private static final int LAYOUT_LAYOUTPRODUCTDETAILS = 17;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(17);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.about_product, LAYOUT_ABOUTPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.activity_product_details, LAYOUT_ACTIVITYPRODUCTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.activity_start, LAYOUT_ACTIVITYSTART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.frag_dashboard, LAYOUT_FRAGDASHBOARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.frag_otp, LAYOUT_FRAGOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.frag_slider_main, LAYOUT_FRAGSLIDERMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.item_fearure_product, LAYOUT_ITEMFEARUREPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.item_offer_product, LAYOUT_ITEMOFFERPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.item_product, LAYOUT_ITEMPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.item_related, LAYOUT_ITEMRELATED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.layout_interest_product, LAYOUT_LAYOUTINTERESTPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.layout_loader, LAYOUT_LAYOUTLOADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.layout_no_internet, LAYOUT_LAYOUTNOINTERNET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.layout_product_actions, LAYOUT_LAYOUTPRODUCTACTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(me.akshay.arclothing.R.layout.layout_product_details, LAYOUT_LAYOUTPRODUCTDETAILS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ABOUTPRODUCT: {
          if ("layout/about_product_0".equals(tag)) {
            return new AboutProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for about_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTDETAILS: {
          if ("layout/activity_product_details_0".equals(tag)) {
            return new ActivityProductDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_details is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTART: {
          if ("layout/activity_start_0".equals(tag)) {
            return new ActivityStartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_start is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGDASHBOARD: {
          if ("layout/frag_dashboard_0".equals(tag)) {
            return new FragDashboardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for frag_dashboard is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGOTP: {
          if ("layout/frag_otp_0".equals(tag)) {
            return new FragOtpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for frag_otp is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGSLIDERMAIN: {
          if ("layout/frag_slider_main_0".equals(tag)) {
            return new FragSliderMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for frag_slider_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFEARUREPRODUCT: {
          if ("layout/item_fearure_product_0".equals(tag)) {
            return new ItemFearureProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_fearure_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMOFFERPRODUCT: {
          if ("layout/item_offer_product_0".equals(tag)) {
            return new ItemOfferProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_offer_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMPRODUCT: {
          if ("layout/item_product_0".equals(tag)) {
            return new ItemProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRELATED: {
          if ("layout/item_related_0".equals(tag)) {
            return new ItemRelatedBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_related is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTINTERESTPRODUCT: {
          if ("layout/layout_interest_product_0".equals(tag)) {
            return new LayoutInterestProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_interest_product is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTLOADER: {
          if ("layout/layout_loader_0".equals(tag)) {
            return new LayoutLoaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_loader is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNOINTERNET: {
          if ("layout/layout_no_internet_0".equals(tag)) {
            return new LayoutNoInternetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_no_internet is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTPRODUCTACTIONS: {
          if ("layout/layout_product_actions_0".equals(tag)) {
            return new LayoutProductActionsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_product_actions is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTPRODUCTDETAILS: {
          if ("layout/layout_product_details_0".equals(tag)) {
            return new LayoutProductDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_product_details is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "featureModel");
      sKeys.put(2, "model");
      sKeys.put(3, "offerProduct");
      sKeys.put(4, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(17);

    static {
      sKeys.put("layout/about_product_0", me.akshay.arclothing.R.layout.about_product);
      sKeys.put("layout/activity_home_0", me.akshay.arclothing.R.layout.activity_home);
      sKeys.put("layout/activity_login_0", me.akshay.arclothing.R.layout.activity_login);
      sKeys.put("layout/activity_product_details_0", me.akshay.arclothing.R.layout.activity_product_details);
      sKeys.put("layout/activity_start_0", me.akshay.arclothing.R.layout.activity_start);
      sKeys.put("layout/frag_dashboard_0", me.akshay.arclothing.R.layout.frag_dashboard);
      sKeys.put("layout/frag_otp_0", me.akshay.arclothing.R.layout.frag_otp);
      sKeys.put("layout/frag_slider_main_0", me.akshay.arclothing.R.layout.frag_slider_main);
      sKeys.put("layout/item_fearure_product_0", me.akshay.arclothing.R.layout.item_fearure_product);
      sKeys.put("layout/item_offer_product_0", me.akshay.arclothing.R.layout.item_offer_product);
      sKeys.put("layout/item_product_0", me.akshay.arclothing.R.layout.item_product);
      sKeys.put("layout/item_related_0", me.akshay.arclothing.R.layout.item_related);
      sKeys.put("layout/layout_interest_product_0", me.akshay.arclothing.R.layout.layout_interest_product);
      sKeys.put("layout/layout_loader_0", me.akshay.arclothing.R.layout.layout_loader);
      sKeys.put("layout/layout_no_internet_0", me.akshay.arclothing.R.layout.layout_no_internet);
      sKeys.put("layout/layout_product_actions_0", me.akshay.arclothing.R.layout.layout_product_actions);
      sKeys.put("layout/layout_product_details_0", me.akshay.arclothing.R.layout.layout_product_details);
    }
  }
}
