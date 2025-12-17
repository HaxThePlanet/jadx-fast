package zendesk.core;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes3.dex */
class SdkSettings implements Serializable {

    private String authentication;
    private Date updatedAt;
    @Override // java.io.Serializable
    zendesk.core.AuthenticationType getAuthentication() {
        return AuthenticationType.getAuthType(this.authentication);
    }

    @Override // java.io.Serializable
    Date getUpdatedAt() {
        int date;
        long time;
        if (this.updatedAt == null) {
            date = 0;
        } else {
            date = new Date(this.updatedAt.getTime(), obj2);
        }
        return date;
    }
}
