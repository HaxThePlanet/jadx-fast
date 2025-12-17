package com.google.firebase.functions;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class c implements Deferred.DeferredHandler {

    public final com.google.firebase.functions.FirebaseContextProvider a;
    public c(com.google.firebase.functions.FirebaseContextProvider firebaseContextProvider) {
        super();
        this.a = firebaseContextProvider;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.h(provider);
    }
}
