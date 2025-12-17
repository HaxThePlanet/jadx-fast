package zendesk.core;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
class PushRegistrationResponseWrapper {

    @SerializedName("push_notification_device")
    private zendesk.core.PushRegistrationResponse registrationResponse;
    zendesk.core.PushRegistrationResponse getRegistrationResponse() {
        return this.registrationResponse;
    }
}
