package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryListener {

    private final EventListener<com.google.firebase.firestore.core.ViewSnapshot> listener;
    private com.google.firebase.firestore.core.OnlineState onlineState = null;
    private final com.google.firebase.firestore.core.EventManager.ListenOptions options;
    private final com.google.firebase.firestore.core.Query query;
    private boolean raisedInitialEvent = false;
    private com.google.firebase.firestore.core.ViewSnapshot snapshot;
    public QueryListener(com.google.firebase.firestore.core.Query query, com.google.firebase.firestore.core.EventManager.ListenOptions eventManager$ListenOptions2, EventListener<com.google.firebase.firestore.core.ViewSnapshot> eventListener3) {
        super();
        int i = 0;
        com.google.firebase.firestore.core.OnlineState uNKNOWN = OnlineState.UNKNOWN;
        this.query = query;
        this.listener = eventListener3;
        this.options = listenOptions2;
    }

    private void raiseInitialEvent(com.google.firebase.firestore.core.ViewSnapshot viewSnapshot) {
        int i2 = 1;
        Assert.hardAssert(raisedInitialEvent ^= i2, "Trying to raise initial event for second time", new Object[0]);
        this.raisedInitialEvent = i2;
        this.listener.onEvent(ViewSnapshot.fromInitialDocuments(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getMutatedKeys(), viewSnapshot.isFromCache(), viewSnapshot.excludesMetadataChanges()), 0);
    }

    private boolean shouldRaiseEvent(com.google.firebase.firestore.core.ViewSnapshot viewSnapshot) {
        boolean pendingWrites2;
        int i;
        boolean pendingWrites;
        if (!viewSnapshot.getChanges().isEmpty()) {
            return 1;
        }
        pendingWrites2 = this.snapshot;
        final int i2 = 0;
        if (pendingWrites2 != null && pendingWrites2.hasPendingWrites() != viewSnapshot.hasPendingWrites()) {
            if (pendingWrites2.hasPendingWrites() != viewSnapshot.hasPendingWrites()) {
            } else {
                i = i2;
            }
        } else {
        }
        if (!viewSnapshot.didSyncStateChange() && i != 0) {
            if (i != 0) {
            }
            return i2;
        }
        return obj5.includeQueryMetadataChanges;
    }

    private boolean shouldRaiseInitialEvent(com.google.firebase.firestore.core.ViewSnapshot viewSnapshot, com.google.firebase.firestore.core.OnlineState onlineState2) {
        int i;
        boolean obj6;
        i = 1;
        final int i3 = 0;
        Assert.hardAssert(raisedInitialEvent ^= i, "Determining whether to raise first event but already had first event.", new Object[i3]);
        if (!viewSnapshot.isFromCache()) {
            return i;
        }
        com.google.firebase.firestore.core.OnlineState oFFLINE = OnlineState.OFFLINE;
        if (options.waitForSyncWhenOnline && equals ^= i != 0) {
            if (equals ^= i != 0) {
                Assert.hardAssert(viewSnapshot.isFromCache(), "Waiting for sync, but snapshot is not from cache", new Object[i3]);
                return i3;
            }
        }
        if (viewSnapshot.getDocuments().isEmpty()) {
            if (onlineState2.equals(oFFLINE)) {
            } else {
                i = i3;
            }
        }
        return i;
    }

    public com.google.firebase.firestore.core.Query getQuery() {
        return this.query;
    }

    public void onError(FirebaseFirestoreException firebaseFirestoreException) {
        this.listener.onEvent(0, firebaseFirestoreException);
    }

    public boolean onOnlineStateChanged(com.google.firebase.firestore.core.OnlineState onlineState) {
        boolean raisedInitialEvent;
        int obj3;
        this.onlineState = onlineState;
        final com.google.firebase.firestore.core.ViewSnapshot snapshot = this.snapshot;
        if (snapshot != null && !this.raisedInitialEvent && shouldRaiseInitialEvent(snapshot, onlineState)) {
            if (!this.raisedInitialEvent) {
                if (shouldRaiseInitialEvent(snapshot, onlineState)) {
                    raiseInitialEvent(this.snapshot);
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public boolean onViewSnapshot(com.google.firebase.firestore.core.ViewSnapshot viewSnapshot) {
        boolean didSyncStateChange;
        int i;
        boolean includeDocumentMetadataChanges;
        boolean raiseInitialEvent;
        int i2;
        Object[] next;
        Object query;
        DocumentSet mETADATA;
        DocumentSet oldDocuments;
        ArrayList arrayList;
        boolean fromCache;
        com.google.firebase.database.collection.ImmutableSortedSet mutatedKeys;
        boolean didSyncStateChange2;
        int i3;
        com.google.firebase.firestore.core.ViewSnapshot obj13;
        i2 = 0;
        final int i4 = 1;
        if (viewSnapshot.getChanges().isEmpty()) {
            if (viewSnapshot.didSyncStateChange()) {
                i = i4;
            } else {
                i = i2;
            }
        } else {
        }
        Assert.hardAssert(i, "We got a new snapshot with no changes?", new Object[i2]);
        if (!options.includeDocumentMetadataChanges) {
            arrayList = new ArrayList();
            Iterator iterator = viewSnapshot.getChanges().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((DocumentViewChange)next.getType() != DocumentViewChange.Type.METADATA) {
                }
                arrayList.add(next);
            }
            super(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getOldDocuments(), arrayList, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys(), viewSnapshot.didSyncStateChange(), 1);
            obj13 = includeDocumentMetadataChanges;
        }
        if (!this.raisedInitialEvent) {
            if (shouldRaiseInitialEvent(obj13, this.onlineState)) {
                raiseInitialEvent(obj13);
                i2 = i4;
            }
        } else {
            if (shouldRaiseEvent(obj13)) {
                this.listener.onEvent(obj13, 0);
            }
        }
        this.snapshot = obj13;
        return i2;
    }
}
