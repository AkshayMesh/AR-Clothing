package me.akshay.arclothing.ui.product.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.OneProductResponse;

public class ProductViewModel extends ViewModel implements ProductRepoCallback {

    public String description;

    public String previousPrice;

    public String currentPrice;

    public String title;

    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();
    private final MutableLiveData<OneProductResponse> productResponse = new MutableLiveData<>();
    private final MutableLiveData<MainProductResponse> productsResponse = new MutableLiveData<>();


    public LiveData<MainProductResponse> getProductsResponse() {
        return productsResponse;
    }

    public LiveData<OneProductResponse> getProductResponse() {
        return productResponse;
    }

    public LiveData<String> getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setValue(OneProductResponse r) {
        productResponse.setValue(r);
    }

    @Override
    public void setValue(String m) {
        errorMsg.setValue(m);
    }

    @Override
    public void setValue(MainProductResponse r) {
        productsResponse.setValue(r);
    }
}
