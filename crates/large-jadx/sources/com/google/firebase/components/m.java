package com.google.firebase.components;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class m implements Deferred.DeferredHandler {

    public static final com.google.firebase.components.m a;
    static {
        m mVar = new m();
        m.a = mVar;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        OptionalProvider.a(provider);
    }
}
