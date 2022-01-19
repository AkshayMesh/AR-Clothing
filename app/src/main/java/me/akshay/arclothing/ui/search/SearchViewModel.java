package me.akshay.arclothing.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.MainProductResponse;

public class SearchViewModel extends ViewModel implements SearchRepoCallBack{

    private final MutableLiveData<String> errorMsg = new MutableLiveData<>();
    private final MutableLiveData<CategoryResponse> catResponse = new MutableLiveData<>();
    private final MutableLiveData<MainProductResponse> prodResponse = new MutableLiveData<>();

    public LiveData<MainProductResponse> getProducts(){
        return prodResponse;
    }

    public LiveData<CategoryResponse> getCategories(){
        return catResponse;
    }

    public LiveData<String> getErrorMsg(){
        return errorMsg;
    }

    @Override
    public void setValue(String m) {
        errorMsg.setValue(m);
    }

    @Override
    public void setValue(CategoryResponse m) {
        catResponse.setValue(m);
    }

    @Override
    public void setValue(MainProductResponse m) {
        prodResponse.setValue(m);
    }

    public MainProductResponse getSortedArray(MainProductResponse p, String m){
        MainProductResponse res = new MainProductResponse();
        res.data = new ArrayList<>();
        for (ProductModel model : p.data)
            if (model.title.toLowerCase().contains(m.toLowerCase())){
                res.data.add(model);
            }
        res.data.size();
        return res;
    }
}
