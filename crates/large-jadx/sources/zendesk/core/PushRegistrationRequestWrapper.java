package zendesk.core;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
class PushRegistrationRequestWrapper {

    @SerializedName("push_notification_device")
    private zendesk.core.PushRegistrationRequest pushRegistrationRequest;
    public PushRegistrationRequestWrapper(zendesk.core.PushRegistrationRequest pushRegistrationRequest) {
        super();
        this.pushRegistrationRequest = pushRegistrationRequest;
    }

    public zendesk.core.PushRegistrationRequest getPushRegistrationRequest() {
        return this.pushRegistrationRequest;
    }
}
