package me.akshay.arclothing.ui.start;

import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SliderResponse;

public interface StartRepoCallBack {
    void setValue(String m);
    void setValue(MainProductResponse m);
    void setValue(SliderResponse m);
    void setValue(CategoryResponse m);
}
