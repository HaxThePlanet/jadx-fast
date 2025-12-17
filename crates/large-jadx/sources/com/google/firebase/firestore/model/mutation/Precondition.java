package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class Precondition {

    public static final com.google.firebase.firestore.model.mutation.Precondition NONE;
    private final Boolean exists;
    private final SnapshotVersion updateTime;
    static {
        final int i = 0;
        Precondition precondition = new Precondition(i, i);
        Precondition.NONE = precondition;
    }

    private Precondition(SnapshotVersion snapshotVersion, Boolean boolean2) {
        int i;
        super();
        int i2 = 0;
        if (snapshotVersion != null) {
            if (boolean2 == null) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        Assert.hardAssert(i, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[i2]);
        this.updateTime = snapshotVersion;
        this.exists = boolean2;
    }

    public static com.google.firebase.firestore.model.mutation.Precondition exists(boolean z) {
        Precondition precondition = new Precondition(0, Boolean.valueOf(z));
        return precondition;
    }

    public static com.google.firebase.firestore.model.mutation.Precondition updateTime(SnapshotVersion snapshotVersion) {
        Precondition precondition = new Precondition(snapshotVersion, 0);
        return precondition;
    }

    public boolean equals(Object object) {
        boolean equals;
        boolean updateTime;
        Class<com.google.firebase.firestore.model.mutation.Precondition> obj;
        Object updateTime2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (Precondition.class != object.getClass()) {
            } else {
                SnapshotVersion updateTime3 = this.updateTime;
                if (updateTime3 != null) {
                    if (!updateTime3.equals(object.updateTime)) {
                        return i;
                    }
                } else {
                    if (object.updateTime != null) {
                    }
                }
                Boolean exists = this.exists;
                final Boolean obj5 = object.exists;
                if (exists != null) {
                    equals = exists.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public Boolean getExists() {
        return this.exists;
    }

    public SnapshotVersion getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        int i;
        int i2;
        SnapshotVersion updateTime = this.updateTime;
        if (updateTime != null) {
            i = updateTime.hashCode();
        } else {
            i = i2;
        }
        final Boolean exists = this.exists;
        if (exists != null) {
            i2 = exists.hashCode();
        }
        return i3 += i2;
    }

    public boolean isNone() {
        Object updateTime;
        int i;
        if (this.updateTime == null && this.exists == null) {
            i = this.exists == null ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isValidFor(MutableDocument mutableDocument) {
        SnapshotVersion foundDocument;
        int i;
        boolean obj4;
        int i2 = 0;
        if (this.updateTime != null) {
            if (mutableDocument.isFoundDocument() && mutableDocument.getVersion().equals(this.updateTime)) {
                if (mutableDocument.getVersion().equals(this.updateTime)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        Boolean exists = this.exists;
        if (exists != null) {
            if (exists.booleanValue() == mutableDocument.isFoundDocument()) {
            } else {
                i = i2;
            }
            return i;
        }
        Assert.hardAssert(isNone(), "Precondition should be empty", new Object[i2]);
        return 1;
    }

    public String toString() {
        if (isNone()) {
            return "Precondition{<none>}";
        }
        String str2 = "}";
        if (this.updateTime != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Precondition{updateTime=");
            stringBuilder.append(this.updateTime);
            stringBuilder.append(str2);
            return stringBuilder.toString();
        }
        if (this.exists == null) {
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Precondition{exists=");
            stringBuilder2.append(this.exists);
            stringBuilder2.append(str2);
            return stringBuilder2.toString();
        }
        throw Assert.fail("Invalid Precondition", new Object[0]);
    }
}
