package com.google.firebase.firestore.bundle;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.LoadBundleTaskProgress.TaskState;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class BundleLoader {

    private final com.google.firebase.firestore.bundle.BundleCallback bundleCallback;
    private final com.google.firebase.firestore.bundle.BundleMetadata bundleMetadata;
    private long bytesLoaded;
    private DocumentKey currentDocument;
    private ImmutableSortedMap<DocumentKey, MutableDocument> documents;
    private final Map<DocumentKey, com.google.firebase.firestore.bundle.BundledDocumentMetadata> documentsMetadata;
    private final List<com.google.firebase.firestore.bundle.NamedQuery> queries;
    public BundleLoader(com.google.firebase.firestore.bundle.BundleCallback bundleCallback, com.google.firebase.firestore.bundle.BundleMetadata bundleMetadata2) {
        super();
        this.bundleCallback = bundleCallback;
        this.bundleMetadata = bundleMetadata2;
        ArrayList obj1 = new ArrayList();
        this.queries = obj1;
        this.documents = DocumentCollections.emptyMutableDocumentMap();
        obj1 = new HashMap();
        this.documentsMetadata = obj1;
    }

    private Map<String, ImmutableSortedSet<DocumentKey>> getQueryDocumentMapping() {
        String name;
        boolean next;
        ImmutableSortedSet emptyKeySet;
        boolean next2;
        ImmutableSortedSet insert;
        DocumentKey key;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.queries.iterator();
        for (NamedQuery next4 : iterator) {
            hashMap.put(next4.getName(), DocumentKey.emptyKeySet());
        }
        Iterator iterator2 = this.documentsMetadata.values().iterator();
        for (BundledDocumentMetadata next : iterator2) {
            emptyKeySet = next.getQueries().iterator();
            for (String next2 : emptyKeySet) {
                hashMap.put(next2, (ImmutableSortedSet)hashMap.get(next2).insert(next.getKey()));
            }
            next2 = emptyKeySet.next();
            hashMap.put(next2, (ImmutableSortedSet)hashMap.get((String)next2).insert(next.getKey()));
        }
        return hashMap;
    }

    public LoadBundleTaskProgress addElement(com.google.firebase.firestore.bundle.BundleElement bundleElement, long l2) {
        boolean documents;
        int loadBundleTaskProgress;
        DocumentKey key;
        int i2;
        DocumentKey size;
        int totalDocuments;
        long bytesLoaded;
        long totalBytes;
        int i;
        LoadBundleTaskProgress.TaskState rUNNING;
        Object obj13;
        Preconditions.checkArgument(z ^= 1, "Unexpected bundle metadata element.", new Object[0]);
        loadBundleTaskProgress = 0;
        if (bundleElement instanceof NamedQuery) {
            this.queries.add((NamedQuery)bundleElement);
        } else {
            if (bundleElement instanceof BundledDocumentMetadata != null) {
                this.documentsMetadata.put((BundledDocumentMetadata)bundleElement.getKey(), bundleElement);
                this.currentDocument = bundleElement.getKey();
                if (!bundleElement.exists()) {
                    this.documents = this.documents.insert(bundleElement.getKey(), MutableDocument.newNoDocument(bundleElement.getKey(), bundleElement.getReadTime()));
                    this.currentDocument = loadBundleTaskProgress;
                }
            } else {
                if (bundleElement instanceof BundleDocument) {
                    if (!(BundleDocument)bundleElement.getKey().equals(this.currentDocument)) {
                    } else {
                        this.documents = this.documents.insert(bundleElement.getKey(), bundleElement.getDocument());
                        this.currentDocument = loadBundleTaskProgress;
                    }
                    obj13 = new IllegalArgumentException("The document being added does not match the stored metadata.");
                    throw obj13;
                }
            }
        }
        this.bytesLoaded = bytesLoaded2 += l2;
        if (this.documents.size() != this.documents.size()) {
            super(this.documents.size(), this.bundleMetadata.getTotalDocuments(), this.bytesLoaded, obj7, this.bundleMetadata.getTotalBytes(), obj9, 0, LoadBundleTaskProgress.TaskState.RUNNING);
        }
        return loadBundleTaskProgress;
    }

    public ImmutableSortedMap<DocumentKey, Document> applyChanges() {
        int i;
        int i3;
        int i2;
        Object[] next;
        Integer bundleCallback;
        Object obj;
        int i4 = 1;
        int i5 = 0;
        i = this.currentDocument == null ? i4 : i5;
        Preconditions.checkArgument(i, "Bundled documents end with a document metadata element instead of a document.", new Object[i5]);
        i3 = this.bundleMetadata.getBundleId() != null ? i4 : i5;
        Preconditions.checkArgument(i3, "Bundle ID must be set", new Object[i5]);
        i2 = this.documents.size() == this.bundleMetadata.getTotalDocuments() ? i4 : i5;
        next = new Object[2];
        next[i5] = Integer.valueOf(this.bundleMetadata.getTotalDocuments());
        next[i4] = Integer.valueOf(this.documents.size());
        Preconditions.checkArgument(i2, "Expected %s documents, but loaded %s.", next);
        Iterator iterator = this.queries.iterator();
        for (NamedQuery next : iterator) {
            this.bundleCallback.saveNamedQuery(next, (ImmutableSortedSet)getQueryDocumentMapping().get(next.getName()));
        }
        this.bundleCallback.saveBundle(this.bundleMetadata);
        return this.bundleCallback.applyBundledDocuments(this.documents, this.bundleMetadata.getBundleId());
    }
}
