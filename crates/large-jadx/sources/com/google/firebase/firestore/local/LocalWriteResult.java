package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;

/* loaded from: classes2.dex */
public final class LocalWriteResult {

    private final int batchId;
    private final ImmutableSortedMap<DocumentKey, Document> changes;
    LocalWriteResult(int i, ImmutableSortedMap<DocumentKey, Document> immutableSortedMap2) {
        super();
        this.batchId = i;
        this.changes = immutableSortedMap2;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public ImmutableSortedMap<DocumentKey, Document> getChanges() {
        return this.changes;
    }
}
