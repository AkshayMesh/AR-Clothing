package me.akshay.arclothing.ui.product.details;

import static java.net.HttpURLConnection.HTTP_OK;
import static me.akshay.arclothing.common.index.Constants.ServerUrl.API_TOKEN;

import android.util.Log;

import androidx.annotation.NonNull;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.OneProductResponse;
import me.akshay.arclothing.data.web.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepo {
    private final ProductRepoCallback callBack;

    public ProductRepo(ProductRepoCallback callback) {
        this.callBack = callback;
    }

    public Call<OneProductResponse> getProduct(String id) {
        return RetrofitClient.getApiService().getProduct(API_TOKEN, id);
    }

    private Call<MainProductResponse> getProducts(){
        return RetrofitClient.getApiService().getProducts(API_TOKEN);
    }

    public void updateDetails(String id){
        getProduct(id).enqueue(new Callback<OneProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<OneProductResponse> call
                    , @NonNull Response<OneProductResponse> response) {
                if (response.body()!=null){
                    Log.d("Repo", "updateDetails: got response");
                    if (response.body().statusCode == HTTP_OK){
                        callBack.setValue(response.body());
                    }else {
                        callBack.setValue(response.body().message);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<OneProductResponse> call, @NonNull Throwable t) {
                Log.e("updateDetails", t.getMessage());
                callBack.setValue("Unable to configure settings");
            }
        });
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
}
