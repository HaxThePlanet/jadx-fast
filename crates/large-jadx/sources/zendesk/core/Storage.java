package zendesk.core;

/* loaded from: classes3.dex */
interface Storage {
    public abstract void clear();

    public abstract zendesk.core.SessionStorage getSessionStorage();

    public abstract boolean hasSdkConfigChanged(zendesk.core.ApplicationConfiguration applicationConfiguration);

    public abstract void storeSdkHash(zendesk.core.ApplicationConfiguration applicationConfiguration);
}
