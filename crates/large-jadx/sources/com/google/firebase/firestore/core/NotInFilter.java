package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class NotInFilter extends com.google.firebase.firestore.core.FieldFilter {
    NotInFilter(FieldPath fieldPath, x x2) {
        super(fieldPath, Filter.Operator.NOT_IN, x2);
        Assert.hardAssert(Values.isArray(x2), "NotInFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        Object field;
        int i;
        x obj3;
        if (Values.contains(getValue().n(), Values.NULL_VALUE)) {
            return 0;
        }
        obj3 = document.getField(getField());
        if (obj3 != null && !Values.contains(getValue().n(), obj3)) {
            if (!Values.contains(getValue().n(), obj3)) {
                i = 1;
            }
        }
        return i;
    }
}
