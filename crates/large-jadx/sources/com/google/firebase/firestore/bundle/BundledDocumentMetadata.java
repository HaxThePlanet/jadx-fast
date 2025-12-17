package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import java.util.List;

/* loaded from: classes2.dex */
public class BundledDocumentMetadata implements com.google.firebase.firestore.bundle.BundleElement {

    private final boolean exists;
    private final DocumentKey key;
    private final List<String> queries;
    private final SnapshotVersion readTime;
    public BundledDocumentMetadata(DocumentKey documentKey, SnapshotVersion snapshotVersion2, boolean z3, List<String> list4) {
        super();
        this.key = documentKey;
        this.readTime = snapshotVersion2;
        this.exists = z3;
        this.queries = list4;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public boolean equals(Object object) {
        Class class;
        Class class2;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.exists != object.exists) {
                    return i;
                }
                if (!this.key.equals(object.key)) {
                    return i;
                }
                if (!this.readTime.equals(object.readTime)) {
                    return i;
                }
            }
            return this.queries.equals(object.queries);
        }
        return i;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public boolean exists() {
        return this.exists;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public DocumentKey getKey() {
        return this.key;
    }

    public List<String> getQueries() {
        return this.queries;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public SnapshotVersion getReadTime() {
        return this.readTime;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int hashCode() {
        return i6 += i9;
    }
}
