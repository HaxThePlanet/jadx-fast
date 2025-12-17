package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.SnapshotVersion;

/* loaded from: classes2.dex */
public class BundleMetadata implements com.google.firebase.firestore.bundle.BundleElement {

    private final String bundleId;
    private final SnapshotVersion createTime;
    private final int schemaVersion;
    private final long totalBytes;
    private final int totalDocuments;
    public BundleMetadata(String string, int i2, SnapshotVersion snapshotVersion3, int i4, long l5) {
        super();
        this.bundleId = string;
        this.schemaVersion = i2;
        this.createTime = snapshotVersion3;
        this.totalDocuments = i4;
        this.totalBytes = l5;
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
                if (this.schemaVersion != object.schemaVersion) {
                    return i;
                }
                if (this.totalDocuments != object.totalDocuments) {
                    return i;
                }
                if (Long.compare(totalBytes, totalBytes2) != 0) {
                    return i;
                }
                if (!this.bundleId.equals(object.bundleId)) {
                    return i;
                }
            }
            return this.createTime.equals(object.createTime);
        }
        return i;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public String getBundleId() {
        return this.bundleId;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public SnapshotVersion getCreateTime() {
        return this.createTime;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public long getTotalBytes() {
        return this.totalBytes;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int getTotalDocuments() {
        return this.totalDocuments;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int hashCode() {
        long totalBytes = this.totalBytes;
        return i8 += i12;
    }
}
