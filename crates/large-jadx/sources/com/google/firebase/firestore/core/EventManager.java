package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import io.grpc.d1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class EventManager implements com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback {

    private com.google.firebase.firestore.core.OnlineState onlineState;
    private final Map<com.google.firebase.firestore.core.Query, com.google.firebase.firestore.core.EventManager.QueryListenersInfo> queries;
    private final Set<EventListener<Void>> snapshotsInSyncListeners;
    private final com.google.firebase.firestore.core.SyncEngine syncEngine;

    public static class ListenOptions {

        public boolean includeDocumentMetadataChanges;
        public boolean includeQueryMetadataChanges;
        public boolean waitForSyncWhenOnline;
    }

    private static class QueryListenersInfo {

        private final List<com.google.firebase.firestore.core.QueryListener> listeners;
        private int targetId;
        private com.google.firebase.firestore.core.ViewSnapshot viewSnapshot;
        QueryListenersInfo() {
            super();
            ArrayList arrayList = new ArrayList();
            this.listeners = arrayList;
        }

        static List access$000(com.google.firebase.firestore.core.EventManager.QueryListenersInfo eventManager$QueryListenersInfo) {
            return queryListenersInfo.listeners;
        }

        static com.google.firebase.firestore.core.ViewSnapshot access$100(com.google.firebase.firestore.core.EventManager.QueryListenersInfo eventManager$QueryListenersInfo) {
            return queryListenersInfo.viewSnapshot;
        }

        static com.google.firebase.firestore.core.ViewSnapshot access$102(com.google.firebase.firestore.core.EventManager.QueryListenersInfo eventManager$QueryListenersInfo, com.google.firebase.firestore.core.ViewSnapshot viewSnapshot2) {
            queryListenersInfo.viewSnapshot = viewSnapshot2;
            return viewSnapshot2;
        }

        static int access$200(com.google.firebase.firestore.core.EventManager.QueryListenersInfo eventManager$QueryListenersInfo) {
            return queryListenersInfo.targetId;
        }

        static int access$202(com.google.firebase.firestore.core.EventManager.QueryListenersInfo eventManager$QueryListenersInfo, int i2) {
            queryListenersInfo.targetId = i2;
            return i2;
        }
    }
    public EventManager(com.google.firebase.firestore.core.SyncEngine syncEngine) {
        super();
        HashSet hashSet = new HashSet();
        this.snapshotsInSyncListeners = hashSet;
        this.onlineState = OnlineState.UNKNOWN;
        this.syncEngine = syncEngine;
        HashMap hashMap = new HashMap();
        this.queries = hashMap;
        syncEngine.setCallback(this);
    }

    private void raiseSnapshotsInSyncEvent() {
        Object next;
        int i;
        Iterator iterator = this.snapshotsInSyncListeners.iterator();
        for (EventListener next : iterator) {
            i = 0;
            next.onEvent(i, i);
        }
    }

    @Override // com.google.firebase.firestore.core.SyncEngine$SyncEngineCallback
    public int addQueryListener(com.google.firebase.firestore.core.QueryListener queryListener) {
        Object queryListenersInfo;
        com.google.firebase.firestore.core.ViewSnapshot view;
        int i;
        Map queries;
        Object obj7;
        final com.google.firebase.firestore.core.Query query = queryListener.getQuery();
        int i2 = 1;
        int i4 = 0;
        i = (EventManager.QueryListenersInfo)this.queries.get(query) == null ? i2 : i4;
        if (i != 0) {
            queryListenersInfo = new EventManager.QueryListenersInfo();
            this.queries.put(query, queryListenersInfo);
        }
        EventManager.QueryListenersInfo.access$000(queryListenersInfo).add(queryListener);
        Assert.hardAssert(i2 ^= onOnlineStateChanged, "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[i4]);
        if (EventManager.QueryListenersInfo.access$100(queryListenersInfo) != null && queryListener.onViewSnapshot(EventManager.QueryListenersInfo.access$100(queryListenersInfo))) {
            if (queryListener.onViewSnapshot(EventManager.QueryListenersInfo.access$100(queryListenersInfo))) {
                raiseSnapshotsInSyncEvent();
            }
        }
        if (i != 0) {
            EventManager.QueryListenersInfo.access$202(queryListenersInfo, this.syncEngine.listen(query));
        }
        return EventManager.QueryListenersInfo.access$200(queryListenersInfo);
    }

    public void addSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.snapshotsInSyncListeners.add(eventListener);
        int i = 0;
        eventListener.onEvent(i, i);
    }

    @Override // com.google.firebase.firestore.core.SyncEngine$SyncEngineCallback
    public void handleOnlineStateChange(com.google.firebase.firestore.core.OnlineState onlineState) {
        int i;
        Iterator iterator;
        boolean onOnlineStateChanged;
        this.onlineState = onlineState;
        Iterator iterator2 = this.queries.values().iterator();
        i = 0;
        for (EventManager.QueryListenersInfo next2 : iterator2) {
            iterator = EventManager.QueryListenersInfo.access$000(next2).iterator();
            while (iterator.hasNext()) {
                if ((QueryListener)iterator.next().onOnlineStateChanged(onlineState)) {
                }
                i = 1;
            }
            if ((QueryListener)iterator.next().onOnlineStateChanged(onlineState)) {
            }
            i = 1;
        }
        if (i != 0) {
            raiseSnapshotsInSyncEvent();
        }
    }

    @Override // com.google.firebase.firestore.core.SyncEngine$SyncEngineCallback
    public void onError(com.google.firebase.firestore.core.Query query, d1 d12) {
        Object iterator;
        Object next;
        com.google.firebase.firestore.FirebaseFirestoreException exceptionFromStatus;
        iterator = this.queries.get(query);
        if ((EventManager.QueryListenersInfo)iterator != null) {
            iterator = EventManager.QueryListenersInfo.access$000((EventManager.QueryListenersInfo)iterator).iterator();
            for (QueryListener next : iterator) {
                next.onError(Util.exceptionFromStatus(d12));
            }
        }
        this.queries.remove(query);
    }

    public void onViewSnapshots(List<com.google.firebase.firestore.core.ViewSnapshot> list) {
        int i;
        Object next;
        Object obj;
        Object iterator;
        boolean onViewSnapshot;
        final Iterator obj6 = list.iterator();
        i = 0;
        while (obj6.hasNext()) {
            next = obj6.next();
            obj = this.queries.get((ViewSnapshot)next.getQuery());
            if ((EventManager.QueryListenersInfo)obj != null) {
            }
            iterator = EventManager.QueryListenersInfo.access$000((EventManager.QueryListenersInfo)obj).iterator();
            while (iterator.hasNext()) {
                if ((QueryListener)iterator.next().onViewSnapshot(next)) {
                }
                i = 1;
            }
            EventManager.QueryListenersInfo.access$102(obj, next);
            if ((QueryListener)iterator.next().onViewSnapshot(next)) {
            }
            i = 1;
        }
        if (i != 0) {
            raiseSnapshotsInSyncEvent();
        }
    }

    @Override // com.google.firebase.firestore.core.SyncEngine$SyncEngineCallback
    public void removeQueryListener(com.google.firebase.firestore.core.QueryListener queryListener) {
        List list;
        boolean obj4;
        final com.google.firebase.firestore.core.Query query = queryListener.getQuery();
        Object obj = this.queries.get(query);
        if ((EventManager.QueryListenersInfo)obj != null) {
            EventManager.QueryListenersInfo.access$000((EventManager.QueryListenersInfo)obj).remove(queryListener);
            obj4 = EventManager.QueryListenersInfo.access$000(obj).isEmpty();
        } else {
            obj4 = 0;
        }
        if (obj4 != null) {
            this.queries.remove(query);
            this.syncEngine.stopListening(query);
        }
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.snapshotsInSyncListeners.remove(eventListener);
    }
}
