package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class KeyFieldNotInFilter extends com.google.firebase.firestore.core.FieldFilter {

    private final List<DocumentKey> keys;
    KeyFieldNotInFilter(FieldPath fieldPath, x x2) {
        final com.google.firebase.firestore.core.Filter.Operator nOT_IN = Filter.Operator.NOT_IN;
        super(fieldPath, nOT_IN, x2);
        ArrayList obj2 = new ArrayList();
        this.keys = obj2;
        obj2.addAll(KeyFieldInFilter.extractDocumentKeysFromArrayValue(nOT_IN, x2));
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        return obj2 ^= 1;
    }
}
