package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ObjectValue;

/* loaded from: classes2.dex */
public class DocumentViewChange {

    private final Document document;
    private final com.google.firebase.firestore.core.DocumentViewChange.Type type;

    public static enum Type {

        REMOVED,
        ADDED,
        MODIFIED,
        METADATA;
    }
    private DocumentViewChange(com.google.firebase.firestore.core.DocumentViewChange.Type documentViewChange$Type, Document document2) {
        super();
        this.type = type;
        this.document = document2;
    }

    public static com.google.firebase.firestore.core.DocumentViewChange create(com.google.firebase.firestore.core.DocumentViewChange.Type documentViewChange$Type, Document document2) {
        DocumentViewChange documentViewChange = new DocumentViewChange(type, document2);
        return documentViewChange;
    }

    public boolean equals(Object object) {
        boolean document;
        int i;
        Object obj4;
        if (!object instanceof DocumentViewChange) {
            return 0;
        }
        if (this.type.equals(object.type) && this.document.equals(object.document)) {
            if (this.document.equals(object.document)) {
                i = 1;
            }
        }
        return i;
    }

    public Document getDocument() {
        return this.document;
    }

    public com.google.firebase.firestore.core.DocumentViewChange.Type getType() {
        return this.type;
    }

    public int hashCode() {
        return i8 += i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DocumentViewChange(");
        stringBuilder.append(this.document);
        stringBuilder.append(",");
        stringBuilder.append(this.type);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
