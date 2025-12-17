package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public class SnapshotMetadata {

    private final boolean hasPendingWrites;
    private final boolean isFromCache;
    SnapshotMetadata(boolean z, boolean z2) {
        super();
        this.hasPendingWrites = z;
        this.isFromCache = z2;
    }

    public boolean equals(Object object) {
        int i;
        boolean hasPendingWrites;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof SnapshotMetadata == null) {
            return i2;
        }
        if (this.hasPendingWrites == object.hasPendingWrites && this.isFromCache == object.isFromCache) {
            if (this.isFromCache == object.isFromCache) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public boolean hasPendingWrites() {
        return this.hasPendingWrites;
    }

    public int hashCode() {
        return i += isFromCache;
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SnapshotMetadata{hasPendingWrites=");
        stringBuilder.append(this.hasPendingWrites);
        stringBuilder.append(", isFromCache=");
        stringBuilder.append(this.isFromCache);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
