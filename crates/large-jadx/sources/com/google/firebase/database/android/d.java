package com.google.firebase.database.android;

import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class d implements Deferred.DeferredHandler {

    public final com.google.firebase.database.android.AndroidAppCheckTokenProvider a;
    public d(com.google.firebase.database.android.AndroidAppCheckTokenProvider androidAppCheckTokenProvider) {
        super();
        this.a = androidAppCheckTokenProvider;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        this.a.g(provider);
    }
}
