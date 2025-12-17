package com.google.firebase.database.android;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class g implements Deferred.DeferredHandler {

    public final com.google.firebase.database.android.AndroidAuthTokenProvider a;
    public g(com.google.firebase.database.android.AndroidAuthTokenProvider androidAuthTokenProvider) {
        super();
        this.a = androidAuthTokenProvider;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.g(provider);
    }
}
