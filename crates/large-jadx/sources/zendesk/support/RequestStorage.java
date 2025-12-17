package zendesk.support;

import java.util.List;

/* loaded from: classes3.dex */
interface RequestStorage {
    public abstract List<zendesk.support.RequestData> getRequestData();

    public abstract boolean isRequestDataExpired();

    public abstract void markRequestAsRead(String string, int i2);

    public abstract void markRequestAsUnread(String string);

    public abstract void storeRequestData(List<zendesk.support.RequestData> list);

    public abstract void updateRequestData(List<zendesk.support.Request> list);
}
