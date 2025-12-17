package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;

/* loaded from: classes2.dex */
public class DocumentCollections {

    private static final ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, ?> EMPTY_DOCUMENT_MAP;
    static {
        DocumentCollections.EMPTY_DOCUMENT_MAP = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());
    }

    public static ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.Document> emptyDocumentMap() {
        return DocumentCollections.EMPTY_DOCUMENT_MAP;
    }

    public static ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.MutableDocument> emptyMutableDocumentMap() {
        return DocumentCollections.EMPTY_DOCUMENT_MAP;
    }

    public static ImmutableSortedMap<com.google.firebase.firestore.model.DocumentKey, com.google.firebase.firestore.model.SnapshotVersion> emptyVersionMap() {
        return DocumentCollections.EMPTY_DOCUMENT_MAP;
    }
}
