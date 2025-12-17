package zendesk.core;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* loaded from: classes3.dex */
interface UserService {
    @POST("/api/mobile/user_tags.json")
    public abstract Call<zendesk.core.UserResponse> addTags(zendesk.core.UserTagRequest userTagRequest);

    @DELETE("/api/mobile/user_tags/destroy_many.json")
    public abstract Call<zendesk.core.UserResponse> deleteTags(String string);

    @GET("/api/mobile/users/me.json")
    public abstract Call<zendesk.core.UserResponse> getUser();

    @GET("/api/mobile/user_fields.json")
    public abstract Call<zendesk.core.UserFieldResponse> getUserFields();

    @PUT("/api/mobile/users/me.json")
    public abstract Call<zendesk.core.UserResponse> setUserFields(zendesk.core.UserFieldRequest userFieldRequest);
}
