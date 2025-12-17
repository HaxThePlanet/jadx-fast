package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class KeyFieldFilter extends com.google.firebase.firestore.core.FieldFilter {

    private final DocumentKey key;
    KeyFieldFilter(FieldPath fieldPath, com.google.firebase.firestore.core.Filter.Operator filter$Operator2, x x3) {
        super(fieldPath, operator2, x3);
        Assert.hardAssert(Values.isReferenceValue(x3), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.key = DocumentKey.fromName(getValue().u());
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        return matchesComparison(document.getKey().compareTo(this.key));
    }
}
