package com.google.firebase.firestore;

import com.google.firebase.firestore.core.AsyncEventListener;

/* loaded from: classes2.dex */
public final class i implements com.google.firebase.firestore.ListenerRegistration {

    public final com.google.firebase.firestore.FirebaseFirestore a;
    public final AsyncEventListener b;
    public i(com.google.firebase.firestore.FirebaseFirestore firebaseFirestore, AsyncEventListener asyncEventListener2) {
        super();
        this.a = firebaseFirestore;
        this.b = asyncEventListener2;
    }

    @Override // com.google.firebase.firestore.ListenerRegistration
    public final void remove() {
        this.a.c(this.b);
    }
}
