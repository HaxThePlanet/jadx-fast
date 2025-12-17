package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public final class UserWriteRecord {

    private final com.google.firebase.database.core.CompoundWrite merge;
    private final Node overwrite;
    private final com.google.firebase.database.core.Path path;
    private final boolean visible;
    private final long writeId;
    public UserWriteRecord(long l, com.google.firebase.database.core.Path path2, com.google.firebase.database.core.CompoundWrite compoundWrite3) {
        super();
        this.writeId = l;
        this.path = compoundWrite3;
        this.overwrite = 0;
        this.merge = obj4;
        this.visible = true;
    }

    public UserWriteRecord(long l, com.google.firebase.database.core.Path path2, Node node3, boolean z4) {
        super();
        this.writeId = l;
        this.path = node3;
        this.overwrite = z4;
        this.merge = 0;
        this.visible = obj5;
    }

    public boolean equals(Object object) {
        Node overwrite;
        Class<com.google.firebase.database.core.UserWriteRecord> obj;
        boolean overwrite2;
        Class class;
        boolean obj7;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (UserWriteRecord.class != object.getClass()) {
            } else {
                if (Long.compare(writeId, writeId2) != 0) {
                    return i2;
                }
                if (!this.path.equals(object.path)) {
                    return i2;
                }
                if (this.visible != object.visible) {
                    return i2;
                }
                Node overwrite3 = this.overwrite;
                if (overwrite3 != null) {
                    if (overwrite3.equals(object.overwrite)) {
                    }
                    return i2;
                } else {
                    if (object.overwrite != null) {
                    }
                }
                com.google.firebase.database.core.CompoundWrite merge = this.merge;
                obj7 = object.merge;
                if (merge != null) {
                    if (merge.equals(obj7)) {
                    }
                    return i2;
                } else {
                    if (obj7 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public com.google.firebase.database.core.CompoundWrite getMerge() {
        com.google.firebase.database.core.CompoundWrite merge = this.merge;
        if (merge == null) {
        } else {
            return merge;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't access merge when write is an overwrite!");
        throw illegalArgumentException;
    }

    public Node getOverwrite() {
        Node overwrite = this.overwrite;
        if (overwrite == null) {
        } else {
            return overwrite;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't access overwrite when write is a merge!");
        throw illegalArgumentException;
    }

    public com.google.firebase.database.core.Path getPath() {
        return this.path;
    }

    public long getWriteId() {
        return this.writeId;
    }

    public int hashCode() {
        int i;
        int i2;
        Node overwrite = this.overwrite;
        if (overwrite != null) {
            i = overwrite.hashCode();
        } else {
            i = i2;
        }
        com.google.firebase.database.core.CompoundWrite merge = this.merge;
        if (merge != null) {
            i2 = merge.hashCode();
        }
        return i10 += i2;
    }

    public boolean isMerge() {
        int i;
        i = this.merge != null ? 1 : 0;
        return i;
    }

    public boolean isOverwrite() {
        int i;
        i = this.overwrite != null ? 1 : 0;
        return i;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserWriteRecord{id=");
        stringBuilder.append(this.writeId);
        stringBuilder.append(" path=");
        stringBuilder.append(this.path);
        stringBuilder.append(" visible=");
        stringBuilder.append(this.visible);
        stringBuilder.append(" overwrite=");
        stringBuilder.append(this.overwrite);
        stringBuilder.append(" merge=");
        stringBuilder.append(this.merge);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
