package com.google.firebase.firestore.model.mutation;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.j;
import java.util.List;

/* loaded from: classes2.dex */
public final class MutationBatchResult {

    private final com.google.firebase.firestore.model.mutation.MutationBatch batch;
    private final SnapshotVersion commitVersion;
    private final ImmutableSortedMap<DocumentKey, SnapshotVersion> docVersions;
    private final List<com.google.firebase.firestore.model.mutation.MutationResult> mutationResults;
    private final j streamToken;
    private MutationBatchResult(com.google.firebase.firestore.model.mutation.MutationBatch mutationBatch, SnapshotVersion snapshotVersion2, List<com.google.firebase.firestore.model.mutation.MutationResult> list3, j j4, ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMap5) {
        super();
        this.batch = mutationBatch;
        this.commitVersion = snapshotVersion2;
        this.mutationResults = list3;
        this.streamToken = j4;
        this.docVersions = immutableSortedMap5;
    }

    public static com.google.firebase.firestore.model.mutation.MutationBatchResult create(com.google.firebase.firestore.model.mutation.MutationBatch mutationBatch, SnapshotVersion snapshotVersion2, List<com.google.firebase.firestore.model.mutation.MutationResult> list3, j j4) {
        int i2;
        ImmutableSortedMap emptyVersionMap;
        String str;
        int i;
        ImmutableSortedMap insert;
        int i4 = 1;
        i = 0;
        i2 = mutationBatch.getMutations().size() == list3.size() ? i4 : i;
        Object[] arr = new Object[2];
        arr[i] = Integer.valueOf(mutationBatch.getMutations().size());
        arr[i4] = Integer.valueOf(list3.size());
        Assert.hardAssert(i2, "Mutations sent %d must equal results received %d", arr);
        List mutations2 = mutationBatch.getMutations();
        insert = emptyVersionMap;
        while (i < mutations2.size()) {
            insert = insert.insert((Mutation)mutations2.get(i).getKey(), (MutationResult)list3.get(i).getVersion());
            i++;
        }
        super(mutationBatch, snapshotVersion2, list3, j4, insert);
        return mutationBatchResult;
    }

    public com.google.firebase.firestore.model.mutation.MutationBatch getBatch() {
        return this.batch;
    }

    public SnapshotVersion getCommitVersion() {
        return this.commitVersion;
    }

    public ImmutableSortedMap<DocumentKey, SnapshotVersion> getDocVersions() {
        return this.docVersions;
    }

    public List<com.google.firebase.firestore.model.mutation.MutationResult> getMutationResults() {
        return this.mutationResults;
    }

    public j getStreamToken() {
        return this.streamToken;
    }
}
