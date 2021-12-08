package me.akshay.arclothing.ui.dashboard.headerview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import me.akshay.arclothing.common.models.SliderModel;

public class SliderMainAdapter extends FragmentStatePagerAdapter {

    List<SliderModel> sliderModelList;

    public SliderMainAdapter(FragmentManager fm, List<SliderModel> mList) {
        super(fm);
        this.sliderModelList = mList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return SliderMainItemFragment.newInstance(sliderModelList.get(position), position);
    }

    @Override
    public int getCount() {
        return sliderModelList.size();
    }

}
