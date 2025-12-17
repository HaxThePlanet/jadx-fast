package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class InFilter extends com.google.firebase.firestore.core.FieldFilter {
    InFilter(FieldPath fieldPath, x x2) {
        super(fieldPath, Filter.Operator.IN, x2);
        Assert.hardAssert(Values.isArray(x2), "InFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        Object field;
        x obj2;
        obj2 = document.getField(getField());
        if (obj2 != null && Values.contains(getValue().n(), obj2)) {
            obj2 = Values.contains(getValue().n(), obj2) ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
