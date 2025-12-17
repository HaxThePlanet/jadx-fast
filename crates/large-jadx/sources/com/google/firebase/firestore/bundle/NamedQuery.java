package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.SnapshotVersion;

/* loaded from: classes2.dex */
public class NamedQuery implements com.google.firebase.firestore.bundle.BundleElement {

    private final com.google.firebase.firestore.bundle.BundledQuery bundledQuery;
    private final String name;
    private final SnapshotVersion readTime;
    public NamedQuery(String string, com.google.firebase.firestore.bundle.BundledQuery bundledQuery2, SnapshotVersion snapshotVersion3) {
        super();
        this.name = string;
        this.bundledQuery = bundledQuery2;
        this.readTime = snapshotVersion3;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public boolean equals(Object object) {
        Class class2;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (!this.name.equals(object.name)) {
                    return i;
                }
                if (!this.bundledQuery.equals(object.bundledQuery)) {
                    return i;
                }
            }
            return this.readTime.equals(object.readTime);
        }
        return i;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public com.google.firebase.firestore.bundle.BundledQuery getBundledQuery() {
        return this.bundledQuery;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public SnapshotVersion getReadTime() {
        return this.readTime;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int hashCode() {
        return i4 += i7;
    }
}
