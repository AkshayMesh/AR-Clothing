package me.akshay.arclothing.ui.dashboard;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.common.models.Slider;
import me.akshay.arclothing.common.models.SliderMain;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.databinding.FragDashboardBinding;
import me.akshay.arclothing.ui.dashboard.adapter.FeatureProductAdapter;
import me.akshay.arclothing.ui.dashboard.adapter.OfferProductAdapter;
import me.akshay.arclothing.ui.dashboard.adapter.ProductAdapter;
import me.akshay.arclothing.ui.dashboard.headerview.SliderMainAdapter;
import me.akshay.arclothing.ui.helper.common.Loader;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class DashboardFragment extends Fragment implements ItemClickListener<ProductModel> {

    private DashboardViewModel mViewModel;
    private FragDashboardBinding binding;
    private boolean iSRegistered;
    private FeatureProductAdapter fAdapter;
    private OfferProductAdapter oAdapter;
    private ProductAdapter pAdapter;
    private Activity mActivity;
    private Loader mLoader;

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

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
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        if (mActivity!=null){
            mLoader = new Loader(mActivity);
            iSRegistered = Local.getLogStatus(mActivity);
            initRecyclerViews();
        }
        if (mViewModel!=null){

        }
    }

    private void initRecyclerViews() {
//        initMainSlider();
        initOfferProduct();
    }

    private void initOfferProduct() {
        oAdapter = new OfferProductAdapter(new ArrayList<>(), mActivity);
        oAdapter.setItemClickedListener(this);
    }

    private void initMainSlider(){
        //todo init from local
        Slider sliderMainList = new Slider();
        PagerAdapter sliderMainAdapter = new SliderMainAdapter(getParentFragmentManager(), sliderMainList.mSliderMains);
        binding.vpSliderMain.setAdapter(sliderMainAdapter);

        dots(0, sliderMainList.mSliderMains);

        binding.vpSliderMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                dots(position, sliderMainList.mSliderMains);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }



    /**
     * adding slider dots
     */
    private void dots(int current, List<SliderMain> sliderMainList) {
        binding.layoutSliderMainDots.removeAllViews();
        for (int i = 0; i < sliderMainList.size(); i++) {
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

    @Override
    public void onItemClick(View view, ProductModel item, int i) {

    }
}