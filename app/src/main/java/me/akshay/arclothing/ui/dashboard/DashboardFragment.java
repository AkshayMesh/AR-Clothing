package me.akshay.arclothing.ui.dashboard;

import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.MAIN_RESPONSE;
import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.PROD_CODE;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.common.models.SliderModel;
import me.akshay.arclothing.common.response.DashboardResponse;
import me.akshay.arclothing.data.preference.Shared;
import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.FragDashboardBinding;
import me.akshay.arclothing.ui.dashboard.adapter.DashboardDataAdapter;
import me.akshay.arclothing.ui.dashboard.adapter.FeatureProductAdapter;
import me.akshay.arclothing.ui.dashboard.adapter.OfferProductAdapter;
import me.akshay.arclothing.ui.dashboard.adapter.ProductAdapter;
import me.akshay.arclothing.ui.dashboard.headerview.SliderMainAdapter;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.home.HomeActivity;
import me.akshay.arclothing.ui.product.details.ProductDetailsActivity;

public class DashboardFragment extends Fragment implements ItemClickListener<ProductModel> {

    private DashboardViewModel mViewModel;
    private FragDashboardBinding binding;
    private FeatureProductAdapter fAdapter;
    private OfferProductAdapter oAdapter;
    private ProductAdapter pAdapter;
    private Activity mActivity;
    private DashboardResponse dashBoard;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_dashboard, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        if (mActivity!=null){
            initRecyclerViews();
            initDashBoardData();
        }
        if (mViewModel!=null){
            HomeActivity.visitedDashBoard = true;
        }
    }

    @Override
    public void onItemClick(View view, ProductModel item, int i) {
        Intent intent = new Intent(mActivity, ProductDetailsActivity.class);
        intent.putExtra(PROD_CODE, ""+item.productCode);
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(mActivity, view, getString(R.string.product_transition));
        startActivity(intent, options.toBundle());
    }

    private void initDashBoardData() {
        dashBoard = UtilityClass.Converter().fromJson(Shared.getLocaleString(mActivity, MAIN_RESPONSE), DashboardResponse.class);
        if (dashBoard==null){
            setAllTitleGone();
        }else {
            initMainSlider();
            addProductsToViews();
        }
    }

    private void addProductsToViews() {
        pAdapter.addItem(dashBoard.products.data);
        oAdapter.addItem(DashboardDataAdapter.from(dashBoard.products).getOfferProduct());
        fAdapter.addItem(DashboardDataAdapter.from(dashBoard.products).getFeaturedProduct());
    }

    /**
     * this func is used to hide view when data not found
     */
    private void setAllTitleGone() {
        binding.textViewRecentProducts.setVisibility(View.GONE);
        binding.textViewPopularProduct.setVisibility(View.GONE);
        binding.textViewFeaturedProducts.setVisibility(View.GONE);
    }

    private void initRecyclerViews() {
        initOfferProduct();
        initFeatureProduct();
        initAllProducts();
    }

    private void initAllProducts() {
        pAdapter = new ProductAdapter(new ArrayList<>(), mActivity);
        pAdapter.setItemClickedListener(this);
        binding.rvPDetailProductGrid.setHasFixedSize(false);
        binding.rvPDetailProductGrid.setLayoutManager(new GridLayoutManager(mActivity, 2));
        DividerItemDecoration decoration = new DividerItemDecoration(mActivity
                , DividerItemDecoration.VERTICAL);
        decoration.setDrawable(Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.text_strike_through, mActivity.getTheme())));
        binding.rvPDetailProductGrid.addItemDecoration(decoration);
        binding.rvPDetailProductGrid.setAdapter(pAdapter);
        binding.rvPDetailProductGrid.setNestedScrollingEnabled(false);
    }

    private void initFeatureProduct() {
        fAdapter = new FeatureProductAdapter(new ArrayList<>(), mActivity);
        fAdapter.setItemClickedListener(this);
        binding.rvFeatureProduct.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        binding.rvFeatureProduct.setAdapter(fAdapter);
    }

    private void initOfferProduct() {
        oAdapter = new OfferProductAdapter(new ArrayList<>(), mActivity);
        oAdapter.setItemClickedListener(this);
        binding.rvOfferProduct.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        binding.rvOfferProduct.setAdapter(oAdapter);
    }

    /**
     * adding slides in pager
     */
    private void initMainSlider(){
        PagerAdapter sliderMainAdapter = new SliderMainAdapter(getParentFragmentManager(), dashBoard.slides.data);
        binding.vpSliderMain.setAdapter(sliderMainAdapter);

        dots(0, dashBoard.slides.data);

        binding.vpSliderMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                dots(position, dashBoard.slides.data);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    /**
     * adding slider dots
     */
    private void dots(int current, List<SliderModel> sliderModelList) {
        binding.layoutSliderMainDots.removeAllViews();
        for (int i = 0; i < sliderModelList.size(); i++) {
            TextView dot = new TextView(mActivity);
            dot.setIncludeFontPadding(false);
            dot.setHeight((int) UiHelper.dpToPx(5, mActivity));
            dot.setWidth((int) UiHelper.dpToPx(5, mActivity));

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int marginAsDp = (int) UiHelper.dpToPx(4, mActivity);
            params.setMargins(marginAsDp, marginAsDp, marginAsDp, marginAsDp);
            dot.setLayoutParams(params);

            dot.setBackgroundResource(R.drawable.circle_border_bg_1);

            if (i == current) {
                dot.setBackgroundResource(R.drawable.circle_bg);
            }
            binding.layoutSliderMainDots.addView(dot);
        }
    }

}