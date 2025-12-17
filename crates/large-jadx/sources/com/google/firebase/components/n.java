package com.google.firebase.components;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class n implements Deferred.DeferredHandler {

    public final Deferred.DeferredHandler a;
    public final Deferred.DeferredHandler b;
    public n(Deferred.DeferredHandler deferred$DeferredHandler, Deferred.DeferredHandler deferred$DeferredHandler2) {
        super();
        this.a = deferredHandler;
        this.b = deferredHandler2;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        OptionalProvider.c(this.a, this.b, provider);
    }
}
