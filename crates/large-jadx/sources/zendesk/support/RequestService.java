package zendesk.support;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* loaded from: classes3.dex */
interface RequestService {
    @PUT("/api/mobile/requests/{id}.json?include=last_comment")
    public abstract Call<zendesk.support.RequestResponse> addComment(String string, zendesk.support.UpdateRequestWrapper updateRequestWrapper2);

    @POST("/api/mobile/requests.json?include=last_comment")
    public abstract Call<zendesk.support.RequestResponse> createRequest(String string, zendesk.support.CreateRequestWrapper createRequestWrapper2);

    @GET("/api/mobile/requests.json?sort_by=updated_at&sort_order=desc")
    public abstract Call<zendesk.support.RequestsResponse> getAllRequests(String string, String string2);

    @GET("/api/mobile/requests/{id}/comments.json?sort_order=desc")
    public abstract Call<zendesk.support.CommentsResponse> getComments(String string);

    @GET("/api/mobile/requests/{id}/comments.json?sort_order=desc")
    public abstract Call<zendesk.support.CommentsResponse> getCommentsSince(String string, String string2, String string3);

    @GET("/api/mobile/requests/show_many.json?sort_order=desc")
    public abstract Call<zendesk.support.RequestsResponse> getManyRequests(String string, String string2, String string3);

    @GET("/api/mobile/requests/{id}.json")
    public abstract Call<zendesk.support.RequestResponse> getRequest(String string, String string2);

    @GET("/api/v2/ticket_forms/show_many.json?active=true")
    public abstract Call<zendesk.support.RawTicketFormResponse> getTicketFormsById(String string, String string2);
}
