package zendesk.core;

import com.google.gson.JsonElement;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;

/* loaded from: classes3.dex */
interface SdkSettingsService {
    @GET("/api/private/mobile_sdk/settings/{applicationId}.json")
    public abstract Call<Map<String, JsonElement>> getSettings(String string, String string2);
}
