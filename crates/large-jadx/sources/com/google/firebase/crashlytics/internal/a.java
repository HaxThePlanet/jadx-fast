package com.google.firebase.crashlytics.internal;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class a implements Deferred.DeferredHandler {

    public final com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy a;
    public a(com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy) {
        super();
        this.a = crashlyticsNativeComponentDeferredProxy;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.c(provider);
    }
}
