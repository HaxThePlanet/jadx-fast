package com.vimeo.networking;

import com.vimeo.networking.model.Comment;
import com.vimeo.networking.model.PictureResource;
import com.vimeo.networking.model.PinCodeInfo;
import com.vimeo.networking.model.Video;
import com.vimeo.networking.model.VimeoAccount;
import com.vimeo.networking.model.search.SearchResponse;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* compiled from: VimeoService.java */
/* loaded from: classes2.dex */
public interface VimeoService {
    @DELETE
    Call<Object> DELETE(@Header("Authorization") String str, @Url String str2, @QueryMap Map<String, String> map);

    @GET
    Call<Object> GET(@Header("Authorization") String str, @Url String str2, @QueryMap Map<String, String> map, @Header("Cache-Control") String str3);

    @POST
    Call<Object> POST(@Header("Authorization") String str, @Url String str2, @Header("Cache-Control") String str3, @Body HashMap<String, String> hashMap);

    @PUT
    Call<Object> PUT(@Header("Authorization") String str, @Url String str2, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("oauth/access_token")
    Call<VimeoAccount> authenticateWithCodeGrant(@Header("Authorization") String str, @Field("redirect_uri") String str2, @Field("code") String str3, @Field("grant_type") String str4);

    @FormUrlEncoded
    @POST("oauth/authorize/client")
    Call<VimeoAccount> authorizeWithClientCredentialsGrant(@Header("Authorization") String str, @Field("grant_type") String str2, @Field("scope") String str3);

    @POST
    Call<Comment> comment(@Header("Authorization") String str, @Url String str2, @QueryMap Map<String, String> map, @Body HashMap<String, String> hashMap);

    @POST
    Call<PictureResource> createPictureResource(@Header("Authorization") String str, @Url String str2);

    @PATCH
    Call<Object> edit(@Header("Authorization") String str, @Url String str2, @Body HashMap<String, Object> hashMap);

    @POST
    Call<Void> emptyResponsePost(@Header("Authorization") String str, @Url String str2, @Body HashMap<String, String> hashMap);

    @FormUrlEncoded
    @POST("oauth/authorize/vimeo_oauth1")
    Call<VimeoAccount> exchangeOAuthOneToken(@Header("Authorization") String str, @Field("grant_type") String str2, @Field("token") String str3, @Field("token_secret") String str4, @Field("scope") String str5);

    @FormUrlEncoded
    @Headers("Cache-Control: no-cache, no-store")
    @POST("oauth/device")
    Call<PinCodeInfo> getPinCodeInfo(@Header("Authorization") String str, @Field("grant_type") String str2, @Field("scope") String str3);

    @GET
    Call<Video> getVideo(@Header("Authorization") String str, @Header("Cache-Control") String str2, @Url String str3, @QueryMap Map<String, String> map);

    @POST("users")
    Call<VimeoAccount> join(@Header("Authorization") String str, @Body HashMap<String, String> hashMap);

    @FormUrlEncoded
    @POST("oauth/authorize/password")
    Call<VimeoAccount> logIn(@Header("Authorization") String str, @Field("username") String str2, @Field("password") String str3, @Field("grant_type") String str4, @Field("scope") String str5);

    @FormUrlEncoded
    @POST("oauth/authorize/facebook")
    Call<VimeoAccount> logInWithFacebook(@Header("Authorization") String str, @Field("grant_type") String str2, @Field("token") String str3, @Field("scope") String str4);

    @FormUrlEncoded
    @Headers("Cache-Control: no-cache, no-store")
    @POST("oauth/device/authorize")
    Call<VimeoAccount> logInWithPinCode(@Header("Authorization") String str, @Field("grant_type") String str2, @Field("user_code") String str3, @Field("device_code") String str4, @Field("scope") String str5);

    @DELETE("tokens")
    @Headers("Cache-Control: no-cache, no-store")
    Call<Object> logOut(@Header("Authorization") String str);

    @GET("search")
    @Headers("Cache-Control: no-cache, no-store")
    Call<SearchResponse> search(@Header("Authorization") String str, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("oauth/appexchange")
    Call<VimeoAccount> ssoTokenExchange(@Header("Authorization") String str, @Field("access_token") String str2, @Field("scope") String str3);
}
