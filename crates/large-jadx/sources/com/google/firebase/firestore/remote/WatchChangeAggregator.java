package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange.Type;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class WatchChangeAggregator {

    private Map<DocumentKey, Set<Integer>> pendingDocumentTargetMapping;
    private Map<DocumentKey, MutableDocument> pendingDocumentUpdates;
    private Set<Integer> pendingTargetResets;
    private final com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider targetMetadataProvider;
    private final Map<Integer, com.google.firebase.firestore.remote.TargetState> targetStates;

    public interface TargetMetadataProvider {
        public abstract ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);

        public abstract TargetData getTargetDataForTarget(int i);
    }
    public WatchChangeAggregator(com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider watchChangeAggregator$TargetMetadataProvider) {
        super();
        HashMap hashMap = new HashMap();
        this.targetStates = hashMap;
        HashMap hashMap2 = new HashMap();
        this.pendingDocumentUpdates = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.pendingDocumentTargetMapping = hashMap3;
        HashSet hashSet = new HashSet();
        this.pendingTargetResets = hashSet;
        this.targetMetadataProvider = targetMetadataProvider;
    }

    private void addDocumentToTarget(int i, MutableDocument mutableDocument2) {
        DocumentViewChange.Type mODIFIED;
        if (!isActiveTarget(i)) {
        }
        mODIFIED = targetContainsDocument(i, mutableDocument2.getKey()) ? DocumentViewChange.Type.MODIFIED : DocumentViewChange.Type.ADDED;
        ensureTargetState(i).addDocumentChange(mutableDocument2.getKey(), mODIFIED);
        this.pendingDocumentUpdates.put(mutableDocument2.getKey(), mutableDocument2);
        ensureDocumentTargetMapping(mutableDocument2.getKey()).add(Integer.valueOf(i));
    }

    private Set<Integer> ensureDocumentTargetMapping(DocumentKey documentKey) {
        Object hashSet;
        Map pendingDocumentTargetMapping;
        if ((Set)this.pendingDocumentTargetMapping.get(documentKey) == null) {
            hashSet = new HashSet();
            this.pendingDocumentTargetMapping.put(documentKey, hashSet);
        }
        return hashSet;
    }

    private com.google.firebase.firestore.remote.TargetState ensureTargetState(int i) {
        Object targetState;
        Object targetStates;
        int obj3;
        if ((TargetState)this.targetStates.get(Integer.valueOf(i)) == null) {
            targetState = new TargetState();
            this.targetStates.put(Integer.valueOf(i), targetState);
        }
        return targetState;
    }

    private int getCurrentDocumentCountForTarget(int i) {
        com.google.firebase.firestore.remote.TargetChange targetChange = ensureTargetState(i).toTargetChange();
        return obj3 -= size;
    }

    private Collection<Integer> getTargetIds(com.google.firebase.firestore.remote.WatchChange.WatchTargetChange watchChange$WatchTargetChange) {
        Object next;
        boolean activeTarget;
        List obj4 = watchTargetChange.getTargetIds();
        if (!obj4.isEmpty()) {
            return obj4;
        }
        obj4 = new ArrayList();
        Iterator iterator = this.targetStates.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (isActiveTarget((Integer)next.intValue())) {
            }
            obj4.add(next);
        }
        return obj4;
    }

    private boolean isActiveTarget(int i) {
        int obj1;
        obj1 = queryDataForActiveTarget(i) != null ? 1 : 0;
        return obj1;
    }

    private TargetData queryDataForActiveTarget(int i) {
        Object targetMetadataProvider;
        TargetData obj3;
        targetMetadataProvider = this.targetStates.get(Integer.valueOf(i));
        if (targetMetadataProvider != null && (TargetState)targetMetadataProvider.isPending()) {
            if (targetMetadataProvider.isPending()) {
                obj3 = 0;
            } else {
                obj3 = this.targetMetadataProvider.getTargetDataForTarget(i);
            }
        } else {
        }
        return obj3;
    }

    private void removeDocumentFromTarget(int i, DocumentKey documentKey2, MutableDocument mutableDocument3) {
        DocumentViewChange.Type targetContainsDocument;
        Object obj3;
        if (!isActiveTarget(i)) {
        }
        com.google.firebase.firestore.remote.TargetState ensureTargetState = ensureTargetState(i);
        if (targetContainsDocument(i, documentKey2)) {
            ensureTargetState.addDocumentChange(documentKey2, DocumentViewChange.Type.REMOVED);
        } else {
            ensureTargetState.removeDocumentChange(documentKey2);
        }
        ensureDocumentTargetMapping(documentKey2).add(Integer.valueOf(i));
        if (mutableDocument3 != null) {
            this.pendingDocumentUpdates.put(documentKey2, mutableDocument3);
        }
    }

    private void resetTarget(int i) {
        Object pending;
        int i2;
        Integer valueOf2;
        Integer valueOf;
        com.google.firebase.firestore.remote.TargetState targetState;
        int i3 = 0;
        if (this.targetStates.get(Integer.valueOf(i)) != null && !(TargetState)this.targetStates.get(Integer.valueOf(i)).isPending()) {
            i2 = !(TargetState)this.targetStates.get(Integer.valueOf(i)).isPending() ? 1 : i3;
        } else {
        }
        Assert.hardAssert(i2, "Should only reset active targets", new Object[i3]);
        targetState = new TargetState();
        this.targetStates.put(Integer.valueOf(i), targetState);
        Iterator iterator = this.targetMetadataProvider.getRemoteKeysForTarget(i).iterator();
        for (DocumentKey valueOf2 : iterator) {
            removeDocumentFromTarget(i, valueOf2, null);
        }
    }

    private boolean targetContainsDocument(int i, DocumentKey documentKey2) {
        return this.targetMetadataProvider.getRemoteKeysForTarget(i).contains(documentKey2);
    }

    public com.google.firebase.firestore.remote.RemoteEvent createRemoteEvent(SnapshotVersion snapshotVersion) {
        Object value;
        int intValue;
        TargetData dataForActiveTarget;
        boolean targetContainsDocument;
        boolean dataForActiveTarget2;
        QueryPurpose lIMBO_RESOLUTION;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.targetStates.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            intValue = (Integer)(Map.Entry)next2.getKey().intValue();
            value = next2.getValue();
            dataForActiveTarget = queryDataForActiveTarget(intValue);
            dataForActiveTarget = DocumentKey.fromPath(dataForActiveTarget.getTarget().getPath());
            if (dataForActiveTarget != null && (TargetState)value.isCurrent() && dataForActiveTarget.getTarget().isDocumentQuery() && this.pendingDocumentUpdates.get(dataForActiveTarget) == null && !targetContainsDocument(intValue, dataForActiveTarget)) {
            }
            if (value.isCurrent()) {
            }
            if (value.hasChanges()) {
            }
            hashMap.put(Integer.valueOf(intValue), value.toTargetChange());
            value.clearChanges();
            if (dataForActiveTarget.getTarget().isDocumentQuery()) {
            }
            dataForActiveTarget = DocumentKey.fromPath(dataForActiveTarget.getTarget().getPath());
            if (this.pendingDocumentUpdates.get(dataForActiveTarget) == null) {
            }
            if (!targetContainsDocument(intValue, dataForActiveTarget)) {
            }
            removeDocumentFromTarget(intValue, dataForActiveTarget, MutableDocument.newNoDocument(dataForActiveTarget, snapshotVersion));
        }
        HashSet hashSet = new HashSet();
        Iterator iterator2 = this.pendingDocumentTargetMapping.entrySet().iterator();
        for (Map.Entry next4 : iterator2) {
            targetContainsDocument = 1;
            intValue = (Set)next4.getValue().iterator();
            while (intValue.hasNext()) {
                dataForActiveTarget2 = queryDataForActiveTarget((Integer)intValue.next().intValue());
                if (dataForActiveTarget2 != null) {
                    break loop_13;
                } else {
                }
                if (!dataForActiveTarget2.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
                    break loop_13;
                } else {
                }
            }
            if (targetContainsDocument != 0) {
            }
            hashSet.add((DocumentKey)next4.getKey());
            dataForActiveTarget2 = queryDataForActiveTarget((Integer)intValue.next().intValue());
            if (dataForActiveTarget2 != null) {
            } else {
            }
            if (!dataForActiveTarget2.getPurpose().equals(QueryPurpose.LIMBO_RESOLUTION)) {
            } else {
            }
            targetContainsDocument = 0;
        }
        super(snapshotVersion, Collections.unmodifiableMap(hashMap), Collections.unmodifiableSet(this.pendingTargetResets), Collections.unmodifiableMap(this.pendingDocumentUpdates), Collections.unmodifiableSet(hashSet));
        HashMap obj13 = new HashMap();
        this.pendingDocumentUpdates = obj13;
        obj13 = new HashMap();
        this.pendingDocumentTargetMapping = obj13;
        obj13 = new HashSet();
        this.pendingTargetResets = obj13;
        return remoteEvent;
    }

    public void handleDocumentChange(com.google.firebase.firestore.remote.WatchChange.DocumentChange watchChange$DocumentChange) {
        Iterator intValue;
        int intValue2;
        boolean newDocument;
        boolean foundDocument;
        MutableDocument newDocument2 = documentChange.getNewDocument();
        final DocumentKey documentKey = documentChange.getDocumentKey();
        intValue = documentChange.getUpdatedTargetIds().iterator();
        while (intValue.hasNext()) {
            intValue2 = (Integer)intValue.next().intValue();
            if (newDocument2 != null && newDocument2.isFoundDocument()) {
            } else {
            }
            removeDocumentFromTarget(intValue2, documentKey, newDocument2);
            if (newDocument2.isFoundDocument()) {
            } else {
            }
            addDocumentToTarget(intValue2, newDocument2);
        }
        Iterator iterator = documentChange.getRemovedTargetIds().iterator();
        for (Integer next2 : iterator) {
            removeDocumentFromTarget(next2.intValue(), documentKey, documentChange.getNewDocument());
        }
    }

    public void handleExistenceFilter(com.google.firebase.firestore.remote.WatchChange.ExistenceFilterWatchChange watchChange$ExistenceFilterWatchChange) {
        int targetId;
        TargetData dataForActiveTarget;
        boolean documentQuery;
        long l;
        int obj6;
        targetId = existenceFilterWatchChange.getTargetId();
        obj6 = existenceFilterWatchChange.getExistenceFilter().getCount();
        dataForActiveTarget = queryDataForActiveTarget(targetId);
        if (dataForActiveTarget != null) {
            Target target = dataForActiveTarget.getTarget();
            if (target.isDocumentQuery()) {
                if (obj6 == null) {
                    obj6 = DocumentKey.fromPath(target.getPath());
                    removeDocumentFromTarget(targetId, obj6, MutableDocument.newNoDocument(obj6, SnapshotVersion.NONE));
                } else {
                    targetId = 0;
                    int i = 1;
                    documentQuery = obj6 == i ? i : targetId;
                    dataForActiveTarget = new Object[i];
                    dataForActiveTarget[targetId] = Integer.valueOf(obj6);
                    Assert.hardAssert(documentQuery, "Single document existence filter with count: %d", dataForActiveTarget);
                }
            } else {
                if (Long.compare(dataForActiveTarget, l) != 0) {
                    resetTarget(targetId);
                    this.pendingTargetResets.add(Integer.valueOf(targetId));
                }
            }
        }
    }

    public void handleTargetChange(com.google.firebase.firestore.remote.WatchChange.WatchTargetChange watchChange$WatchTargetChange) {
        Object[] activeTarget2;
        Object ensureTargetState;
        int activeTarget;
        int i;
        int i3;
        int i2;
        Iterator iterator = getTargetIds(watchTargetChange).iterator();
        for (Integer next2 : iterator) {
            activeTarget2 = next2.intValue();
            ensureTargetState = ensureTargetState(activeTarget2);
            activeTarget = WatchChangeAggregator.1.$SwitchMap$com$google$firebase$firestore$remote$WatchChange$WatchTargetChangeType[watchTargetChange.getChangeType().ordinal()];
            i = 1;
            if (isActiveTarget(activeTarget2)) {
            }
            ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
            ensureTargetState.recordTargetResponse();
            if (!ensureTargetState.isPending()) {
            }
            ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
            ensureTargetState.clearChanges();
            i2 = 0;
            ensureTargetState.recordTargetResponse();
            if (!ensureTargetState.isPending()) {
            }
            if (watchTargetChange.getCause() == null) {
            } else {
            }
            i = i2;
            Assert.hardAssert(i, "WatchChangeAggregator does not handle errored targets", new Object[i2]);
            removeTarget(activeTarget2);
            if (isActiveTarget(activeTarget2)) {
            }
            ensureTargetState.markCurrent();
            ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
            if (isActiveTarget(activeTarget2)) {
            }
            resetTarget(activeTarget2);
            ensureTargetState.updateResumeToken(watchTargetChange.getResumeToken());
        }
    }

    void recordPendingTargetRequest(int i) {
        ensureTargetState(i).recordPendingTargetRequest();
    }

    void removeTarget(int i) {
        this.targetStates.remove(Integer.valueOf(i));
    }
}
