package com.google.firebase.database.android;

import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class l implements Deferred.DeferredHandler {

    public final ExecutorService a;
    public final TokenProvider.TokenChangeListener b;
    public l(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2) {
        super();
        this.a = executorService;
        this.b = tokenChangeListener2;
    }

    @Override // com.google.firebase.inject.Deferred$DeferredHandler
    public final void handle(Provider provider) {
        AndroidAuthTokenProvider.c(this.a, this.b, provider);
    }
}
