package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.a;
import f.c.e.c.x;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ArrayContainsAnyFilter extends com.google.firebase.firestore.core.FieldFilter {
    ArrayContainsAnyFilter(FieldPath fieldPath, x x2) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, x2);
        Assert.hardAssert(Values.isArray(x2), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        boolean contains;
        a aVar;
        x obj4 = document.getField(getField());
        final int i = 0;
        if (!Values.isArray(obj4)) {
            return i;
        }
        obj4 = obj4.n().a().iterator();
        for (x next2 : obj4) {
        }
        return i;
    }
}
