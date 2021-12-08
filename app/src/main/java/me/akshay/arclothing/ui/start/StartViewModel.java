package me.akshay.arclothing.ui.start;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.DashboardResponse;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SliderResponse;

public class StartViewModel extends ViewModel implements StartRepoCallBack{
    private final MutableLiveData<MainProductResponse> productResponse = new MutableLiveData<>();
    private final MutableLiveData<SliderResponse> slideResponse = new MutableLiveData<>();
    private final MutableLiveData<CategoryResponse> catResponse = new MutableLiveData<>();
    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();
    private final MutableLiveData<DashboardResponse> dashResponse = new MutableLiveData<>();
    private final DashboardResponse mModel = new DashboardResponse();

    public LiveData<MainProductResponse> getProductResponse() {
        return productResponse;
    }

    public LiveData<String> getErrorMsg() {
        return errorMsg;
    }

    public LiveData<DashboardResponse> getSettings(){
        return dashResponse;
    }

    @Override
    public void setValue(String m) {
        errorMsg.setValue(m);
    }

    @Override
    public void setValue(MainProductResponse response) {
        mModel.products = response;
        dashResponse.setValue(mModel);
        productResponse.setValue(response);
    }

    @Override
    public void setValue(SliderResponse m) {
        mModel.slides = m;
        dashResponse.setValue(mModel);
        slideResponse.setValue(m);
    }

    @Override
    public void setValue(CategoryResponse m) {
        mModel.categories = m;
        dashResponse.setValue(mModel);
        catResponse.setValue(m);
    }
}
