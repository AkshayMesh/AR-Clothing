package me.akshay.arclothing.ui.search;

import static java.net.HttpURLConnection.HTTP_OK;
import static me.akshay.arclothing.common.index.Constants.ServerUrl.API_TOKEN;

import android.util.Log;

import androidx.annotation.NonNull;

import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.data.web.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepo {

    private final SearchRepoCallBack callBack;

    public SearchRepo(SearchRepoCallBack callBack) {
        this.callBack = callBack;
    }

    public void updateProducts(){
        getProducts().enqueue(new Callback<MainProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<MainProductResponse> call
                    , @NonNull Response<MainProductResponse> response) {
                if (response.body()!=null){
                    Log.d("Repo", "updateSettings: got response");
                    if (response.body().statusCode == HTTP_OK){
                        callBack.setValue(response.body());
                    }else {
                        callBack.setValue(response.body().message);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainProductResponse> call, @NonNull Throwable t) {
                Log.e("Setting Response", t.getMessage());
                callBack.setValue("Unable to configure settings");
            }
        });
    }

    public void updateCats(){
        getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryResponse> call
                    , @NonNull Response<CategoryResponse> response) {
                if (response.body()!=null){
                    Log.d("Repo", "updateSettings: got response 2");
                    if (response.body().statusCode == HTTP_OK){
                        callBack.setValue(response.body());
                    }else {
                        callBack.setValue(response.body().message);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                Log.e("Setting Response", t.getMessage());
                callBack.setValue("Unable to configure settings");
            }
        });
    }

    private Call<MainProductResponse> getProducts(){
        return RetrofitClient.getApiService().getProducts(API_TOKEN);
    }

    private Call<CategoryResponse> getCategories(){
        return RetrofitClient.getApiService().getCats(API_TOKEN);
    }
}
