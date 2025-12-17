package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public final class b implements com.google.firebase.firestore.EventListener {

    public final com.google.firebase.firestore.DocumentReference a;
    public final com.google.firebase.firestore.EventListener b;
    public b(com.google.firebase.firestore.DocumentReference documentReference, com.google.firebase.firestore.EventListener eventListener2) {
        super();
        this.a = documentReference;
        this.b = eventListener2;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException2) {
        this.a.b(this.b, (ViewSnapshot)object, firebaseFirestoreException2);
    }
}
