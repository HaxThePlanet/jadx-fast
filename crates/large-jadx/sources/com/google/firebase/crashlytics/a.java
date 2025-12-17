package com.google.firebase.crashlytics;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class a implements Deferred.DeferredHandler {

    public final com.google.firebase.crashlytics.AnalyticsDeferredProxy a;
    public a(com.google.firebase.crashlytics.AnalyticsDeferredProxy analyticsDeferredProxy) {
        super();
        this.a = analyticsDeferredProxy;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.f(provider);
    }
}
