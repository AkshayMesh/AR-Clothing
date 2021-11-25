package me.akshay.arclothing.ui.start;

import static java.net.HttpURLConnection.HTTP_OK;
import static me.akshay.arclothing.common.index.Constants.ServerUrl.API_TOKEN;

import android.util.Log;

import androidx.annotation.NonNull;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.StringResponse;
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

    public void updateSettings(){
        getSettings().enqueue(new Callback<MainProductResponse>() {
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
                callBack.setValue("Unable to get settings");
            }
        });
    }

    private Call<MainProductResponse> getSettings(){
        return RetrofitClient.getApiService().getSetting(API_TOKEN);
    }
}
