package zendesk.core;

/* loaded from: classes3.dex */
public class ApplicationConfiguration {

    private String applicationId;
    private String oauthClientId;
    private String zendeskUrl;
    public ApplicationConfiguration(String string, String string2, String string3) {
        super();
        this.applicationId = string;
        this.zendeskUrl = string2;
        this.oauthClientId = string3;
    }

    public boolean equals(Object object) {
        int equals;
        boolean applicationId;
        boolean zendeskUrl;
        Class class;
        Object applicationId2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                String applicationId3 = this.applicationId;
                if (applicationId3 != null) {
                    if (!applicationId3.equals(object.applicationId)) {
                        return i;
                    }
                } else {
                    if (object.applicationId != null) {
                    }
                }
                String zendeskUrl2 = this.zendeskUrl;
                if (zendeskUrl2 != null) {
                    if (!zendeskUrl2.equals(object.zendeskUrl)) {
                        return i;
                    }
                } else {
                    if (object.zendeskUrl != null) {
                    }
                }
                String oauthClientId = this.oauthClientId;
                final String obj5 = object.oauthClientId;
                if (oauthClientId != null) {
                    equals = oauthClientId.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getOauthClientId() {
        return this.oauthClientId;
    }

    public String getZendeskUrl() {
        return this.zendeskUrl;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i;
        String applicationId = this.applicationId;
        i3 = 0;
        if (applicationId != null) {
            i2 = applicationId.hashCode();
        } else {
            i2 = i3;
        }
        String zendeskUrl = this.zendeskUrl;
        if (zendeskUrl != null) {
            i = zendeskUrl.hashCode();
        } else {
            i = i3;
        }
        String oauthClientId = this.oauthClientId;
        if (oauthClientId != null) {
            i3 = oauthClientId.hashCode();
        }
        return i6 += i3;
    }
}
