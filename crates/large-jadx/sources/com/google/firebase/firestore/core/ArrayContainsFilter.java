package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class ArrayContainsFilter extends com.google.firebase.firestore.core.FieldFilter {
    ArrayContainsFilter(FieldPath fieldPath, x x2) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS, x2);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        boolean array;
        x obj2;
        obj2 = document.getField(getField());
        if (Values.isArray(obj2) && Values.contains(obj2.n(), getValue())) {
            obj2 = Values.contains(obj2.n(), getValue()) ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
