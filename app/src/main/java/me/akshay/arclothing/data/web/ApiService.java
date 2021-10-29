package me.akshay.arclothing.data.web;

import static me.akshay.arclothing.common.index.Constants.Extensions.PHP;
import static me.akshay.arclothing.common.index.Constants.Fields.COMMON_FIELD;
import static me.akshay.arclothing.common.index.Constants.Functions.ADD;
import static me.akshay.arclothing.common.index.Constants.Functions.ALL;
import static me.akshay.arclothing.common.index.Constants.ParentPath.PRODUCT;

import me.akshay.arclothing.common.response.StringResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST(PRODUCT+ALL+PHP)
    Call<StringResponse> getSetting(@Field(COMMON_FIELD) String token);
}