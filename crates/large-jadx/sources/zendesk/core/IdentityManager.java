package zendesk.core;

/* loaded from: classes3.dex */
interface IdentityManager {
    public abstract String getBlipsUuid();

    public abstract zendesk.core.Identity getIdentity();

    public abstract String getSdkGuid();

    public abstract String getStoredAccessTokenAsBearerToken();

    public abstract Long getUserId();

    public abstract boolean identityIsDifferent(zendesk.core.Identity identity);

    public abstract void storeAccessToken(zendesk.core.AccessToken accessToken);

    public abstract zendesk.core.Identity updateAndPersistIdentity(zendesk.core.Identity identity);
}
