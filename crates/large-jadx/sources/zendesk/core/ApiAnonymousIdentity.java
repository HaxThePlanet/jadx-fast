package zendesk.core;

import f.g.c.a;
import f.g.e.g;

/* loaded from: classes3.dex */
class ApiAnonymousIdentity implements zendesk.core.Identity {

    private static final transient String LOG_TAG = "ApiAnonymousIdentity";
    private String email;
    private String name;
    private String sdkGuid;
    ApiAnonymousIdentity(zendesk.core.AnonymousIdentity anonymousIdentity, String string2) {
        String str;
        String obj4;
        Object[] obj5;
        super();
        final int i = 0;
        final String str2 = "ApiAnonymousIdentity";
        if (g.e(string2)) {
            this.sdkGuid = "";
            a.k(str2, "SdkGuid cannot be null or empty.", new Object[i]);
        } else {
            this.sdkGuid = string2;
        }
        if (anonymousIdentity == null) {
            a.k(str2, "Identity is null.", new Object[i]);
        } else {
            this.email = anonymousIdentity.getEmail();
            this.name = anonymousIdentity.getName();
        }
    }
}
