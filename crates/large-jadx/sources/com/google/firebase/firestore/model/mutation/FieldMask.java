package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class FieldMask {

    private final Set<FieldPath> mask;
    private FieldMask(Set<FieldPath> set) {
        super();
        this.mask = set;
    }

    public static com.google.firebase.firestore.model.mutation.FieldMask fromSet(Set<FieldPath> set) {
        FieldMask fieldMask = new FieldMask(set);
        return fieldMask;
    }

    public boolean covers(FieldPath fieldPath) {
        boolean prefixOf;
        Iterator iterator = this.mask.iterator();
        for (FieldPath next2 : iterator) {
        }
        return 0;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.model.mutation.FieldMask> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && FieldMask.class != object.getClass()) {
            if (FieldMask.class != object.getClass()) {
            }
            return this.mask.equals(object.mask);
        }
        return 0;
    }

    public Set<FieldPath> getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FieldMask{mask=");
        stringBuilder.append(this.mask.toString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
