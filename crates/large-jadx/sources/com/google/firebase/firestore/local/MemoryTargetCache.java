package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class MemoryTargetCache implements com.google.firebase.firestore.local.TargetCache {

    private long highestSequenceNumber = 0;
    private int highestTargetId;
    private SnapshotVersion lastRemoteSnapshotVersion;
    private final com.google.firebase.firestore.local.MemoryPersistence persistence;
    private final com.google.firebase.firestore.local.ReferenceSet references;
    private final Map<Target, com.google.firebase.firestore.local.TargetData> targets;
    MemoryTargetCache(com.google.firebase.firestore.local.MemoryPersistence memoryPersistence) {
        super();
        HashMap hashMap = new HashMap();
        this.targets = hashMap;
        ReferenceSet referenceSet = new ReferenceSet();
        this.references = referenceSet;
        this.lastRemoteSnapshotVersion = SnapshotVersion.NONE;
        int i = 0;
        this.persistence = memoryPersistence;
    }

    public void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        com.google.firebase.firestore.local.ReferenceSet references;
        this.references.addReferences(immutableSortedSet, i2);
        final Iterator obj2 = immutableSortedSet.iterator();
        for (DocumentKey references : obj2) {
            this.persistence.getReferenceDelegate().addReference(references);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void addTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        int sequenceNumber;
        this.targets.put(targetData.getTarget(), targetData);
        int targetId = targetData.getTargetId();
        if (targetId > this.highestTargetId) {
            this.highestTargetId = targetId;
        }
        if (Long.compare(sequenceNumber2, highestSequenceNumber) > 0) {
            this.highestSequenceNumber = targetData.getSequenceNumber();
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public boolean containsKey(DocumentKey documentKey) {
        return this.references.containsKey(documentKey);
    }

    public void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer) {
        Object next;
        Iterator iterator = this.targets.values().iterator();
        for (TargetData next : iterator) {
            consumer.accept(next);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    long getByteSize(com.google.firebase.firestore.local.LocalSerializer localSerializer) {
        int i;
        long l;
        Iterator iterator = this.targets.entrySet().iterator();
        i = 0;
        for (Map.Entry next2 : iterator) {
            i += l;
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getHighestListenSequenceNumber() {
        return this.highestSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public int getHighestTargetId() {
        return this.highestTargetId;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.lastRemoteSnapshotVersion;
    }

    public ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i) {
        return this.references.referencesForId(i);
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public long getTargetCount() {
        return (long)size;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public com.google.firebase.firestore.local.TargetData getTargetData(Target target) {
        return (TargetData)this.targets.get(target);
    }

    public void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i2) {
        com.google.firebase.firestore.local.ReferenceSet references;
        this.references.removeReferences(immutableSortedSet, i2);
        final Iterator obj2 = immutableSortedSet.iterator();
        for (DocumentKey references : obj2) {
            this.persistence.getReferenceDelegate().removeReference(references);
        }
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeMatchingKeysForTargetId(int i) {
        this.references.removeReferencesForId(i);
    }

    int removeQueries(long l, SparseArray<?> sparseArray2) {
        int i;
        int cmp;
        int targetId;
        long sequenceNumber;
        Iterator iterator = this.targets.entrySet().iterator();
        i = 0;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            targetId = (TargetData)(Map.Entry)next2.getValue().getTargetId();
            if (Long.compare(sequenceNumber, l) <= 0 && obj9.get(targetId) == null) {
            }
            if (obj9.get(targetId) == null) {
            }
            iterator.remove();
            removeMatchingKeysForTargetId(targetId);
            i++;
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void removeTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        this.targets.remove(targetData.getTarget());
        this.references.removeReferencesForId(targetData.getTargetId());
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion) {
        this.lastRemoteSnapshotVersion = snapshotVersion;
    }

    @Override // com.google.firebase.firestore.local.TargetCache
    public void updateTargetData(com.google.firebase.firestore.local.TargetData targetData) {
        addTargetData(targetData);
    }
}
