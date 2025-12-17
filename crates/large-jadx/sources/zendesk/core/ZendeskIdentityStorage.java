package zendesk.core;

import f.g.c.a;
import f.g.e.g;
import java.util.UUID;

/* loaded from: classes3.dex */
class ZendeskIdentityStorage implements zendesk.core.IdentityStorage {

    static final String BLIPS_UUID_KEY = "blips_buid";
    static final String IDENTITY_KEY = "zendesk-identity";
    static final String IDENTITY_TYPE_KEY = "zendesk-identity-type";
    static final String LOG_TAG = "ZendeskIdentityStorage";
    static final String TOKEN_KEY = "stored_token";
    static final String USER_ID_KEY = "user_id";
    static final String UUID_KEY = "uuid";
    private final zendesk.core.BaseStorage identityStorage;
    ZendeskIdentityStorage(zendesk.core.BaseStorage baseStorage) {
        super();
        this.identityStorage = baseStorage;
    }

    @Override // zendesk.core.IdentityStorage
    public void clear() {
        this.identityStorage.clear();
    }

    @Override // zendesk.core.IdentityStorage
    public String getBlipsUuid() {
        return this.identityStorage.get("blips_buid");
    }

    @Override // zendesk.core.IdentityStorage
    public zendesk.core.Identity getIdentity() {
        String authType;
        int i;
        boolean z;
        String str2;
        int i2;
        String str;
        authType = this.identityStorage.get("zendesk-identity-type");
        authType = AuthenticationType.getAuthType(authType);
        if (g.c(authType) && authType != null) {
            authType = AuthenticationType.getAuthType(authType);
            if (authType != null) {
                authType = ZendeskIdentityStorage.1.$SwitchMap$zendesk$core$AuthenticationType[authType.ordinal()];
                str2 = "zendesk-identity";
                i2 = 0;
                str = "ZendeskIdentityStorage";
                if (authType != 1) {
                    if (authType != 2) {
                        i = 0;
                    } else {
                        a.b(str, "Loading Anonymous identity", new Object[i2]);
                        i = this.identityStorage.get(str2, AnonymousIdentity.class);
                    }
                } else {
                    a.b(str, "Loading Jwt identity", new Object[i2]);
                    i = this.identityStorage.get(str2, JwtIdentity.class);
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // zendesk.core.IdentityStorage
    public zendesk.core.AccessToken getStoredAccessToken() {
        return (AccessToken)this.identityStorage.get("stored_token", AccessToken.class);
    }

    @Override // zendesk.core.IdentityStorage
    public Long getUserId() {
        return (Long)this.identityStorage.get("user_id", Long.class);
    }

    @Override // zendesk.core.IdentityStorage
    public String getUuid() {
        String str;
        a.b("ZendeskIdentityStorage", "Fetching UUID from preferences store", new Object[0]);
        if (g.e(this.identityStorage.get("uuid")) != null) {
            str = "";
        }
        return str;
    }

    @Override // zendesk.core.IdentityStorage
    public void storeAccessToken(zendesk.core.AccessToken accessToken) {
        zendesk.core.BaseStorage identityStorage;
        String str;
        if (accessToken != null) {
            this.identityStorage.put("stored_token", accessToken);
        }
    }

    @Override // zendesk.core.IdentityStorage
    public void storeIdentity(zendesk.core.Identity identity) {
        zendesk.core.AuthenticationType aNONYMOUS;
        String str2;
        String authenticationType;
        boolean str;
        Object obj5;
        int i = 0;
        str2 = "ZendeskIdentityStorage";
        if (identity == null) {
            a.e(str2, "identity is null, will not store the identity", new Object[i]);
        }
        authenticationType = 0;
        if (identity instanceof AnonymousIdentity) {
            a.b(str2, "Storing anonymous identity", new Object[i]);
            authenticationType = AuthenticationType.ANONYMOUS.getAuthenticationType();
        } else {
            if (identity instanceof JwtIdentity) {
                a.b(str2, "Storing jwt identity", new Object[i]);
                authenticationType = AuthenticationType.JWT.getAuthenticationType();
            } else {
                a.e(str2, "Unknown authentication type, identity will not be stored", new Object[i]);
            }
        }
        if (identity != null && authenticationType != null) {
            if (authenticationType != null) {
                this.identityStorage.put("zendesk-identity", identity);
                this.identityStorage.put("zendesk-identity-type", authenticationType);
            }
        }
    }

    @Override // zendesk.core.IdentityStorage
    public void storeSdkGuid(String string) {
        a.b("ZendeskIdentityStorage", "Storing new UUID in preference store", new Object[0]);
        this.identityStorage.put("uuid", string);
    }

    @Override // zendesk.core.IdentityStorage
    public void storeUserId(Long long) {
        zendesk.core.BaseStorage identityStorage;
        String str;
        if (long != null) {
            this.identityStorage.put("user_id", long);
        }
    }

    @Override // zendesk.core.IdentityStorage
    public String updateBlipsUuid() {
        String string = UUID.randomUUID().toString();
        a.b("ZendeskIdentityStorage", "Generate new Blips BUID", new Object[0]);
        this.identityStorage.put("blips_buid", string);
        return string;
    }

    @Override // zendesk.core.IdentityStorage
    public String updateSdkGuid() {
        String string = UUID.randomUUID().toString();
        storeSdkGuid(string);
        return string;
    }
}
