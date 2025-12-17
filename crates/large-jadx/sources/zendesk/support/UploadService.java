package zendesk.support;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

/* loaded from: classes3.dex */
interface UploadService {
    @DELETE("/api/mobile/uploads/{token}.json")
    public abstract Call<Void> deleteAttachment(String string);

    @POST("/api/mobile/uploads.json")
    public abstract Call<zendesk.support.UploadResponseWrapper> uploadAttachment(String string, RequestBody requestBody2);
}
