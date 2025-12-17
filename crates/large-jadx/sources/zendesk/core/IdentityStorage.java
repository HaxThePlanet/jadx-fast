package zendesk.core;

/* loaded from: classes3.dex */
interface IdentityStorage {
    public abstract void clear();

    public abstract String getBlipsUuid();

    public abstract zendesk.core.Identity getIdentity();

    public abstract zendesk.core.AccessToken getStoredAccessToken();

    public abstract Long getUserId();

    public abstract String getUuid();

    public abstract void storeAccessToken(zendesk.core.AccessToken accessToken);

    public abstract void storeIdentity(zendesk.core.Identity identity);

    public abstract void storeSdkGuid(String string);

    public abstract void storeUserId(Long long);

    public abstract String updateBlipsUuid();

    public abstract String updateSdkGuid();
}
