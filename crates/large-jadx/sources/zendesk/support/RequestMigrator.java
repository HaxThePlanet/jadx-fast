package zendesk.support;

import java.util.List;

/* loaded from: classes3.dex */
interface RequestMigrator {
    public abstract void clearLegacyRequestStorage();

    public abstract List<zendesk.support.RequestData> getLegacyRequests();
}
