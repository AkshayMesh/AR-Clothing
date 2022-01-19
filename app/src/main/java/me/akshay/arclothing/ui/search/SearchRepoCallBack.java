package me.akshay.arclothing.ui.search;

import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.MainProductResponse;

public interface SearchRepoCallBack {
    void setValue(String m);
    void setValue(CategoryResponse m);
    void setValue(MainProductResponse m);
}
