package zendesk.core;

import java.io.File;

/* loaded from: classes3.dex */
public interface SessionStorage {
    public abstract void clear();

    public abstract zendesk.core.BaseStorage getAdditionalSdkStorage();

    public abstract File getZendeskCacheDir();

    public abstract File getZendeskDataDir();
}
