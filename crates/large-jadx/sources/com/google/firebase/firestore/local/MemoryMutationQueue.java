package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.j;
import com.google.protobuf.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class MemoryMutationQueue implements com.google.firebase.firestore.local.MutationQueue {

    private ImmutableSortedSet<com.google.firebase.firestore.local.DocumentReference> batchesByDocumentKey;
    private j lastStreamToken = 1;
    private int nextBatchId = 1;
    private final com.google.firebase.firestore.local.MemoryPersistence persistence;
    private final List<MutationBatch> queue;
    MemoryMutationQueue(com.google.firebase.firestore.local.MemoryPersistence memoryPersistence) {
        super();
        this.persistence = memoryPersistence;
        ArrayList obj3 = new ArrayList();
        this.queue = obj3;
        obj3 = new ImmutableSortedSet(Collections.emptyList(), DocumentReference.BY_KEY);
        this.batchesByDocumentKey = obj3;
        obj3 = 1;
        obj3 = WriteStream.EMPTY_STREAM_TOKEN;
    }

    private int indexOfBatchId(int i) {
        final int i2 = 0;
        if (this.queue.isEmpty()) {
            return i2;
        }
        return i -= batchId;
    }

    private int indexOfExistingBatchId(int i, String string2) {
        int size;
        int i2;
        final int obj4 = indexOfBatchId(i);
        int i3 = 1;
        final int i4 = 0;
        if (obj4 >= 0 && obj4 < this.queue.size()) {
            i2 = obj4 < this.queue.size() ? i3 : i4;
        } else {
        }
        Object[] arr = new Object[i3];
        arr[i4] = string2;
        Assert.hardAssert(i2, "Batches must exist to be %s", arr);
        return obj4;
    }

    private List<MutationBatch> lookupMutationBatches(ImmutableSortedSet<Integer> immutableSortedSet) {
        MutationBatch mutationBatch;
        ArrayList arrayList = new ArrayList();
        final Iterator obj3 = immutableSortedSet.iterator();
        while (obj3.hasNext()) {
            mutationBatch = lookupMutationBatch((Integer)obj3.next().intValue());
            if (mutationBatch != null) {
            }
            arrayList.add(mutationBatch);
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void acknowledgeBatch(MutationBatch mutationBatch, j j2) {
        int i;
        int i2;
        int obj7 = mutationBatch.getBatchId();
        int indexOfExistingBatchId = indexOfExistingBatchId(obj7, "acknowledged");
        final int i3 = 1;
        final int i4 = 0;
        i = indexOfExistingBatchId == 0 ? i3 : i4;
        Assert.hardAssert(i, "Can only acknowledge the first batch in the mutation queue", new Object[i4]);
        Object obj = this.queue.get(indexOfExistingBatchId);
        i2 = obj7 == (MutationBatch)obj.getBatchId() ? i3 : i4;
        Object[] arr2 = new Object[2];
        arr2[i4] = Integer.valueOf(obj7);
        arr2[i3] = Integer.valueOf(obj.getBatchId());
        Assert.hardAssert(i2, "Queue ordering failure: expected batch %d, got batch %d", arr2);
        this.lastStreamToken = (j)Preconditions.checkNotNull(j2);
    }

    public MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list2, List<Mutation> list3) {
        int i;
        int documentReference;
        int size;
        Object queue;
        List obj7;
        List obj8;
        i = 1;
        documentReference = 0;
        Assert.hardAssert(empty ^= i, "Mutation batches should not be empty", new Object[documentReference]);
        int nextBatchId = this.nextBatchId;
        this.nextBatchId = nextBatchId + 1;
        size = this.queue.size();
        if (size > 0) {
            if ((MutationBatch)this.queue.get(size -= i).getBatchId() < nextBatchId) {
            } else {
                i = documentReference;
            }
            Assert.hardAssert(i, "Mutation batchIds must be monotonically increasing order", new Object[documentReference]);
        }
        MutationBatch mutationBatch = new MutationBatch(nextBatchId, timestamp, list2, list3);
        this.queue.add(mutationBatch);
        Iterator obj6 = list3.iterator();
        for (Mutation obj7 : obj6) {
            documentReference = new DocumentReference(obj7.getKey(), nextBatchId);
            this.batchesByDocumentKey = this.batchesByDocumentKey.insert(documentReference);
            this.persistence.getIndexManager().addToCollectionParentIndex((ResourcePath)obj7.getKey().getPath().popLast());
        }
        return mutationBatch;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    boolean containsKey(DocumentKey documentKey) {
        final int i = 0;
        DocumentReference documentReference = new DocumentReference(documentKey, i);
        Iterator iteratorFrom = this.batchesByDocumentKey.iteratorFrom(documentReference);
        if (!iteratorFrom.hasNext()) {
            return i;
        }
        return (DocumentReference)iteratorFrom.next().getKey().equals(documentKey);
    }

    public List<MutationBatch> getAllMutationBatches() {
        return Collections.unmodifiableList(this.queue);
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey) {
        ImmutableSortedSet batchesByDocumentKey;
        boolean next;
        int equals;
        Object[] arr;
        String str;
        final int i = 0;
        DocumentReference documentReference = new DocumentReference(documentKey, i);
        ArrayList arrayList = new ArrayList();
        Iterator iteratorFrom = this.batchesByDocumentKey.iteratorFrom(documentReference);
        while (iteratorFrom.hasNext()) {
            next = iteratorFrom.next();
            if (!documentKey.equals((DocumentReference)next.getKey())) {
                break;
            } else {
            }
            batchesByDocumentKey = lookupMutationBatch(next.getId());
            if (batchesByDocumentKey != null) {
            } else {
            }
            equals = i;
            Assert.hardAssert(equals, "Batches in the index must exist in the main table", new Object[i]);
            arrayList.add(batchesByDocumentKey);
            equals = 1;
        }
        return arrayList;
    }

    public List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable) {
        ImmutableSortedSet immutableSortedSet;
        List emptyList;
        java.util.Comparator iteratorFrom;
        boolean next;
        ImmutableSortedSet batchesByDocumentKey;
        boolean equals;
        immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), Util.comparator());
        Iterator obj6 = iterable.iterator();
        for (DocumentKey emptyList : obj6) {
            DocumentReference documentReference = new DocumentReference(emptyList, 0);
            iteratorFrom = this.batchesByDocumentKey.iteratorFrom(documentReference);
            while (iteratorFrom.hasNext()) {
                next = iteratorFrom.next();
                if (!emptyList.equals((DocumentReference)next.getKey())) {
                    break loop_3;
                } else {
                }
                immutableSortedSet = immutableSortedSet.insert(Integer.valueOf(next.getId()));
            }
            next = iteratorFrom.next();
            if (!emptyList.equals((DocumentReference)next.getKey())) {
            } else {
            }
            immutableSortedSet = immutableSortedSet.insert(Integer.valueOf(next.getId()));
        }
        return lookupMutationBatches(immutableSortedSet);
    }

    public List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query) {
        ImmutableSortedSet immutableSortedSet;
        BasePath append;
        com.google.firebase.firestore.local.DocumentReference documentReference;
        java.util.Comparator comparator;
        boolean prefixOf;
        int i3 = 0;
        Assert.hardAssert(collectionGroupQuery ^= 1, "CollectionGroup queries should be handled in LocalDocumentsView", new Object[i3]);
        com.google.firebase.firestore.model.ResourcePath obj7 = query.getPath();
        if (!DocumentKey.isDocumentKey(obj7)) {
            append = obj7.append("");
        } else {
            append = obj7;
        }
        documentReference = new DocumentReference(DocumentKey.fromPath(append), i3);
        immutableSortedSet = new ImmutableSortedSet(Collections.emptyList(), Util.comparator());
        Iterator iteratorFrom = this.batchesByDocumentKey.iteratorFrom(documentReference);
        while (iteratorFrom.hasNext()) {
            documentReference = iteratorFrom.next();
            comparator = (DocumentReference)documentReference.getKey().getPath();
            if (!obj7.isPrefixOf(comparator)) {
                break;
            } else {
            }
            if (comparator.length() == length++) {
            }
            immutableSortedSet = immutableSortedSet.insert(Integer.valueOf(documentReference.getId()));
        }
        return lookupMutationBatches(immutableSortedSet);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    long getByteSize(com.google.firebase.firestore.local.LocalSerializer localSerializer) {
        int i;
        long l;
        Iterator iterator = this.queue.iterator();
        i = 0;
        for (MutationBatch next2 : iterator) {
            i += l;
        }
        return i;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public int getHighestUnacknowledgedBatchId() {
        int i;
        i = this.queue.isEmpty() ? -1 : nextBatchId + -1;
        return i;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public j getLastStreamToken() {
        return this.lastStreamToken;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch getNextMutationBatchAfterBatchId(int i) {
        List queue;
        int obj2;
        if (indexOfBatchId(i++) < 0) {
            obj2 = 0;
        }
        if (this.queue.size() > obj2) {
            obj2 = this.queue.get(obj2);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public MutationBatch lookupMutationBatch(int i) {
        int size;
        int obj4;
        int indexOfBatchId = indexOfBatchId(i);
        if (indexOfBatchId >= 0) {
            if (indexOfBatchId >= this.queue.size()) {
            } else {
                Object obj = this.queue.get(indexOfBatchId);
                int i2 = 0;
                obj4 = (MutationBatch)obj.getBatchId() == i ? 1 : i2;
            }
            Assert.hardAssert(obj4, "If found batch must match", new Object[i2]);
            return obj;
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void performConsistencyCheck() {
        boolean empty;
        Object[] arr;
        String str;
        if (this.queue.isEmpty()) {
            Assert.hardAssert(this.batchesByDocumentKey.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void removeMutationBatch(MutationBatch mutationBatch) {
        int i;
        ImmutableSortedSet batchesByDocumentKey;
        Object[] arr;
        String documentReference;
        int batchId;
        int i2 = 0;
        i = indexOfExistingBatchId(mutationBatch.getBatchId(), "removed") == 0 ? 1 : i2;
        Assert.hardAssert(i, "Can only remove the first entry of the mutation queue", new Object[i2]);
        this.queue.remove(i2);
        batchesByDocumentKey = this.batchesByDocumentKey;
        Iterator iterator = mutationBatch.getMutations().iterator();
        for (Mutation next2 : iterator) {
            arr = next2.getKey();
            this.persistence.getReferenceDelegate().removeMutationReference(arr);
            documentReference = new DocumentReference(arr, mutationBatch.getBatchId());
            batchesByDocumentKey = batchesByDocumentKey.remove(documentReference);
        }
        this.batchesByDocumentKey = batchesByDocumentKey;
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void setLastStreamToken(j j) {
        this.lastStreamToken = (j)Preconditions.checkNotNull(j);
    }

    @Override // com.google.firebase.firestore.local.MutationQueue
    public void start() {
        boolean empty;
        if (isEmpty()) {
            this.nextBatchId = 1;
        }
    }
}
