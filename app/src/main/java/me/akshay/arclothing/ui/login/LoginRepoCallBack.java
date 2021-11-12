package me.akshay.arclothing.ui.login;

import me.akshay.arclothing.common.response.UserRegistrationResponse;

public interface LoginRepoCallBack {
    void setValue(String m);
    void setValue(boolean f);
    void setValue(UserRegistrationResponse r);
}
