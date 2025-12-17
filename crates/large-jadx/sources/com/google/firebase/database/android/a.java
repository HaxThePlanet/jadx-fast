package com.google.firebase.database.android;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class a implements AppCheckTokenListener {

    public final ExecutorService a;
    public final TokenProvider.TokenChangeListener b;
    public a(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2) {
        super();
        this.a = executorService;
        this.b = tokenChangeListener2;
    }

    @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        AndroidAppCheckTokenProvider.b(this.a, this.b, appCheckTokenResult);
    }
}
