package com.google.firebase.database.android;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class j implements IdTokenListener {

    public final ExecutorService a;
    public final TokenProvider.TokenChangeListener b;
    public j(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2) {
        super();
        this.a = executorService;
        this.b = tokenChangeListener2;
    }

    @Override // com.google.firebase.auth.internal.IdTokenListener
    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        AndroidAuthTokenProvider.b(this.a, this.b, internalTokenResult);
    }
}
