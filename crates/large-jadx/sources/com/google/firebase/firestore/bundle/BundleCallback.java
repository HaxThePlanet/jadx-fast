package com.google.firebase.firestore.bundle;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;

/* loaded from: classes2.dex */
public interface BundleCallback {
    public abstract ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments(ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap, String string2);

    public abstract void saveBundle(com.google.firebase.firestore.bundle.BundleMetadata bundleMetadata);

    public abstract void saveNamedQuery(com.google.firebase.firestore.bundle.NamedQuery namedQuery, ImmutableSortedSet<DocumentKey> immutableSortedSet2);
}
