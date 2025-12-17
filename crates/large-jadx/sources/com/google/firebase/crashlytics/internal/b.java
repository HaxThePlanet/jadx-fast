package com.google.firebase.crashlytics.internal;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class b implements Deferred.DeferredHandler {

    public final String a;
    public b(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy.a(this.a, provider);
    }
}
