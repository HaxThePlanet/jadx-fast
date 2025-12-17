package com.google.firebase.firestore.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_FieldIndex_Segment extends com.google.firebase.firestore.model.FieldIndex.Segment {

    private final com.google.firebase.firestore.model.FieldPath fieldPath;
    private final com.google.firebase.firestore.model.FieldIndex.Segment.Kind kind;
    AutoValue_FieldIndex_Segment(com.google.firebase.firestore.model.FieldPath fieldPath, com.google.firebase.firestore.model.FieldIndex.Segment.Kind fieldIndex$Segment$Kind2) {
        super();
        Objects.requireNonNull(fieldPath, "Null fieldPath");
        this.fieldPath = fieldPath;
        Objects.requireNonNull(kind2, "Null kind");
        this.kind = kind2;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex$Segment
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof FieldIndex.Segment) {
            if (this.fieldPath.equals((FieldIndex.Segment)object.getFieldPath()) && this.kind.equals(object.getKind())) {
                if (this.kind.equals(object.getKind())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex$Segment
    public com.google.firebase.firestore.model.FieldPath getFieldPath() {
        return this.fieldPath;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex$Segment
    public com.google.firebase.firestore.model.FieldIndex.Segment.Kind getKind() {
        return this.kind;
    }

    @Override // com.google.firebase.firestore.model.FieldIndex$Segment
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }
}
