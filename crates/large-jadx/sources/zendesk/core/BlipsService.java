package zendesk.core;

import retrofit2.Call;
import retrofit2.http.GET;

/* loaded from: classes3.dex */
interface BlipsService {
    @GET("/embeddable_blip")
    public abstract Call<Void> send(String string);
}
