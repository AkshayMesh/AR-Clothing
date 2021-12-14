package me.akshay.arclothing.data.web;

import static me.akshay.arclothing.common.index.Constants.Extensions.PHP;
import static me.akshay.arclothing.common.index.Constants.Fields.COMMON_FIELD;
import static me.akshay.arclothing.common.index.Constants.Functions.ADD;
import static me.akshay.arclothing.common.index.Constants.Functions.ALL;
import static me.akshay.arclothing.common.index.Constants.Functions.ONE;
import static me.akshay.arclothing.common.index.Constants.ParentPath.CATS;
import static me.akshay.arclothing.common.index.Constants.ParentPath.PRODUCT;
import static me.akshay.arclothing.common.index.Constants.ParentPath.SLIDER;
import static me.akshay.arclothing.common.index.Constants.ParentPath.USER;

import me.akshay.arclothing.common.response.CategoryResponse;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.OneProductResponse;
import me.akshay.arclothing.common.response.SliderResponse;
import me.akshay.arclothing.common.response.UserRegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    /**
     * PRODUCT APIs
     */
    @FormUrlEncoded
    @POST(PRODUCT+ONE+PHP)
    Call<OneProductResponse> getProduct(@Field(COMMON_FIELD) String token,
                                        @Field("product_id") String id);

    @FormUrlEncoded
    @POST(PRODUCT+ALL+PHP)
    Call<MainProductResponse> getProducts(@Field(COMMON_FIELD) String token);

    /**
     * SLIDER APIs
     */
    @FormUrlEncoded
    @POST(SLIDER+ALL+PHP)
    Call<SliderResponse> getSlides(@Field(COMMON_FIELD) String token);

    /**
     * CATEGORY APIs
     */
    @FormUrlEncoded
    @POST(CATS+ALL+PHP)
    Call<CategoryResponse> getCats(@Field(COMMON_FIELD) String token);

    /**
     * USER APIs
     */
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
                                                    @Field("mobile") String mo,
                                                    @Field("loginType") String type);

}