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

/* loaded from: classes2.dex */
public interface VimeoService {
    @DELETE
    public abstract Call<Object> DELETE(String string, String string2, Map<String, String> map3);

    @GET
    public abstract Call<Object> GET(String string, String string2, Map<String, String> map3, String string4);

    @POST
    public abstract Call<Object> POST(String string, String string2, String string3, HashMap<String, String> hashMap4);

    @PUT
    public abstract Call<Object> PUT(String string, String string2, Map<String, String> map3);

    @FormUrlEncoded
    @POST("oauth/access_token")
    public abstract Call<VimeoAccount> authenticateWithCodeGrant(String string, String string2, String string3, String string4);

    @FormUrlEncoded
    @POST("oauth/authorize/client")
    public abstract Call<VimeoAccount> authorizeWithClientCredentialsGrant(String string, String string2, String string3);

    @POST
    public abstract Call<Comment> comment(String string, String string2, Map<String, String> map3, HashMap<String, String> hashMap4);

    @POST
    public abstract Call<PictureResource> createPictureResource(String string, String string2);

    @PATCH
    public abstract Call<Object> edit(String string, String string2, HashMap<String, Object> hashMap3);

    @POST
    public abstract Call<Void> emptyResponsePost(String string, String string2, HashMap<String, String> hashMap3);

    @FormUrlEncoded
    @POST("oauth/authorize/vimeo_oauth1")
    public abstract Call<VimeoAccount> exchangeOAuthOneToken(String string, String string2, String string3, String string4, String string5);

    @FormUrlEncoded
    @Headers("Cache-Control: no-cache, no-store")
    @POST("oauth/device")
    public abstract Call<PinCodeInfo> getPinCodeInfo(String string, String string2, String string3);

    @GET
    public abstract Call<Video> getVideo(String string, String string2, String string3, Map<String, String> map4);

    @POST("users")
    public abstract Call<VimeoAccount> join(String string, HashMap<String, String> hashMap2);

    @FormUrlEncoded
    @POST("oauth/authorize/password")
    public abstract Call<VimeoAccount> logIn(String string, String string2, String string3, String string4, String string5);

    @FormUrlEncoded
    @POST("oauth/authorize/facebook")
    public abstract Call<VimeoAccount> logInWithFacebook(String string, String string2, String string3, String string4);

    @FormUrlEncoded
    @Headers("Cache-Control: no-cache, no-store")
    @POST("oauth/device/authorize")
    public abstract Call<VimeoAccount> logInWithPinCode(String string, String string2, String string3, String string4, String string5);

    @DELETE("tokens")
    @Headers("Cache-Control: no-cache, no-store")
    public abstract Call<Object> logOut(String string);

    @GET("search")
    @Headers("Cache-Control: no-cache, no-store")
    public abstract Call<SearchResponse> search(String string, Map<String, String> map2);

    @FormUrlEncoded
    @POST("oauth/appexchange")
    public abstract Call<VimeoAccount> ssoTokenExchange(String string, String string2, String string3);
}
