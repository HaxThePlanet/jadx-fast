package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

/* loaded from: classes2.dex */
class DocumentReference {

    static final Comparator<com.google.firebase.firestore.local.DocumentReference> BY_KEY;
    static final Comparator<com.google.firebase.firestore.local.DocumentReference> BY_TARGET;
    private final DocumentKey key;
    private final int targetOrBatchId;
    static {
        DocumentReference.BY_KEY = b.a;
        DocumentReference.BY_TARGET = a.a;
    }

    public DocumentReference(DocumentKey documentKey, int i2) {
        super();
        this.key = documentKey;
        this.targetOrBatchId = i2;
    }

    static int a(com.google.firebase.firestore.local.DocumentReference documentReference, com.google.firebase.firestore.local.DocumentReference documentReference2) {
        int compareTo = documentReference.key.compareTo(documentReference2.key);
        if (compareTo != 0) {
            return compareTo;
        }
        return Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
    }

    static int b(com.google.firebase.firestore.local.DocumentReference documentReference, com.google.firebase.firestore.local.DocumentReference documentReference2) {
        int compareIntegers = Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return documentReference.key.compareTo(documentReference2.key);
    }

    int getId() {
        return this.targetOrBatchId;
    }

    DocumentKey getKey() {
        return this.key;
    }
}
