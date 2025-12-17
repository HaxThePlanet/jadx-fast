package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class u1 implements Deferred.DeferredHandler {

    public final com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector a;
    public u1(com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector proxyAnalyticsConnector) {
        super();
        this.a = proxyAnalyticsConnector;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.b(provider);
    }
}
