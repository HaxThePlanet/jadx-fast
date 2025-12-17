package com.google.firebase.firestore.model;

import com.google.firebase.Timestamp;

/* loaded from: classes2.dex */
public final class SnapshotVersion implements Comparable<com.google.firebase.firestore.model.SnapshotVersion> {

    public static final com.google.firebase.firestore.model.SnapshotVersion NONE;
    private final Timestamp timestamp;
    static {
        Timestamp timestamp = new Timestamp(0, obj3, 0);
        SnapshotVersion snapshotVersion = new SnapshotVersion(timestamp);
        SnapshotVersion.NONE = snapshotVersion;
    }

    public SnapshotVersion(Timestamp timestamp) {
        super();
        this.timestamp = timestamp;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.firestore.model.SnapshotVersion snapshotVersion) {
        return this.timestamp.compareTo(snapshotVersion.timestamp);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((SnapshotVersion)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof SnapshotVersion) {
            return i2;
        }
        if (compareTo((SnapshotVersion)object) == 0) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return getTimestamp().hashCode();
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SnapshotVersion(seconds=");
        stringBuilder.append(this.timestamp.getSeconds());
        stringBuilder.append(", nanos=");
        stringBuilder.append(this.timestamp.getNanoseconds());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
