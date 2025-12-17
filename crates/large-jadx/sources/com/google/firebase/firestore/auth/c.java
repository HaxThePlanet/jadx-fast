package com.google.firebase.firestore.auth;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;

/* loaded from: classes2.dex */
public final class c implements AppCheckTokenListener {

    public final com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider a;
    public c(com.google.firebase.firestore.auth.FirebaseAppCheckTokenProvider firebaseAppCheckTokenProvider) {
        super();
        this.a = firebaseAppCheckTokenProvider;
    }

    @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        this.a.c(appCheckTokenResult);
    }
}
