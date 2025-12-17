package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.util.Preconditions;
import com.google.protobuf.j;

/* loaded from: classes2.dex */
public final class TargetData {

    private final SnapshotVersion lastLimboFreeSnapshotVersion;
    private final com.google.firebase.firestore.local.QueryPurpose purpose;
    private final j resumeToken;
    private final long sequenceNumber;
    private final SnapshotVersion snapshotVersion;
    private final Target target;
    private final int targetId;
    public TargetData(Target target, int i2, long l3, com.google.firebase.firestore.local.QueryPurpose queryPurpose4) {
        final SnapshotVersion nONE = SnapshotVersion.NONE;
        super(target, i2, l3, obj4, obj14, nONE, nONE, WatchStream.EMPTY_RESUME_TOKEN);
    }

    TargetData(Target target, int i2, long l3, com.google.firebase.firestore.local.QueryPurpose queryPurpose4, SnapshotVersion snapshotVersion5, SnapshotVersion snapshotVersion6, j j7) {
        super();
        this.target = (Target)Preconditions.checkNotNull(target);
        this.targetId = i2;
        this.sequenceNumber = l3;
        this.lastLimboFreeSnapshotVersion = j7;
        this.purpose = snapshotVersion5;
        this.snapshotVersion = (SnapshotVersion)Preconditions.checkNotNull(snapshotVersion6);
        this.resumeToken = (j)Preconditions.checkNotNull(obj8);
    }

    public boolean equals(Object object) {
        int i;
        j resumeToken;
        Class<com.google.firebase.firestore.local.TargetData> obj;
        Object lastLimboFreeSnapshotVersion;
        Class class;
        long sequenceNumber;
        boolean obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (TargetData.class != object.getClass()) {
            } else {
                if (this.target.equals(object.target) && this.targetId == object.targetId && Long.compare(sequenceNumber2, sequenceNumber) == 0 && this.purpose.equals(object.purpose) && this.snapshotVersion.equals(object.snapshotVersion) && this.lastLimboFreeSnapshotVersion.equals(object.lastLimboFreeSnapshotVersion) && this.resumeToken.equals(object.resumeToken)) {
                    if (this.targetId == object.targetId) {
                        if (Long.compare(sequenceNumber2, sequenceNumber) == 0) {
                            if (this.purpose.equals(object.purpose)) {
                                if (this.snapshotVersion.equals(object.snapshotVersion)) {
                                    if (this.lastLimboFreeSnapshotVersion.equals(object.lastLimboFreeSnapshotVersion)) {
                                        if (this.resumeToken.equals(object.resumeToken)) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public SnapshotVersion getLastLimboFreeSnapshotVersion() {
        return this.lastLimboFreeSnapshotVersion;
    }

    public com.google.firebase.firestore.local.QueryPurpose getPurpose() {
        return this.purpose;
    }

    public j getResumeToken() {
        return this.resumeToken;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.snapshotVersion;
    }

    public Target getTarget() {
        return this.target;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public int hashCode() {
        return i12 += i18;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TargetData{target=");
        stringBuilder.append(this.target);
        stringBuilder.append(", targetId=");
        stringBuilder.append(this.targetId);
        stringBuilder.append(", sequenceNumber=");
        stringBuilder.append(this.sequenceNumber);
        stringBuilder.append(", purpose=");
        stringBuilder.append(this.purpose);
        stringBuilder.append(", snapshotVersion=");
        stringBuilder.append(this.snapshotVersion);
        stringBuilder.append(", lastLimboFreeSnapshotVersion=");
        stringBuilder.append(this.lastLimboFreeSnapshotVersion);
        stringBuilder.append(", resumeToken=");
        stringBuilder.append(this.resumeToken);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public com.google.firebase.firestore.local.TargetData withLastLimboFreeSnapshotVersion(SnapshotVersion snapshotVersion) {
        super(this.target, this.targetId, this.sequenceNumber, obj4, this.purpose, this.snapshotVersion, snapshotVersion, this.resumeToken);
        return targetData2;
    }

    public com.google.firebase.firestore.local.TargetData withResumeToken(j j, SnapshotVersion snapshotVersion2) {
        super(this.target, this.targetId, this.sequenceNumber, obj4, this.purpose, snapshotVersion2, this.lastLimboFreeSnapshotVersion, j);
        return targetData2;
    }

    public com.google.firebase.firestore.local.TargetData withSequenceNumber(long l) {
        super(this.target, this.targetId, l, obj4, this.purpose, this.snapshotVersion, this.lastLimboFreeSnapshotVersion, this.resumeToken);
        return targetData2;
    }
}
