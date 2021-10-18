package me.akshay.arclothing.ui.start;

import static me.akshay.arclothing.common.index.Constants.ServerUrl.API_TOKEN;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SettingsResponse;
import me.akshay.arclothing.data.web.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <strong>Private Resources :
 * use of this Class may
 * subject to copyright</strong>
 */
public class StartRepo {

    private final StartRepoCallBack callBack;

    public StartRepo(StartRepoCallBack callBack) {
        this.callBack = callBack;
    }

    public void updateProducts(String id){
        AsyncTask.execute(()-> getMain(id).enqueue(new Callback<MainProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<MainProductResponse> call
                    , @NonNull Response<MainProductResponse> response) {
                if (response.body() != null) {
                    callBack.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainProductResponse> call, @NonNull Throwable t) {
                Log.e("Setting Response", t.getMessage());
                callBack.setValue("Unable to get settings");
            }
        }));
    }

    private Call<MainProductResponse> getMain(String id){
        return RetrofitClient.getApiService().getProductMain(
                API_TOKEN, "1","", id
        );
    }

    public void updateSettings(String id){
        getSettings().enqueue(new Callback<SettingsResponse>() {
            @Override
            public void onResponse(@NonNull Call<SettingsResponse> call
                    ,@NonNull Response<SettingsResponse> response) {
                if (response.body()!=null){
                    callBack.setValue(response.body());
                    updateProducts(id);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SettingsResponse> call, @NonNull Throwable t) {
                Log.e("Setting Response", t.getMessage());
                callBack.setValue("Unable to get settings");
            }
        });
    }

    private Call<SettingsResponse> getSettings(){
        return RetrofitClient.getApiService().hitSetting(API_TOKEN);
    }
}
