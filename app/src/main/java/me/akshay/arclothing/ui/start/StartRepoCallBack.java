package me.akshay.arclothing.ui.start;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SettingsResponse;

public interface StartRepoCallBack {
    void setValue(MainProductResponse p);
    void setValue(SettingsResponse s);
    void setValue(String m);
}
