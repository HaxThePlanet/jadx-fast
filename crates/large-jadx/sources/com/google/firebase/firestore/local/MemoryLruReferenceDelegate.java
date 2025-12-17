package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class MemoryLruReferenceDelegate implements com.google.firebase.firestore.local.ReferenceDelegate, com.google.firebase.firestore.local.LruDelegate {

    private long currentSequenceNumber = -1;
    private final com.google.firebase.firestore.local.LruGarbageCollector garbageCollector;
    private com.google.firebase.firestore.local.ReferenceSet inMemoryPins;
    private final ListenSequence listenSequence;
    private final Map<DocumentKey, Long> orphanedSequenceNumbers;
    private final com.google.firebase.firestore.local.MemoryPersistence persistence;
    private final com.google.firebase.firestore.local.LocalSerializer serializer;
    MemoryLruReferenceDelegate(com.google.firebase.firestore.local.MemoryPersistence memoryPersistence, com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params2, com.google.firebase.firestore.local.LocalSerializer localSerializer3) {
        super();
        this.persistence = memoryPersistence;
        this.serializer = localSerializer3;
        HashMap obj5 = new HashMap();
        this.orphanedSequenceNumbers = obj5;
        obj5 = new ListenSequence(memoryPersistence.getTargetCache().getHighestListenSequenceNumber(), obj1);
        this.listenSequence = obj5;
        int i = -1;
        LruGarbageCollector obj3 = new LruGarbageCollector(this, params2);
        this.garbageCollector = obj3;
    }

    static void a(long[] lArr, Long long2) {
        final int obj5 = 0;
        lArr[obj5] = l += i2;
    }

    private boolean isPinned(DocumentKey documentKey, long l2) {
        int i;
        long longValue;
        int obj5;
        i = 1;
        if (mutationQueuesContainsKey(documentKey)) {
            return i;
        }
        if (this.inMemoryPins.containsKey(documentKey)) {
            return i;
        }
        if (this.persistence.getTargetCache().containsKey(documentKey)) {
            return i;
        }
        obj5 = this.orphanedSequenceNumbers.get(documentKey);
        if (obj5 != null && Long.compare(longValue, l2) > 0) {
            if (Long.compare(longValue, l2) > 0) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean mutationQueuesContainsKey(DocumentKey documentKey) {
        boolean key;
        Iterator iterator = this.persistence.getMutationQueues().iterator();
        for (MemoryMutationQueue next2 : iterator) {
        }
        return 0;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        Object value;
        boolean pinned;
        long longValue;
        Iterator iterator = this.orphanedSequenceNumbers.entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if (!isPinned((DocumentKey)(Map.Entry)value.getKey(), (Long)value.getValue().longValue())) {
            }
            consumer.accept((Long)value.getValue());
        }
    }

    public void forEachTarget(Consumer<com.google.firebase.firestore.local.TargetData> consumer) {
        this.persistence.getTargetCache().forEachTarget(consumer);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getByteSize() {
        int i;
        com.google.firebase.firestore.local.LocalSerializer byteSize;
        com.google.firebase.firestore.local.LocalSerializer serializer;
        i2 += byteSize3;
        Iterator iterator = this.persistence.getMutationQueues().iterator();
        for (MemoryMutationQueue next2 : iterator) {
            i += byteSize;
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        int i;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) != 0 ? 1 : i2;
        Assert.hardAssert(i, "Attempting to get a sequence number outside of a transaction", new Object[i2]);
        return this.currentSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public com.google.firebase.firestore.local.LruGarbageCollector getGarbageCollector() {
        return this.garbageCollector;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getSequenceNumberCount() {
        long[] lArr = new long[1];
        y yVar = new y(lArr);
        forEachOrphanedDocumentSequenceNumber(yVar);
        return targetCount += l;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        int i;
        final int i3 = -1;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) != 0 ? 1 : i2;
        Assert.hardAssert(i, "Committing a transaction without having started one", new Object[i2]);
        this.currentSequenceNumber = i3;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        int i;
        int i2 = 0;
        i = Long.compare(currentSequenceNumber, i3) == 0 ? 1 : i2;
        Assert.hardAssert(i, "Starting a transaction without committing the previous one", new Object[i2]);
        this.currentSequenceNumber = this.listenSequence.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public int removeOrphanedDocuments(long l) {
        int i;
        DocumentKey key;
        boolean orphanedSequenceNumbers;
        com.google.firebase.firestore.local.MemoryRemoteDocumentCache remoteDocumentCache = this.persistence.getRemoteDocumentCache();
        Iterator iterator = remoteDocumentCache.getDocuments().iterator();
        i = 0;
        while (iterator.hasNext()) {
            key = (MutableDocument)iterator.next().getKey();
            if (!isPinned(key, l)) {
            }
            remoteDocumentCache.remove(key);
            this.orphanedSequenceNumbers.remove(key);
            i++;
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(com.google.firebase.firestore.local.TargetData targetData) {
        this.persistence.getTargetCache().updateTargetData(targetData.withSequenceNumber(getCurrentSequenceNumber()));
    }

    public int removeTargets(long l, SparseArray<?> sparseArray2) {
        return this.persistence.getTargetCache().removeQueries(l, sparseArray2);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(com.google.firebase.firestore.local.ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }
}
