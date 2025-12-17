package zendesk.core;

import f.g.c.a;
import f.g.e.g;
import java.util.Locale;

/* loaded from: classes3.dex */
class ZendeskIdentityManager implements zendesk.core.IdentityManager {

    private static final String LOG_TAG = "ZendeskIdentityManager";
    private final zendesk.core.IdentityStorage identityStorage;
    ZendeskIdentityManager(zendesk.core.IdentityStorage identityStorage) {
        super();
        this.identityStorage = identityStorage;
    }

    @Override // zendesk.core.IdentityManager
    public String getBlipsUuid() {
        String blipsUuid;
        if (g.e(this.identityStorage.getBlipsUuid()) != null) {
            blipsUuid = this.identityStorage.updateBlipsUuid();
        }
        return blipsUuid;
    }

    @Override // zendesk.core.IdentityManager
    public zendesk.core.Identity getIdentity() {
        boolean sdkGuid;
        zendesk.core.Identity identity = this.identityStorage.getIdentity();
        if (identity instanceof AnonymousIdentity) {
            (AnonymousIdentity)identity.setSdkGuid(getSdkGuid());
        }
        return identity;
    }

    @Override // zendesk.core.IdentityManager
    public String getSdkGuid() {
        String sdkGuid;
        if (g.e(this.identityStorage.getUuid()) != null) {
            sdkGuid = this.identityStorage.updateSdkGuid();
        }
        return sdkGuid;
    }

    @Override // zendesk.core.IdentityManager
    public String getStoredAccessTokenAsBearerToken() {
        zendesk.core.AccessToken storedAccessToken = this.identityStorage.getStoredAccessToken();
        int i2 = 0;
        if (storedAccessToken != null) {
            Object[] arr2 = new Object[1];
            arr2[i2] = storedAccessToken.getAccessToken();
            return String.format(Locale.US, "Bearer %s", arr2);
        }
        a.k("ZendeskIdentityManager", "There is no stored access token, have you initialised an identity and requested an access token?", new Object[i2]);
        return null;
    }

    @Override // zendesk.core.IdentityManager
    public Long getUserId() {
        return this.identityStorage.getUserId();
    }

    @Override // zendesk.core.IdentityManager
    public boolean identityIsDifferent(zendesk.core.Identity identity) {
        Object obj2;
        zendesk.core.Identity identity2 = this.identityStorage.getIdentity();
        if (identity2 != null && identity != null) {
            if (identity != null) {
                if (!identity2.equals(identity)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // zendesk.core.IdentityManager
    public void storeAccessToken(zendesk.core.AccessToken accessToken) {
        Object identityStorage;
        zendesk.core.IdentityStorage identityStorage2;
        String str;
        Object[] obj5;
        int i = 0;
        final String str3 = "ZendeskIdentityManager";
        if (accessToken == null) {
            a.k(str3, "Access Token object was null, cannot store.", new Object[i]);
        }
        if (!g.e(accessToken.getAccessToken())) {
            this.identityStorage.storeAccessToken(accessToken);
        } else {
            a.k(str3, "Access token String was null or empty, cannot store.", new Object[i]);
        }
        obj5 = accessToken.getUserId();
        if (g.f(obj5)) {
            this.identityStorage.storeUserId(Long.valueOf(obj5));
        } else {
            a.k(str3, "User ID String was null or empty, cannot store.", new Object[i]);
        }
    }

    @Override // zendesk.core.IdentityManager
    public zendesk.core.Identity updateAndPersistIdentity(zendesk.core.Identity identity) {
        boolean identityIsDifferent;
        zendesk.core.Identity identity2 = this.identityStorage.getIdentity();
        int i = 0;
        final String str3 = "ZendeskIdentityManager";
        if (identity2 == null) {
            a.b(str3, "No previous identity set, storing identity", new Object[i]);
            this.identityStorage.storeIdentity(identity);
            return identity;
        }
        if (identity != null && identityIsDifferent(identity)) {
            if (identityIsDifferent(identity)) {
                a.b(str3, "Identity has changed, storing new identity", new Object[i]);
                this.identityStorage.storeIdentity(identity);
                return identity;
            }
        }
        return identity2;
    }
}
