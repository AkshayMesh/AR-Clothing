package me.akshay.arclothing.ui.login;

import me.akshay.arclothing.common.response.UserRegistrationResponse;

public interface LoginRepoCallBack {
    void setValue(String m);
    void setValue(String s, boolean b);
    void setValue(boolean f);
    void setValue(UserRegistrationResponse r);
}
