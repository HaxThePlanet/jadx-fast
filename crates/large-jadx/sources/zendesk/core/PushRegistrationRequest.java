package zendesk.core;

/* loaded from: classes3.dex */
class PushRegistrationRequest {

    private final String deviceType;
    private String identifier;
    private String locale;
    private String sdkGuid;
    private String tokenType;
    PushRegistrationRequest() {
        super();
        this.deviceType = "android";
    }

    String getIdentifier() {
        return this.identifier;
    }

    String getLocale() {
        return this.locale;
    }

    String getSdkGuid() {
        return this.sdkGuid;
    }

    String getTokenType() {
        return this.tokenType;
    }

    void setIdentifier(String string) {
        this.identifier = string;
    }

    void setLocale(String string) {
        this.locale = string;
    }

    void setSdkGuid(String string) {
        this.sdkGuid = string;
    }

    void setTokenType(String string) {
        this.tokenType = string;
    }
}
