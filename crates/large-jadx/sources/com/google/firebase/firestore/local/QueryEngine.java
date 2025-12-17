package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;

/* loaded from: classes2.dex */
public interface QueryEngine {
    public abstract ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query, SnapshotVersion snapshotVersion2, ImmutableSortedSet<DocumentKey> immutableSortedSet3);

    public abstract void handleDocumentChange(MutableDocument mutableDocument, MutableDocument mutableDocument2);

    public abstract void setLocalDocumentsView(com.google.firebase.firestore.local.LocalDocumentsView localDocumentsView);
}
