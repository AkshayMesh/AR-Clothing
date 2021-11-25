package me.akshay.arclothing.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.akshay.arclothing.common.response.UserRegistrationResponse;

public class LoginViewModel extends ViewModel implements LoginRepoCallBack {

    private final MutableLiveData<String> token = new MutableLiveData<>();
    private final MutableLiveData<String> toastMessage = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();
    private final MutableLiveData<UserRegistrationResponse> userSignInResponse = new MutableLiveData<>();
    public MutableLiveData<String> getToken() {
        return token;
    }

    public MutableLiveData<String> getToastMessage() {
        return toastMessage;
    }

    public MutableLiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }

    public MutableLiveData<UserRegistrationResponse> getUserSignInResponse() {
        return userSignInResponse;
    }

    @Override
    public void setValue(String m) {
        this.toastMessage.setValue(m);
    }

    @Override
    public void setValue(String s, boolean b) {
        token.setValue(s);
    }

    @Override
    public void setValue(boolean f) {
        loginStatus.setValue(f);
    }

    @Override
    public void setValue(UserRegistrationResponse r) {
        userSignInResponse.setValue(r);
    }

}
