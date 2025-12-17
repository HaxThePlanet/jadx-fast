package com.google.firebase.firestore.auth;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class e implements Deferred.DeferredHandler {

    public final com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider a;
    public e(com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider) {
        super();
        this.a = firebaseAuthCredentialsProvider;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.f(provider);
    }
}
