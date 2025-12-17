package com.google.firebase.database.android;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.database.core.TokenProvider.TokenChangeListener;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final TokenProvider.TokenChangeListener a;
    public final AppCheckTokenResult b;
    public c(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener, AppCheckTokenResult appCheckTokenResult2) {
        super();
        this.a = tokenChangeListener;
        this.b = appCheckTokenResult2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidAppCheckTokenProvider.a(this.a, this.b);
    }
}
