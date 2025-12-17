package com.google.firebase.firestore;

import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class c implements com.google.firebase.firestore.EventListener {

    public final k a;
    public final k b;
    public final com.google.firebase.firestore.Source c;
    public c(k k, k k2, com.google.firebase.firestore.Source source3) {
        super();
        this.a = k;
        this.b = k2;
        this.c = source3;
    }

    @Override // com.google.firebase.firestore.EventListener
    public final void onEvent(Object object, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException2) {
        DocumentReference.e(this.a, this.b, this.c, (DocumentSnapshot)object, firebaseFirestoreException2);
    }
}
