package me.akshay.arclothing.ui.dashboard.headerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.models.SliderModel;
import me.akshay.arclothing.databinding.FragSliderMainBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class SliderMainItemFragment extends Fragment {

    public static final String SLIDER_MAIN_KEY = "SLIDER_MAIN_KEY";
    public static final String SLIDER_MAIN_KEY_P = "SLIDER_MAIN_KEYs";
    private FragSliderMainBinding binding;

    public static SliderMainItemFragment newInstance(SliderModel sliderModel, int position) {
        Bundle args = new Bundle();
        args.putParcelable(SLIDER_MAIN_KEY, sliderModel);
        args.putInt(SLIDER_MAIN_KEY_P, position);

        SliderMainItemFragment fragment = new SliderMainItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_slider_main, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args == null) throw new AssertionError();
        SliderModel sliderModel = args.getParcelable(SLIDER_MAIN_KEY);
        if (sliderModel == null) throw new AssertionError();

        UiHelper.setUrlToImageView(getContext(), binding.ivSliderImage, sliderModel.getImageName());
        binding.setModel(sliderModel);
        if (sliderModel.getHeading().equals(".")){
            binding.tvSliderHeading.setText("");
        }
        if (sliderModel.getPreHeading().equals(".")){
            binding.tvSliderPreheading.setText("");
        }

        initOnClicks();
    }

    private void initOnClicks() {
        binding.ivSliderImage.setOnClickListener(view -> {
            //todo add listener event
        });
    }
}
