package me.akshay.arclothing.common;

import android.view.View;

public interface ItemClickListener<T>{
    void onItemClick(View view, T item, int i);
}
