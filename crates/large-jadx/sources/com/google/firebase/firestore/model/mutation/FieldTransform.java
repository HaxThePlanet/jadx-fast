package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;

/* loaded from: classes2.dex */
public final class FieldTransform {

    private final FieldPath fieldPath;
    private final com.google.firebase.firestore.model.mutation.TransformOperation operation;
    public FieldTransform(FieldPath fieldPath, com.google.firebase.firestore.model.mutation.TransformOperation transformOperation2) {
        super();
        this.fieldPath = fieldPath;
        this.operation = transformOperation2;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.mutation.FieldTransform> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (FieldTransform.class != object.getClass()) {
            } else {
                if (!this.fieldPath.equals(object.fieldPath)) {
                    return i;
                }
            }
            return this.operation.equals(object.operation);
        }
        return i;
    }

    public FieldPath getFieldPath() {
        return this.fieldPath;
    }

    public com.google.firebase.firestore.model.mutation.TransformOperation getOperation() {
        return this.operation;
    }

    public int hashCode() {
        return i2 += i4;
    }
}
