package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.protobuf.j;
import java.util.List;

/* loaded from: classes2.dex */
interface MutationQueue {
    public abstract void acknowledgeBatch(MutationBatch mutationBatch, j j2);

    public abstract MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list2, List<Mutation> list3);

    public abstract List<MutationBatch> getAllMutationBatches();

    public abstract List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey);

    public abstract List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable);

    public abstract List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query);

    public abstract int getHighestUnacknowledgedBatchId();

    public abstract j getLastStreamToken();

    public abstract MutationBatch getNextMutationBatchAfterBatchId(int i);

    public abstract boolean isEmpty();

    public abstract MutationBatch lookupMutationBatch(int i);

    public abstract void performConsistencyCheck();

    public abstract void removeMutationBatch(MutationBatch mutationBatch);

    public abstract void setLastStreamToken(j j);

    public abstract void start();
}
