package com.google.firebase.database.android;

import com.google.android.gms.tasks.j;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.database.core.TokenProvider.GetTokenCompletionListener;
import com.google.firebase.database.core.TokenProvider.TokenChangeListener;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class AndroidAuthTokenProvider implements TokenProvider {

    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth;
    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        super();
        this.deferredAuthProvider = deferred;
        AtomicReference atomicReference = new AtomicReference();
        this.internalAuth = atomicReference;
        g gVar = new g(this);
        deferred.whenAvailable(gVar);
    }

    static void a(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener, InternalTokenResult internalTokenResult2) {
        tokenChangeListener.onTokenChange(internalTokenResult2.getToken());
    }

    static void b(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2, InternalTokenResult internalTokenResult3) {
        i iVar = new i(tokenChangeListener2, internalTokenResult3);
        executorService.execute(iVar);
    }

    static void c(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2, Provider provider3) {
        j jVar = new j(executorService, tokenChangeListener2);
        (InternalAuthProvider)provider3.get().addIdTokenListener(jVar);
    }

    static void d(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener, GetTokenResult getTokenResult2) {
        getTokenCompletionListener.onSuccess(getTokenResult2.getToken());
    }

    static void e(TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener, Exception exception2) {
        int obj2;
        if (AndroidAuthTokenProvider.isUnauthenticatedUsage(exception2)) {
            getTokenCompletionListener.onSuccess(0);
        } else {
            getTokenCompletionListener.onError(exception2.getMessage());
        }
    }

    private void f(Provider provider) {
        this.internalAuth.set((InternalAuthProvider)provider.get());
    }

    private static boolean isUnauthenticatedUsage(Exception exception) {
        int obj1;
        if (exception instanceof FirebaseApiNotAvailableException == null) {
            if (exception instanceof FirebaseNoSignedInUserException != null) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener2) {
        l lVar = new l(executorService, tokenChangeListener2);
        this.deferredAuthProvider.whenAvailable(lVar);
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void g(Provider provider) {
        f(provider);
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener tokenProvider$GetTokenCompletionListener2) {
        Object kVar;
        j obj2;
        kVar = this.internalAuth.get();
        if ((InternalAuthProvider)kVar != null) {
            h hVar = new h(getTokenCompletionListener2);
            kVar = new k(getTokenCompletionListener2);
            (InternalAuthProvider)kVar.getAccessToken(z).addOnSuccessListener(hVar).addOnFailureListener(kVar);
        } else {
            getTokenCompletionListener2.onSuccess(0);
        }
    }

    @Override // com.google.firebase.database.core.TokenProvider
    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenProvider$TokenChangeListener) {
    }
}
