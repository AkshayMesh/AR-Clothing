package me.akshay.arclothing.data.web;

import static me.akshay.arclothing.common.index.Constants.Extensions.PHP;
import static me.akshay.arclothing.common.index.Constants.Fields.COMMON_FIELD;
import static me.akshay.arclothing.common.index.Constants.Functions.ADD;
import static me.akshay.arclothing.common.index.Constants.Functions.ALL;
import static me.akshay.arclothing.common.index.Constants.ParentPath.PRODUCT;
import static me.akshay.arclothing.common.index.Constants.ParentPath.USER;

import me.akshay.arclothing.common.response.StringResponse;
import me.akshay.arclothing.common.response.UserRegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST(PRODUCT+ALL+PHP)
    Call<StringResponse> getSetting(@Field(COMMON_FIELD) String token);

    @FormUrlEncoded
    @POST(USER+ADD+PHP)
    Call<UserRegistrationResponse> setUserViaGoogle(@Field(COMMON_FIELD) String token,
                                                    @Field("name") String nm,
                                                    @Field("url") String url,
                                                    @Field("mail") String email,
                                                    @Field("loginType") String type);

    @FormUrlEncoded
    @POST(USER+ADD+PHP)
    Call<UserRegistrationResponse> setUserViaPhone(@Field(COMMON_FIELD) String token,
                                                    @Field("mobile") String nm,
                                                    @Field("loginType") String type);
}