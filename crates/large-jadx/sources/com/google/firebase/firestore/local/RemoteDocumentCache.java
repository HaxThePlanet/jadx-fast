package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.Map;

/* loaded from: classes2.dex */
interface RemoteDocumentCache {
    public abstract void add(MutableDocument mutableDocument, SnapshotVersion snapshotVersion2);

    public abstract MutableDocument get(DocumentKey documentKey);

    public abstract Map<DocumentKey, MutableDocument> getAll(Iterable<DocumentKey> iterable);

    public abstract ImmutableSortedMap<DocumentKey, MutableDocument> getAllDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2);

    public abstract void remove(DocumentKey documentKey);
}
