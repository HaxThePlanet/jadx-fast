package zendesk.core;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

/* loaded from: classes3.dex */
interface PushRegistrationService {
    @POST("/api/mobile/push_notification_devices.json")
    public abstract Call<zendesk.core.PushRegistrationResponseWrapper> registerDevice(zendesk.core.PushRegistrationRequestWrapper pushRegistrationRequestWrapper);

    @DELETE("/api/mobile/push_notification_devices/{id}.json")
    public abstract Call<Void> unregisterDevice(String string);
}
