package me.akshay.arclothing.ui.start;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.akshay.arclothing.common.response.StringResponse;

public class StartViewModel extends ViewModel implements StartRepoCallBack{
    private final MutableLiveData<StringResponse> settingsLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();

    public LiveData<StringResponse> getSettingsLiveData() {
        return settingsLiveData;
    }

    public LiveData<String> getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setValue(String m) {
        errorMsg.setValue(m);
    }

    @Override
    public void setValue(StringResponse response) {
        settingsLiveData.setValue(response);
    }
}
