package com.google.firebase.database.android;

import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import com.google.firebase.internal.InternalTokenResult;

/* loaded from: classes2.dex */
public final class i implements Runnable {

    public final TokenProvider.TokenChangeListener a;
    public final InternalTokenResult b;
    public i(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener, InternalTokenResult internalTokenResult2) {
        super();
        this.a = tokenChangeListener;
        this.b = internalTokenResult2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidAuthTokenProvider.a(this.a, this.b);
    }
}
