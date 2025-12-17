package com.google.firebase.firestore.core;

import java.util.List;

/* loaded from: classes2.dex */
public class ViewChange {

    private final List<com.google.firebase.firestore.core.LimboDocumentChange> limboChanges;
    private final com.google.firebase.firestore.core.ViewSnapshot snapshot;
    public ViewChange(com.google.firebase.firestore.core.ViewSnapshot viewSnapshot, List<com.google.firebase.firestore.core.LimboDocumentChange> list2) {
        super();
        this.snapshot = viewSnapshot;
        this.limboChanges = list2;
    }

    public List<com.google.firebase.firestore.core.LimboDocumentChange> getLimboChanges() {
        return this.limboChanges;
    }

    public com.google.firebase.firestore.core.ViewSnapshot getSnapshot() {
        return this.snapshot;
    }
}
