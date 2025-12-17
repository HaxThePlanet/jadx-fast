package com.google.firebase.functions;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;

/* loaded from: classes2.dex */
public final class e implements AppCheckTokenListener {

    public static final com.google.firebase.functions.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        FirebaseContextProvider.f(appCheckTokenResult);
    }
}
