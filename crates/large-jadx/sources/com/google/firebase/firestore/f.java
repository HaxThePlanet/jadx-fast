package com.google.firebase.firestore;

/* loaded from: classes2.dex */
public final class f implements com.google.firebase.firestore.EventListener {

    public final Runnable a;
    public f(Runnable runnable) {
        super();
        this.a = runnable;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException2) {
        FirebaseFirestore.a(this.a, (Void)object, firebaseFirestoreException2);
    }
}
