package com.google.firebase.functions;

import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class FirebaseContextProvider implements com.google.firebase.functions.ContextProvider {

    private final String TAG;
    private final AtomicReference<InternalAppCheckTokenProvider> appCheckRef;
    private final Provider<FirebaseInstanceIdInternal> instanceId;
    private final Provider<InternalAuthProvider> tokenProvider;
    FirebaseContextProvider(Provider<InternalAuthProvider> provider, Provider<FirebaseInstanceIdInternal> provider2, Deferred<InternalAppCheckTokenProvider> deferred3) {
        super();
        this.TAG = "FirebaseContextProvider";
        AtomicReference atomicReference = new AtomicReference();
        this.appCheckRef = atomicReference;
        this.tokenProvider = provider;
        this.instanceId = provider2;
        c obj2 = new c(this);
        deferred3.whenAvailable(obj2);
    }

    private j a(AppCheckTokenResult appCheckTokenResult) {
        if (appCheckTokenResult.getError() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error getting App Check token. Error: ");
            stringBuilder.append(appCheckTokenResult.getError());
            Log.w("FirebaseContextProvider", stringBuilder.toString());
            return m.e(0);
        }
        return m.e(appCheckTokenResult.getToken());
    }

    static String c(j j) {
        boolean successful;
        int obj1;
        if (!j.isSuccessful()) {
            obj1 = j.getException();
            if (obj1 instanceof FirebaseNoSignedInUserException == null) {
            } else {
                obj1 = 0;
                return obj1;
            }
            throw obj1;
        }
        obj1 = (GetTokenResult)j.getResult().getToken();
    }

    private j d(j j, j j2, Void void3) {
        HttpsCallableContext obj4 = new HttpsCallableContext((String)j.getResult(), (FirebaseInstanceIdInternal)this.instanceId.get().getToken(), (String)j2.getResult());
        return m.e(obj4);
    }

    static void f(AppCheckTokenResult appCheckTokenResult) {
    }

    private void g(Provider provider) {
        final Object obj2 = provider.get();
        this.appCheckRef.set((InternalAppCheckTokenProvider)obj2);
        obj2.addAppCheckTokenListener(e.a);
    }

    private j<String> getAppCheckToken() {
        Object obj = this.appCheckRef.get();
        if ((InternalAppCheckTokenProvider)obj == null) {
            return m.e(0);
        }
        d dVar = new d(this);
        return (InternalAppCheckTokenProvider)obj.getToken(false).onSuccessTask(dVar);
    }

    private j<String> getAuthToken() {
        Object obj = this.tokenProvider.get();
        if ((InternalAuthProvider)obj == null) {
            return m.e(0);
        }
        return (InternalAuthProvider)obj.getAccessToken(false).continueWith(a.a);
    }

    @Override // com.google.firebase.functions.ContextProvider
    public j b(AppCheckTokenResult appCheckTokenResult) {
        return a(appCheckTokenResult);
    }

    @Override // com.google.firebase.functions.ContextProvider
    public j e(j j, j j2, Void void3) {
        return d(j, j2, void3);
    }

    public j<com.google.firebase.functions.HttpsCallableContext> getContext() {
        j authToken = getAuthToken();
        final j appCheckToken = getAppCheckToken();
        j[] arr = new j[2];
        b bVar = new b(this, authToken, appCheckToken);
        return m.g(authToken, appCheckToken).onSuccessTask(bVar);
    }

    @Override // com.google.firebase.functions.ContextProvider
    public void h(Provider provider) {
        g(provider);
    }
}
