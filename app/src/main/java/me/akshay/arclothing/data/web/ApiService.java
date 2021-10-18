package me.akshay.arclothing.data.web;

import me.akshay.arclothing.common.index.Constants;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SettingsResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST(Constants.Functions.SETTINGS_URL)
    Call<SettingsResponse> hitSetting(@Field("api_token") String apiToken);

    @FormUrlEncoded
    @POST(Constants.Functions.MAIN_PRODUCT_URL)
    Call<MainProductResponse> getProductMain(@Field("api_token") String apiToken,
                                             @Field("page") String page,
                                             @Field("existing") String existing,
                                             @Field("user_id") String userID);
}