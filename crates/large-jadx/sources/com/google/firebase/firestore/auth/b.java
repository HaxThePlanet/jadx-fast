package com.google.firebase.firestore.auth;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class b implements Deferred.DeferredHandler {

    public final com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider a;
    public b(com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider firebaseAppCheckTokenProvider) {
        super();
        this.a = firebaseAppCheckTokenProvider;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.e(provider);
    }
}
