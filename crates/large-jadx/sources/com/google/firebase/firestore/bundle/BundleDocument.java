package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;

/* loaded from: classes2.dex */
public class BundleDocument implements com.google.firebase.firestore.bundle.BundleElement {

    private MutableDocument document;
    public BundleDocument(MutableDocument mutableDocument) {
        super();
        this.document = mutableDocument;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public boolean equals(Object object) {
        Class class2;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && getClass() != object.getClass()) {
            if (getClass() != object.getClass()) {
            }
            return this.document.equals(object.document);
        }
        return 0;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public MutableDocument getDocument() {
        return this.document;
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public DocumentKey getKey() {
        return this.document.getKey();
    }

    @Override // com.google.firebase.firestore.bundle.BundleElement
    public int hashCode() {
        return this.document.hashCode();
    }
}
