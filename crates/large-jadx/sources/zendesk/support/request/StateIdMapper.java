package zendesk.support.request;

import f.g.e.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class StateIdMapper implements Serializable {

    private final Map<Long, Long> localToRemote;
    private final Map<Long, Long> remoteToLocal;
    StateIdMapper() {
        super();
        HashMap hashMap = new HashMap();
        this.localToRemote = hashMap;
        HashMap hashMap2 = new HashMap();
        this.remoteToLocal = hashMap2;
    }

    private StateIdMapper(Map<Long, Long> map, Map<Long, Long> map2) {
        super();
        this.remoteToLocal = map;
        this.localToRemote = map2;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateIdMapper addIdMapping(Long long, Long long2) {
        this.remoteToLocal.put(long, long2);
        this.localToRemote.put(long2, long);
        return copy();
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateIdMapper copy() {
        StateIdMapper stateIdMapper = new StateIdMapper(a.d(this.remoteToLocal), a.d(this.localToRemote));
        return stateIdMapper;
    }

    @Override // java.io.Serializable
    Long getLocalId(Long long) {
        return (Long)this.remoteToLocal.get(long);
    }

    @Override // java.io.Serializable
    Long getRemoteId(Long long) {
        return (Long)this.localToRemote.get(long);
    }

    Set<Long> getRemoteIds() {
        return this.remoteToLocal.keySet();
    }

    @Override // java.io.Serializable
    boolean hasLocalId(Long long) {
        boolean localToRemote;
        Object obj2;
        if (this.remoteToLocal.containsKey(long) && this.localToRemote.containsValue(long)) {
            obj2 = this.localToRemote.containsValue(long) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.io.Serializable
    boolean hasRemoteId(Long long) {
        boolean remoteToLocal;
        Object obj2;
        if (this.localToRemote.containsKey(long) && this.remoteToLocal.containsValue(long)) {
            obj2 = this.remoteToLocal.containsValue(long) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IdMapper{ remoteToLocal=");
        stringBuilder.append(this.remoteToLocal);
        stringBuilder.append(" localToRemote=");
        stringBuilder.append(this.localToRemote);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
