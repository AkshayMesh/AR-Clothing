package me.akshay.arclothing.ui.start;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SettingsResponse;

public class StartViewModel extends ViewModel implements StartRepoCallBack{
    private final MutableLiveData<SettingsResponse> settingsLiveData = new MutableLiveData<>();
    private final MutableLiveData<MainProductResponse> mainLiveData = new MutableLiveData<>();;
    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();

    public LiveData<SettingsResponse> getSettingsLiveData() {
        return settingsLiveData;
    }

    public LiveData<MainProductResponse> getMainLiveData() {
        return mainLiveData;
    }

    public LiveData<String> getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setValue(MainProductResponse p) {
        mainLiveData.setValue(p);
    }

    @Override
    public void setValue(SettingsResponse s) {
        settingsLiveData.setValue(s);
    }

    @Override
    public void setValue(String m) {
        errorMsg.setValue(m);
    }
}
