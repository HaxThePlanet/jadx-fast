package com.google.firebase.firestore;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class a implements c {

    public final com.google.firebase.firestore.DocumentReference a;
    public a(com.google.firebase.firestore.DocumentReference documentReference) {
        super();
        this.a = documentReference;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        final com.google.firebase.firestore.DocumentReference documentReference = this.a;
        CollectionReference.f(documentReference, j);
        return documentReference;
    }
}
