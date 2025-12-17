package com.google.firebase.inappmessaging.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class t1 implements Deferred.DeferredHandler {

    public final com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle a;
    public final String b;
    public final AnalyticsConnector.AnalyticsConnectorListener c;
    public t1(com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector.ProxyAnalyticsConnectorHandle proxyAnalyticsConnector$ProxyAnalyticsConnectorHandle, String string2, AnalyticsConnector.AnalyticsConnectorListener analyticsConnector$AnalyticsConnectorListener3) {
        super();
        this.a = proxyAnalyticsConnectorHandle;
        this.b = string2;
        this.c = analyticsConnectorListener3;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.b(this.b, this.c, provider);
    }
}
