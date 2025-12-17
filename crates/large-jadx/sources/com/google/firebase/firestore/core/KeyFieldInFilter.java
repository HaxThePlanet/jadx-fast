package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.a;
import f.c.e.c.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class KeyFieldInFilter extends com.google.firebase.firestore.core.FieldFilter {

    private final List<DocumentKey> keys;
    KeyFieldInFilter(FieldPath fieldPath, x x2) {
        final com.google.firebase.firestore.core.Filter.Operator iN = Filter.Operator.IN;
        super(fieldPath, iN, x2);
        ArrayList obj2 = new ArrayList();
        this.keys = obj2;
        obj2.addAll(KeyFieldInFilter.extractDocumentKeysFromArrayValue(iN, x2));
    }

    static List<DocumentKey> extractDocumentKeysFromArrayValue(com.google.firebase.firestore.core.Filter.Operator filter$Operator, x x2) {
        int i;
        com.google.firebase.firestore.core.Filter.Operator nOT_IN;
        Object[] name;
        String referenceValue;
        String string;
        Object[] arr;
        final int i2 = 0;
        if (operator != Filter.Operator.IN) {
            if (operator == Filter.Operator.NOT_IN) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        Assert.hardAssert(i, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[i2]);
        Assert.hardAssert(Values.isArray(x2), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[i2]);
        ArrayList arrayList = new ArrayList();
        Iterator obj7 = x2.n().a().iterator();
        for (x next2 : obj7) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Comparing on key with ");
            stringBuilder.append(operator.toString());
            stringBuilder.append(", but an array value was not a ReferenceValue");
            Assert.hardAssert(Values.isReferenceValue(next2), stringBuilder.toString(), new Object[i2]);
            arrayList.add(DocumentKey.fromName(next2.u()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.core.FieldFilter
    public boolean matches(Document document) {
        return this.keys.contains(document.getKey());
    }
}
