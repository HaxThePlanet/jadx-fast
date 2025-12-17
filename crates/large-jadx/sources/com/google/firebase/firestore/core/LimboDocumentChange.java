package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;

/* loaded from: classes2.dex */
public class LimboDocumentChange {

    private final DocumentKey key;
    private final com.google.firebase.firestore.core.LimboDocumentChange.Type type;

    public static enum Type {

        ADDED,
        REMOVED;
    }
    public LimboDocumentChange(com.google.firebase.firestore.core.LimboDocumentChange.Type limboDocumentChange$Type, DocumentKey documentKey2) {
        super();
        this.type = type;
        this.key = documentKey2;
    }

    public boolean equals(Object object) {
        boolean equals;
        int i;
        Object obj4;
        if (!object instanceof LimboDocumentChange) {
            return 0;
        }
        if (this.type.equals((LimboDocumentChange)object.getType()) && this.key.equals(object.getKey())) {
            if (this.key.equals(object.getKey())) {
                i = 1;
            }
        }
        return i;
    }

    public DocumentKey getKey() {
        return this.key;
    }

    public com.google.firebase.firestore.core.LimboDocumentChange.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return i5 += i2;
    }
}
