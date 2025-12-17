package zendesk.core;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public enum AuthenticationType {

    JWT("jwt"),
    ANONYMOUS("anonymous");

    private final String authenticationType;
    static zendesk.core.AuthenticationType getAuthType(String string) {
        zendesk.core.AuthenticationType jWT = AuthenticationType.JWT;
        if (jWT.authenticationType.equals(string)) {
            return jWT;
        }
        zendesk.core.AuthenticationType aNONYMOUS = AuthenticationType.ANONYMOUS;
        if (aNONYMOUS.authenticationType.equals(string)) {
            return aNONYMOUS;
        }
        return null;
    }

    @Override // java.lang.Enum
    String getAuthenticationType() {
        return this.authenticationType;
    }
}
