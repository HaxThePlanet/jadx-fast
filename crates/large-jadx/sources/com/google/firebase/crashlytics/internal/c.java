package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class c implements Deferred.DeferredHandler {

    public final String a;
    public final String b;
    public final long c;
    public final StaticSessionData d;
    public c(String string, String string2, long l3, StaticSessionData staticSessionData4) {
        super();
        this.a = string;
        this.b = string2;
        this.c = l3;
        this.d = obj5;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        CrashlyticsNativeComponentDeferredProxy.d(this.a, this.b, this.c, obj3, this.d);
    }
}
