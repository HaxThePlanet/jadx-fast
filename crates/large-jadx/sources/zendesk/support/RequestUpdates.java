package zendesk.support;

import f.g.e.a;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RequestUpdates {

    private final Map<String, Integer> requestIds;
    public RequestUpdates(Map<String, Integer> map) {
        Map obj1;
        super();
        if (map == null) {
            this.requestIds = Collections.emptyMap();
        } else {
            this.requestIds = map;
        }
    }

    public Map<String, Integer> getRequestUpdates() {
        return a.d(this.requestIds);
    }

    public boolean hasUpdatedRequests() {
        return empty ^= 1;
    }

    public boolean isRequestUnread(String string) {
        boolean requestIds;
        Object obj2;
        if (this.requestIds.containsKey(string) && (Integer)this.requestIds.get(string).intValue() > 0) {
            obj2 = (Integer)this.requestIds.get(string).intValue() > 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public int totalUpdates() {
        int i;
        int intValue;
        Iterator iterator = this.requestIds.values().iterator();
        i = 0;
        for (Integer next2 : iterator) {
            i += intValue;
        }
        return i;
    }
}
