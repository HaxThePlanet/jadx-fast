package com.google.firebase.firestore.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

/* loaded from: classes2.dex */
public final class f implements IdTokenListener {

    public final com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider a;
    public f(com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider) {
        super();
        this.a = firebaseAuthCredentialsProvider;
    }

    @Override // com.google.firebase.auth.internal.IdTokenListener
    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        this.a.d(internalTokenResult);
    }
}
