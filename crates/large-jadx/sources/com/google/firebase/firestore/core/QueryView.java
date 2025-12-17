package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
final class QueryView {

    private final com.google.firebase.firestore.core.Query query;
    private final int targetId;
    private final com.google.firebase.firestore.core.View view;
    QueryView(com.google.firebase.firestore.core.Query query, int i2, com.google.firebase.firestore.core.View view3) {
        super();
        this.query = query;
        this.targetId = i2;
        this.view = view3;
    }

    public com.google.firebase.firestore.core.Query getQuery() {
        return this.query;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public com.google.firebase.firestore.core.View getView() {
        return this.view;
    }
}
