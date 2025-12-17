package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MutationBatch {

    public static final int UNKNOWN = -1;
    private final List<com.google.firebase.firestore.model.mutation.Mutation> baseMutations;
    private final int batchId;
    private final Timestamp localWriteTime;
    private final List<com.google.firebase.firestore.model.mutation.Mutation> mutations;
    public MutationBatch(int i, Timestamp timestamp2, List<com.google.firebase.firestore.model.mutation.Mutation> list3, List<com.google.firebase.firestore.model.mutation.Mutation> list4) {
        super();
        Assert.hardAssert(empty ^= 1, "Cannot create an empty mutation batch", new Object[0]);
        this.batchId = i;
        this.localWriteTime = timestamp2;
        this.baseMutations = list3;
        this.mutations = list4;
    }

    public void applyToLocalDocumentSet(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        Object obj;
        boolean validDocument;
        Iterator iterator = getKeys().iterator();
        while (iterator.hasNext()) {
            obj = immutableSortedMap.get((DocumentKey)iterator.next());
            applyToLocalView((MutableDocument)obj);
            if (!obj.isValidDocument()) {
            }
            obj.convertToNoDocument(SnapshotVersion.NONE);
        }
    }

    public void applyToLocalView(MutableDocument mutableDocument) {
        com.google.firebase.firestore.model.mutation.FieldMask toLocalView;
        int i;
        int i2;
        Object obj;
        int localWriteTime;
        boolean localWriteTime2;
        DocumentKey key;
        HashSet hashSet = new HashSet();
        toLocalView = FieldMask.fromSet(hashSet);
        i2 = i;
        while (i2 < this.baseMutations.size()) {
            obj = this.baseMutations.get(i2);
            if ((Mutation)obj.getKey().equals(mutableDocument.getKey())) {
            }
            i2++;
            toLocalView = obj.applyToLocalView(mutableDocument, toLocalView, this.localWriteTime);
        }
        while (i < this.mutations.size()) {
            i2 = this.mutations.get(i);
            if ((Mutation)i2.getKey().equals(mutableDocument.getKey())) {
            }
            i++;
            toLocalView = i2.applyToLocalView(mutableDocument, toLocalView, this.localWriteTime);
        }
    }

    public void applyToRemoteDocument(MutableDocument mutableDocument, com.google.firebase.firestore.model.mutation.MutationBatchResult mutationBatchResult2) {
        int i;
        String equals;
        int i2;
        Object[] arr;
        int size = this.mutations.size();
        final List obj8 = mutationBatchResult2.getMutationResults();
        int i3 = 1;
        i2 = 0;
        i = obj8.size() == size ? i3 : i2;
        arr = new Object[2];
        arr[i2] = Integer.valueOf(size);
        arr[i3] = Integer.valueOf(obj8.size());
        Assert.hardAssert(i, "Mismatch between mutations length (%d) and results length (%d)", arr);
        while (i2 < size) {
            i = this.mutations.get(i2);
            if ((Mutation)i.getKey().equals(mutableDocument.getKey())) {
            }
            i2++;
            i.applyToRemoteDocument(mutableDocument, (MutationResult)obj8.get(i2));
        }
    }

    public boolean equals(Object object) {
        int i;
        int batchId;
        Class<com.google.firebase.firestore.model.mutation.MutationBatch> obj;
        int localWriteTime;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (MutationBatch.class != object.getClass()) {
            } else {
                if (this.batchId == object.batchId && this.localWriteTime.equals(object.localWriteTime) && this.baseMutations.equals(object.baseMutations) && this.mutations.equals(object.mutations)) {
                    if (this.localWriteTime.equals(object.localWriteTime)) {
                        if (this.baseMutations.equals(object.baseMutations)) {
                            if (this.mutations.equals(object.mutations)) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public List<com.google.firebase.firestore.model.mutation.Mutation> getBaseMutations() {
        return this.baseMutations;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public Set<DocumentKey> getKeys() {
        DocumentKey key;
        HashSet hashSet = new HashSet();
        Iterator iterator = this.mutations.iterator();
        for (Mutation next2 : iterator) {
            hashSet.add(next2.getKey());
        }
        return hashSet;
    }

    public Timestamp getLocalWriteTime() {
        return this.localWriteTime;
    }

    public List<com.google.firebase.firestore.model.mutation.Mutation> getMutations() {
        return this.mutations;
    }

    public int hashCode() {
        return i5 += i9;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MutationBatch(batchId=");
        stringBuilder.append(this.batchId);
        stringBuilder.append(", localWriteTime=");
        stringBuilder.append(this.localWriteTime);
        stringBuilder.append(", baseMutations=");
        stringBuilder.append(this.baseMutations);
        stringBuilder.append(", mutations=");
        stringBuilder.append(this.mutations);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
