package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class d implements c {

    public final com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider a;
    public final int b;
    public d(com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i2) {
        super();
        this.a = firebaseAuthCredentialsProvider;
        this.b = i2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(this.b, j);
    }
}
